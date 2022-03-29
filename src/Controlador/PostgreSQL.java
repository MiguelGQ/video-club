/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cinta;
import Modelo.Empleado;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class PostgreSQL {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Empleado> empleados;
    private ArrayList<Cinta> cintas;
    private ArrayList<Cinta> actcintas;
    private ArrayList<String> Actores;
    private Usuario Usuario;
    private Empleado Empleado;
    Connection connection;
    Statement stmt;
    ResultSet rs;
    String n;

    public PostgreSQL() {
        empleados = new ArrayList<Empleado>();
        usuarios = new ArrayList<Usuario>();
        Actores = new ArrayList<String>();
        Usuario = new Usuario();
        Empleado = new Empleado();
        this.connectDatabase();
        this.cargarDatos();
    }

    public void connectDatabase() {
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            connection = null;
            // Database connect
            // Conectamos con la base de datos
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Tienda_videos",
                    "postgres", "123456");

            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
            connection.setAutoCommit(false);
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public void cargarDatos() {
        stmt = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT idempleado, usuario, password from EMPLEADO");
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setClaveUsuario(rs.getString("password"));
                empleado.setEmpleadoUsuario(rs.getString("usuario"));
                empleado.setIdEmpleado(rs.getString("idempleado"));
                empleados.add(empleado);
            }
            rs = stmt.executeQuery("SELECT idmembresia, concat(nombre, concat(' ',apellido)) nombre, email from USUARIO");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getString("idmembresia"));
                usuario.setNombreUsuario(rs.getString("nombre"));
                usuario.setCorreoUsuario(rs.getString("email"));
                usuarios.add(usuario);
            }
            rs = stmt.executeQuery("select nombrereal from Actor;");
            while (rs.next()) {
                Actores.add(rs.getString("nombrereal"));
            }
            stmt.close();
            connection.commit();
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public void cargarDatosCintas() {
        stmt = null;
        try {
            cintas = new ArrayList<Cinta>();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT C.idcinta, P.titulo, E.idestado from PELICULA P, CINTA C, ESTADO E WHERE P.idpelicula = C.idpeliculafk and C.idestadofk = E.idestado and UPPER(C.idestadofk) LIKE '%L%';");
            while (rs.next()) {
                Cinta cinta = new Cinta();
                cinta.setIdCinta(rs.getString("idcinta"));
                cinta.setNomPelicula(rs.getString("titulo"));
                cinta.setEstadoPelicula(rs.getString("idestado"));
                cintas.add(cinta);
            }
            stmt.close();
            connection.commit();
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public void cargarDatosCintasActor(String nomActor) {
        stmt = null;
        try {
            actcintas = new ArrayList<Cinta>();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT C.idcinta, P.titulo,A.nombrereal,E.idestado from PELICULA P, CINTA C, ESTADO E, PELICULAACTOR PA, ACTOR A WHERE A.idactor = PA.idactorfk and PA.idpeliculafk = P.idpelicula and P.idpelicula = C.idpeliculafk and C.idestadofk = E.idestado and UPPER(C.idestadofk) LIKE '%L%'and UPPER(A.nombrereal) LIKE '%" + nomActor + "%';");
            while (rs.next()) {
                Cinta cinta = new Cinta();
                cinta.setIdCinta(rs.getString("idcinta"));
                cinta.setNomPelicula(rs.getString("titulo"));
                cinta.setEstadoPelicula(rs.getString("idestado"));
                cinta.setActor(rs.getString("nombrereal"));
                actcintas.add(cinta);
            }
            stmt.close();
            connection.commit();
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public ArrayList verificarCinta(String esCinta) {
        ArrayList<Cinta> EncontrarCinta = new ArrayList<Cinta>();
        for (Cinta cinta : cintas) {
            if (cinta.getNomPelicula().toUpperCase().contains(esCinta)) {
                EncontrarCinta.add(cinta);
            }
        }
        return EncontrarCinta;
    }

    public ArrayList verificarCintaActor(String nomActor) {
        for (int i = 0; i < Actores.size(); i++) {
            if (Actores.get(i).toUpperCase().contains(nomActor)) {
                this.cargarDatosCintasActor(nomActor);
                return actcintas;
            }
        }
        actcintas.clear();
        return actcintas;
    }

    public boolean verificarEmpleado(String empleadoUsuario, String claveUsuario) {
        for (Empleado empleado : empleados) {
            if (empleado.getEmpleadoUsuario().equals(empleadoUsuario)) {
                if (empleado.getClaveUsuario().equals(claveUsuario)) {
                    this.Empleado = empleado;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean confirmarUsuario(String idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                this.Usuario = usuario;
                return true;
            }
        }
        return false;
    }

    public void InsertarPrestamo(String idMembresiaFk, String IdEmpleadoFk) {
        stmt = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT max(idprestamo) from PRESTAMO");
            while (rs.next()) {
                n = rs.getString(1);
            }
            int i;
            try {
                i = Integer.parseInt(n);
            } catch (NumberFormatException e) {
                i = 0;
            }
            String sql = "INSERT INTO PRESTAMO VALUES ('" + (i + 1) + "', '" + idMembresiaFk + "', '" + IdEmpleadoFk + "','now( )');";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public void InsertarDetallePrestamo(String item, String idEstadoFk, String Valor) {
        stmt = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT max(idprestamo) from PRESTAMO");
            while (rs.next()) {
                n = rs.getString(1);
            }
            int i = Integer.parseInt(n);
            String sql = "INSERT INTO DETALLEPRESTAMO VALUES ('" + i + "', '" + item + "', '" + idEstadoFk + "','" + Valor + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public void ActualizarEstadoCinta(String idCinta) {
        stmt = null;
        try {
            PreparedStatement stmt;
            stmt = connection.prepareStatement("UPDATE CINTA SET idestadofk='P' WHERE idcinta=?");
            stmt.setString(1, idCinta);
            int retorno = stmt.executeUpdate();
            stmt.close();
            connection.commit();
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public void InsertarDatos(String nombre, String apellido,
            String telefono, String direccion, String credito, String email) {
        stmt = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT max(idmembresia) from USUARIO");
            while (rs.next()) {
                n = rs.getString(1);
            }
            int i = Integer.parseInt(n);
            String sql = "INSERT INTO USUARIO VALUES ('" + (i + 1) + "', initcap('" + nombre + "'), initcap('" + apellido + "'),'" + telefono + "','" + direccion + "','" + credito + "',lower('" + email + "'));";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public void registrarEmpleados(String id, String nombre, String apellido, String usuario, String pass) {
        stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO EMPLEADO VALUES ('" + id + "', '" + nombre + "', '" + apellido + "','" + usuario + "','" + pass + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public void cerrarConexion() {
        try {
            connection.close();
            System.out.println("Conexion off");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public Empleado getEmpleado() {
        return Empleado;
    }
}
