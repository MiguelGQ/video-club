/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.PostgreSQL;
import Modelo.EmailSenderService;
import Modelo.UsuarioService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class RegistrarComponent implements ActionListener {

    private RegistrarTemplate vistaRegistrar;
    private AdminComponent vistaAdmin;
    private UsuarioService sUsuario;
    private String nombre, email, apellido, telefono, direccion, credito;

    public RegistrarComponent(AdminComponent vistaAdmin, UsuarioService sUsuario) {
        this.sUsuario = sUsuario;
        this.vistaAdmin = vistaAdmin;
        this.vistaRegistrar = new RegistrarTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaRegistrar.getbSalir()) {
            sUsuario.cerrarConexion();
            System.exit(0);
        }
        if (e.getSource() == vistaRegistrar.getbVolver()) {
            volver();
        }
        if (e.getSource() == vistaRegistrar.getbRegistrar()) {
            if (obtenerDatos()) {
                JOptionPane.showMessageDialog(null, "Registro Exitoso", "Información", 1);
                volver();
            }
        }
    }

    public void volver() {
        this.vistaAdmin.getAdminTemplate().setVisible(true);
        vistaRegistrar.dispose();
    }

    public RegistrarTemplate getRegistrarTemplate() {
        return this.vistaRegistrar;
    }

    public boolean obtenerDatos() {
        this.nombre = vistaRegistrar.gettNombreUsuario().getText();
        this.apellido = vistaRegistrar.gettApellidoUsuario().getText();
        this.email = vistaRegistrar.gettEmail().getText();
        this.telefono = vistaRegistrar.gettTelefono().getText();
        this.direccion = vistaRegistrar.gettDireccion().getText();
        this.credito = vistaRegistrar.gettTCredito().getText();

        if (!this.nombre.equals("") && !this.apellido.equals("") && !this.email.equals("")
                && !this.telefono.equals("") && !this.direccion.equals("") && !this.credito.equals("")) {
            this.sUsuario.registarDatosUsuario(this.nombre, this.apellido,
                    this.telefono, this.direccion, this.credito, this.email);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Deben llenarse todos los espacios", "Advertencia", 2);
            return false;
        }
    }
}
