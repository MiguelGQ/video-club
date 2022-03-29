/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.PostgreSQL;
import Modelo.Cinta;
import Modelo.EmailSenderService;
import Modelo.Empleado;
import Modelo.Usuario;
import Modelo.UsuarioService;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class PrestamoComponent implements ActionListener, FocusListener {

    private PrestamoTemplate vistaPrestamo;
    private AdminComponent vistaAdmin;
    private UsuarioService sUsuario;
    private Usuario usuario;
    private Empleado empleado;
    private ArrayList<Cinta> Cinta;
    private ArrayList<Cinta> cintasCliente;
    private ArrayList<String> valorCintasCliente;
    private ArrayList<Integer> itemCintasCliente;
    private EmailSenderService mail;

    public PrestamoComponent(AdminComponent vistaAdmin, UsuarioService sUsuario) {
        this.vistaAdmin = vistaAdmin;
        this.sUsuario = sUsuario;
        this.mail = new EmailSenderService();
        this.Cinta = new ArrayList<Cinta>();
        this.cintasCliente = new ArrayList<Cinta>();
        this.valorCintasCliente = new ArrayList<String>();
        this.itemCintasCliente = new ArrayList<Integer>();
        this.empleado = new Empleado();
        this.empleado = sUsuario.getEmpleado();
        vistaPrestamo = new PrestamoTemplate(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPrestamo.getbSalir()) {
            sUsuario.cerrarConexion();
            System.exit(0);
        }
        if (e.getSource() == vistaPrestamo.getbBusqueda()) {
            Busqueda();
        }
        if (e.getSource() == vistaPrestamo.getbAgregar()) {
            cintaCliente();

        }
        if (e.getSource() == vistaPrestamo.getbGuardar()) {
            Guardar();
        }
    }

    public void Guardar() {
        if (this.cintasCliente.isEmpty()) {
        } else {
            this.InsetarPrestamo();
            this.InsertarDetallePrestamo();
            this.ActualizarEstadoCinta();
            this.NotificarClientePrestamo();
            this.Reiniciar();
        }
    }

    public void InsetarPrestamo() {
        sUsuario.InsertarPrestamo(usuario.getIdUsuario(), empleado.getIdEmpleado());
    }

    public void InsertarDetallePrestamo() {
        for (int i = 0; i < cintasCliente.size(); i++) {
            sUsuario.InsertarDetallePrestamo(this.itemCintasCliente.get(i)+"", this.cintasCliente.get(i).getEstadoPelicula(), this.valorCintasCliente.get(i));
        }
    }

    public void ActualizarEstadoCinta() {
        for(int i = 0; i < cintasCliente.size() ; i++){
            sUsuario.ActualizarEstadoCinta(this.cintasCliente.get(i).getIdCinta());
        }
    }

    public void NotificarClientePrestamo() {
        String cCliente="Id  Nombre Cinta \n";
        String Mensaje;
        for(int i = 0; i<cintasCliente.size(); i++){
            cCliente = cCliente + cintasCliente.get(i).getIdCinta() +"   "+cintasCliente.get(i).getNomPelicula()+" \n";
        }
        Mensaje = "Señor(a) "+usuario.getNombreUsuario()+" la lista de peliculas que saco en prestamo es la siguiente: \n"+
                    cCliente+
                    "\nGracias por usar nuestros servicios. HEIMDALL";
        mail.sendEmail(usuario.getCorreoUsuario(), Mensaje);
    }
    
    public void Reiniciar(){
        this.mail = new EmailSenderService();
        this.Cinta = new ArrayList<Cinta>();
        this.cintasCliente = new ArrayList<Cinta>();
        this.valorCintasCliente = new ArrayList<String>();
        this.itemCintasCliente = new ArrayList<Integer>();
        this.empleado = new Empleado();
        this.empleado = sUsuario.getEmpleado();
        vistaPrestamo.getpDerecha().removeAll();
        vistaPrestamo.getpIzquierda().removeAll();
        vistaPrestamo.getlNombreCliente().setText("");
        vistaPrestamo.gettNombreUsuario().setText("Membresia de Usuario");
        vistaPrestamo.gettBuscarPelicula().setText("Pelicula o Actor");
        vistaPrestamo.gettCinta().setText("ID Cinta");
        vistaPrestamo.gettValorCinta().setText("Valor Cinta");
        vistaPrestamo.repaint();
    }

    public void Busqueda() {
        if (verificarCampos()) {
            if (sUsuario.verificarUsuario(vistaPrestamo.gettNombreUsuario().getText())) {
                usuario = new Usuario();
                usuario = sUsuario.getUsuario();
                vistaPrestamo.getlNombreCliente().setText(usuario.getNombreUsuario());
                vistaPrestamo.labelsPanelDer(usuario.getNombreUsuario());
                vistaPrestamo.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "El Cliente no Existe", "Error", 2);
            }
            if (vistaPrestamo.getBuscar().isSelected(vistaPrestamo.getRbNombre().getModel())) {
                if (sUsuario.encontrarCinta(vistaPrestamo.gettBuscarPelicula().getText().toUpperCase())) {
                    this.Cinta = sUsuario.getEncontrarCinta();
                    vistaPrestamo.getpIzquierda().removeAll();
                    vistaPrestamo.labelsPanelIzq();
                    vistaPrestamo.MostrarCintas(Cinta, false);
                    vistaPrestamo.repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "La cinta no se encuentra en nuestra tienda", "Advertencia", 2);
                }
            } else {
                if (sUsuario.encontrarCintaActor(vistaPrestamo.gettBuscarPelicula().getText().toUpperCase())) {
                    this.Cinta = sUsuario.getEncontrarCinta();
                    vistaPrestamo.getpIzquierda().removeAll();
                    vistaPrestamo.labelsPanelIzq();
                    vistaPrestamo.MostrarCintas(Cinta, true);
                    vistaPrestamo.repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "El Actor no se encuentra en ninguna pelicula de nuestra tienda", "Advertencia", 2);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Recuerde llenar todos los Campos", "Advertencia", 2);
        }

    }

    public void cintaCliente() {
        if (elegirPelicula()) {
            vistaPrestamo.getpDerecha().removeAll();
            vistaPrestamo.MostrarCintasCliente(cintasCliente, usuario.getNombreUsuario(), this.valorCintasCliente, this.itemCintasCliente);
            vistaPrestamo.repaint();
        }
    }

    public boolean elegirPelicula() {
        if (verificarCampos2()) {
            for (Cinta cinta : Cinta) {
                if (cinta.getIdCinta().equals(vistaPrestamo.gettCinta().getText())) {
                    for (int i = 0; i < cintasCliente.size(); i++) {
                        if (cintasCliente.get(i).getIdCinta().equals(vistaPrestamo.gettCinta().getText())) {
                            return false;
                        }
                    }
                    cintasCliente.add(cinta);
                    itemCintasCliente.add(itemCintasCliente.size() + 1);
                    valorCintasCliente.add(vistaPrestamo.gettValorCinta().getText());
                    return true;
                }
            }
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Recuerde llenar todos los Campos", "Advertencia", 2);
            return false;
        }
    }

    public boolean verificarCampos() {
        if ((vistaPrestamo.getRbActor().isSelected() || vistaPrestamo.getRbNombre().isSelected())) {
            if (!vistaPrestamo.gettBuscarPelicula().getText().equals("Pelicula o Actor") && !vistaPrestamo.gettBuscarPelicula().getText().equals("")
                    && !vistaPrestamo.gettNombreUsuario().getText().equals("Membresia de Usuario") && !vistaPrestamo.gettNombreUsuario().getText().equals("")) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarCampos2() {
        if (!vistaPrestamo.gettCinta().getText().equals("ID Cinta") && !vistaPrestamo.gettCinta().getText().equals("")
                && !vistaPrestamo.gettValorCinta().getText().equals("Valor Cinta") && !vistaPrestamo.gettValorCinta().getText().equals("")) {
            return true;
        }
        return false;
    }

    @Override
    public void focusGained(FocusEvent fe) {
        if (fe.getSource() == vistaPrestamo.gettNombreUsuario()) {
            if (vistaPrestamo.gettNombreUsuario().getText().equals("Membresia de Usuario")) {
                vistaPrestamo.gettNombreUsuario().setText("");
                vistaPrestamo.gettNombreUsuario().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(196, 0, 1)));
            }
        }
        if (fe.getSource() == vistaPrestamo.gettBuscarPelicula()) {
            if (vistaPrestamo.gettBuscarPelicula().getText().equals("Pelicula o Actor")) {
                vistaPrestamo.gettBuscarPelicula().setText("");
                vistaPrestamo.gettBuscarPelicula().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(196, 0, 1)));
            }
        }
        if (fe.getSource() == vistaPrestamo.gettCinta()) {
            if (vistaPrestamo.gettCinta().getText().equals("ID Cinta")) {
                vistaPrestamo.gettCinta().setText("");
                vistaPrestamo.gettCinta().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(196, 0, 1)));
            }
        }
        if (fe.getSource() == vistaPrestamo.gettValorCinta()) {
            if (vistaPrestamo.gettValorCinta().getText().equals("Valor Cinta")) {
                vistaPrestamo.gettValorCinta().setText("");
                vistaPrestamo.gettValorCinta().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(196, 0, 1)));
            }
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        if (fe.getSource() == vistaPrestamo.gettNombreUsuario()) {
            if (vistaPrestamo.gettNombreUsuario().getText().equals("")) {
                vistaPrestamo.gettNombreUsuario().setText("Membresia de Usuario");
                vistaPrestamo.gettNombreUsuario().setBorder(null);
            }
        }
        if (fe.getSource() == vistaPrestamo.gettBuscarPelicula()) {
            if (vistaPrestamo.gettBuscarPelicula().getText().equals("")) {
                vistaPrestamo.gettBuscarPelicula().setText("Pelicula o Actor");
                vistaPrestamo.gettBuscarPelicula().setBorder(null);
            }
        }
        if (fe.getSource() == vistaPrestamo.gettCinta()) {
            if (vistaPrestamo.gettCinta().getText().equals("")) {
                vistaPrestamo.gettCinta().setText("ID Cinta");
                vistaPrestamo.gettCinta().setBorder(null);
            }
        }
        if (fe.getSource() == vistaPrestamo.gettValorCinta()) {
            if (vistaPrestamo.gettValorCinta().getText().equals("")) {
                vistaPrestamo.gettValorCinta().setText("Valor Cinta");
                vistaPrestamo.gettValorCinta().setBorder(null);
            }
        }
    }

}
