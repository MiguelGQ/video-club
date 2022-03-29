/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.PostgreSQL;
import Modelo.UsuarioService;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class PrincipalComponent implements ActionListener, FocusListener {

    private PrincipalTemplate vista;
    private AdminComponent vistaAdmin;
    private UsuarioService sUsuario;
    private String nombreUsuario, claveUsuario;

    public PrincipalComponent() {
        this.vista = new PrincipalTemplate(this);
        sUsuario = new UsuarioService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getbSalir()) {
            sUsuario.cerrarConexion();
            System.exit(0);
        }
        if (e.getSource() == vista.getbEntrar()) {
            if(enviarDatosUsuario()){
                this.entrar();
            }
        }
    }

    public void entrar() {
        if (vistaAdmin == null) {
            this.vistaAdmin = new AdminComponent(this,sUsuario);
        } else {
            this.vistaAdmin.getAdminTemplate().setVisible(true);
        }
        vista.setVisible(false);
    }

    public boolean enviarDatosUsuario() {
        nombreUsuario = vista.gettNombreUsuario().getText();
        claveUsuario = new String(vista.gettClaveUsuario().getPassword());
        if (sUsuario.verificarEmpleado(nombreUsuario, claveUsuario)) {
            JOptionPane.showMessageDialog(null,nombreUsuario+ " Ingreso Exitoso", "Advertencia", 1);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El usuario y/o contraseña no coinciden", "Advertencia", 2);
            return false;
        }
    }

    public PrincipalTemplate getPrincipalTemplate() {
        return this.vista;
    }

    @Override
    public void focusGained(FocusEvent fe) {
        if (fe.getSource() == vista.gettClaveUsuario()) {
            if (new String(vista.gettClaveUsuario().getPassword()).equals("Clave de Usuario")) {
                vista.gettClaveUsuario().setText("");
                vista.gettClaveUsuario().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(196, 0, 1)));
            }
        }
        if (fe.getSource() == vista.gettNombreUsuario()) {
            if (vista.gettNombreUsuario().getText().equals("Nombre de Usuario")) {
                vista.gettNombreUsuario().setText("");
                vista.gettNombreUsuario().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(196, 0, 1)));
            }
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        if (fe.getSource() == vista.gettClaveUsuario()) {
            if (new String(vista.gettClaveUsuario().getPassword()).equals("")) {
                vista.gettClaveUsuario().setText("Clave de Usuario");
                vista.gettClaveUsuario().setBorder(null);
            }
        }
        if (fe.getSource() == vista.gettNombreUsuario()) {
            if (vista.gettNombreUsuario().getText().equals("")) {
                vista.gettNombreUsuario().setText("Nombre de Usuario");
                vista.gettNombreUsuario().setBorder(null);
            }
        }
    }

}
