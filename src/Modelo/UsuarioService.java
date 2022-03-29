package Modelo;

import Controlador.PostgreSQL;
import java.util.ArrayList;


public class UsuarioService {
    private PostgreSQL cPostgres;
    private ArrayList<Cinta> EncontrarCinta;
    private Usuario Usuario;
    private Empleado Empleado;

    public UsuarioService() {
        cPostgres = new PostgreSQL();
        this.EncontrarCinta = new ArrayList<Cinta>();
    }
    
    public void ActualizarEstadoCinta(String idCinta){
        cPostgres.ActualizarEstadoCinta(idCinta);
    }
    
    public void InsertarDetallePrestamo(String item, String idEstadoFk, String Valor) {
        cPostgres.InsertarDetallePrestamo(item, idEstadoFk, Valor);
    }
    
    public void InsertarPrestamo(String idMembresiaFk, String IdEmpleadoFk) {
        cPostgres.InsertarPrestamo(idMembresiaFk, IdEmpleadoFk);
    }
    
    public boolean encontrarCinta(String cinta){
        cPostgres.cargarDatosCintas();  
        if(cPostgres.verificarCinta(cinta).isEmpty()){
            return false;
        }else{
            this.EncontrarCinta = cPostgres.verificarCinta(cinta);
            return true;
        }
    }
    
    public boolean encontrarCintaActor(String Actor){
        this.EncontrarCinta = cPostgres.verificarCintaActor(Actor);
        if(this.EncontrarCinta.size()!=0){
            return true;
        }else{
            return false;
        }
    }

    public boolean verificarEmpleado(String nombreUsuario, String claveUsuario) {
        if (cPostgres.verificarEmpleado(nombreUsuario, claveUsuario)) {
            this.Empleado = cPostgres.getEmpleado();
            return true;
        }
        return false;
    }
    
    public boolean verificarUsuario(String idUsuario){
        if (cPostgres.confirmarUsuario(idUsuario)) {
            this.Usuario = cPostgres.getUsuario();
            return true;
        }
        return false;
    }
    
    public void registarDatosUsuario(String nombre, String apellido,
            String telefono, String direccion, String credito, String email){
        cPostgres.InsertarDatos(nombre, apellido, telefono, direccion,
                credito, email);
    }
    
    public void cerrarConexion(){
        cPostgres.cerrarConexion();
    }
    
    public Usuario getUsuario() {
        return Usuario;
    }

    public Empleado getEmpleado() {
        return Empleado;
    }

    public ArrayList<Cinta> getEncontrarCinta() {
        return EncontrarCinta;
    }

    public void setEncontrarCinta(ArrayList<Cinta> EncontrarCinta) {
        this.EncontrarCinta = EncontrarCinta;
    }
    
    

}
