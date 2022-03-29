/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.PostgreSQL;
import Modelo.UsuarioService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class AdminComponent implements ActionListener {
    private PrincipalComponent vistaPrincipal;
    private RegistrarComponent registrarComponent;
    private PrestamoComponent prestamoComponent;
    private UsuarioService sUsuario;
    private AdminTemplate vistaAdmin;
    
    public AdminComponent(PrincipalComponent vistaPrincipal, UsuarioService sUsuario) {
        this.sUsuario = sUsuario;
        this.vistaPrincipal = vistaPrincipal;
        this.vistaAdmin = new AdminTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaAdmin.getbSalir()) {
            volver();
        }
        if (e.getSource() == vistaAdmin.getbRegistarCliente()) {
            entrarRegistrar();
        }
        if (e.getSource() == vistaAdmin.getbPrestamo()) {
            entrarPrestamo();
        }
    }
    
    public void entrarRegistrar() {
        this.registrarComponent = new RegistrarComponent(this,sUsuario);
        vistaAdmin.setVisible(false);
    }
    
    public void entrarPrestamo() {
        this.prestamoComponent = new PrestamoComponent(this,sUsuario);
        vistaAdmin.setVisible(false);
    }
    
    public void volver() {
        if (vistaPrincipal == null) {
            this.vistaPrincipal = new PrincipalComponent();
        } else {
            this.vistaPrincipal.getPrincipalTemplate().setVisible(true);
        }
        vistaAdmin.setVisible(false);
    }
    
    public AdminTemplate getAdminTemplate() {
        return this.vistaAdmin;
    }
}
