/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author PC
 */
public class RegistrarTemplate extends JFrame {

    private JPanel panel;
    private JLabel lUsuario, lApellido, lTelefono, lEmail, lDireccion, lTCredito;
    private JLabel logo, lLogo,lTitulo;
    private JButton bVolver, bRegistrar, bSalir;
    private ImageIcon iDimAux, iSalir, iTitulo, iLogo;
    private JTextField tNombreUsuario,tApellidoUsuario, tEmail, tTelefono, tDireccion, tTCredito;
    private RegistrarComponent vistacomponent;

    public RegistrarTemplate(RegistrarComponent vistacomponent) {
        this.vistacomponent = vistacomponent;

        this.crearObjetosDecoradores();
        this.crearJPanel();
        this.crearJTextField();
        this.crearJButton();
        this.crearJLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 700);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    private void crearObjetosDecoradores() {
        iSalir = new ImageIcon("resources/img/salir.png");
        iTitulo = new ImageIcon("resources/img/registrar1.png");
        iLogo = new ImageIcon("resources/img/Logo2.png");
    }

    private void crearJPanel() {
        panel = new JPanel();
        panel.setSize(400, 700);
        panel.setLocation(0, 0);
        panel.setLayout(null);
        panel.setBackground(new Color(17, 17, 23));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        this.add(panel);
    }

    private void crearJLabel() {
        iDimAux = new ImageIcon(iTitulo.getImage().getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
        lTitulo = new JLabel();
        lTitulo.setSize(70, 70);
        lTitulo.setIcon(iDimAux);
        lTitulo.setLocation(165, 10);
        lTitulo.setForeground(Color.WHITE);
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lTitulo);
        
        lUsuario = new JLabel("Nombre:");
        lUsuario.setSize(100, 30);
        lUsuario.setLocation(30, 80);
        lUsuario.setForeground(Color.WHITE);
        lUsuario.setHorizontalAlignment(SwingConstants.LEFT);
        lUsuario.setFont(new Font("book antiqua", Font.PLAIN, 14));
        panel.add(lUsuario);
        
        lApellido = new JLabel("Apellido:");
        lApellido.setSize(100, 30);
        lApellido.setLocation(30, 150);
        lApellido.setForeground(Color.WHITE);
        lApellido.setHorizontalAlignment(SwingConstants.LEFT);
        lApellido.setFont(new Font("book antiqua", Font.PLAIN, 14));
        panel.add(lApellido);

        lEmail = new JLabel("E-Mail:");
        lEmail.setSize(100, 30);
        lEmail.setLocation(30, 220);
        lEmail.setForeground(Color.WHITE);
        lEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lEmail.setFont(new Font("book antiqua", Font.PLAIN, 14));
        panel.add(lEmail);

        lTelefono = new JLabel("Telefono:");
        lTelefono.setSize(210, 30);
        lTelefono.setLocation(30, 290);
        lTelefono.setForeground(Color.WHITE);
        lTelefono.setHorizontalAlignment(SwingConstants.LEFT);
        lTelefono.setFont(new Font("book antiqua", Font.PLAIN, 14));
        panel.add(lTelefono);
        
        lDireccion = new JLabel("Direccion:");
        lDireccion.setSize(210, 30);
        lDireccion.setLocation(30, 360);
        lDireccion.setForeground(Color.WHITE);
        lDireccion.setHorizontalAlignment(SwingConstants.LEFT);
        lDireccion.setFont(new Font("book antiqua", Font.PLAIN, 14));
        panel.add(lDireccion);
        
        lTCredito = new JLabel("Credito:");
        lTCredito.setSize(210, 30);
        lTCredito.setLocation(30, 430);
        lTCredito.setForeground(Color.WHITE);
        lTCredito.setHorizontalAlignment(SwingConstants.LEFT);
        lTCredito.setFont(new Font("book antiqua", Font.PLAIN, 14));
        panel.add(lTCredito);
        
        iDimAux = new ImageIcon(iLogo.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
        logo = new JLabel();
        logo.setSize(50, 50);
        logo.setIcon(iDimAux);
        logo.setLocation(175, 635);
        logo.setForeground(Color.WHITE);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(logo);

        lLogo = new JLabel("Heimdall");
        lLogo.setSize(50, 20);
        lLogo.setLocation(175, 610);
        lLogo.setForeground(new Color(196, 0, 1));
        lLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lLogo.setFont(new Font("Haettenschweiler", Font.PLAIN, 18));
        lLogo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(196, 0, 1)));
        panel.add(lLogo);
    }
    
    private void crearJTextField() {
        
        tNombreUsuario = new JTextField();
        tNombreUsuario.setSize(340, 30);
        tNombreUsuario.setLocation(30, 110);
        tNombreUsuario.setForeground(Color.WHITE);
        tNombreUsuario.setBackground(new Color(32, 33, 39));
        tNombreUsuario.setCaretColor(new Color(196, 0, 1));
        tNombreUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        tNombreUsuario.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(196, 0, 1)));
        tNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(tNombreUsuario);
        
        tApellidoUsuario = new JTextField();
        tApellidoUsuario.setSize(340, 30);
        tApellidoUsuario.setLocation(30, 180);
        tApellidoUsuario.setForeground(Color.WHITE);
        tApellidoUsuario.setBackground(new Color(32, 33, 39));
        tApellidoUsuario.setCaretColor(new Color(196, 0, 1));
        tApellidoUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        tApellidoUsuario.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(196, 0, 1)));
        tApellidoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(tApellidoUsuario);
        
        tEmail = new JTextField();
        tEmail.setSize(340, 30);
        tEmail.setLocation(30, 250);
        tEmail.setForeground(Color.WHITE);
        tEmail.setBackground(new Color(32, 33, 39));
        tEmail.setCaretColor(new Color(196, 0, 1));
        tEmail.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        tEmail.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(196, 0, 1)));
        tEmail.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(tEmail);
        
        tTelefono = new JTextField();
        tTelefono.setSize(340, 30);
        tTelefono.setLocation(30, 320);
        tTelefono.setForeground(Color.WHITE);
        tTelefono.setBackground(new Color(32, 33, 39));
        tTelefono.setCaretColor(new Color(196, 0, 1));
        tTelefono.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        tTelefono.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(196, 0, 1)));
        tTelefono.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(tTelefono);
        
        tDireccion = new JTextField();
        tDireccion.setSize(340, 30);
        tDireccion.setLocation(30, 390);
        tDireccion.setForeground(Color.WHITE);
        tDireccion.setBackground(new Color(32, 33, 39));
        tDireccion.setCaretColor(new Color(196, 0, 1));
        tDireccion.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        tDireccion.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(196, 0, 1)));
        tDireccion.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(tDireccion);
        
        tTCredito = new JTextField();
        tTCredito.setSize(340, 30);
        tTCredito.setLocation(30, 460);
        tTCredito.setForeground(Color.WHITE);
        tTCredito.setBackground(new Color(32, 33, 39));
        tTCredito.setCaretColor(new Color(196, 0, 1));
        tTCredito.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        tTCredito.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(196, 0, 1)));
        tTCredito.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(tTCredito);
    }

    

    private void crearJButton() {
        bSalir = new JButton();
        bSalir.setSize(25, 25);
        bSalir.setLocation(350, 10);
        iDimAux = new ImageIcon(iSalir.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING));
        bSalir.setIcon(iDimAux);
        bSalir.setFocusable(false);
        bSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bSalir.setBorder(null);
        bSalir.setContentAreaFilled(false);
        bSalir.setHorizontalAlignment(SwingConstants.CENTER);
        bSalir.addActionListener(this.vistacomponent);
        panel.add(bSalir);

        bVolver = new JButton("VOLVER");
        bVolver.setSize(150, 30);
        bVolver.setLocation(40, 560);
        bVolver.setFocusable(false);
        bVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bVolver.setFont(new Font("Haettenschweiler", Font.PLAIN, 18));
        bVolver.setBackground(new Color(196, 0, 1));
        bVolver.setForeground(Color.WHITE);
        bVolver.setBorder(null);
        bVolver.setContentAreaFilled(true);
        bVolver.setHorizontalAlignment(SwingConstants.CENTER);
        bVolver.addActionListener(this.vistacomponent);
        panel.add(bVolver);

        bRegistrar = new JButton("REGISTRAR");
        bRegistrar.setSize(150, 30);
        bRegistrar.setLocation(210, 560);
        bRegistrar.setFocusable(false);
        bRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bRegistrar.setFont(new Font("Haettenschweiler", Font.PLAIN, 18));
        bRegistrar.setBackground(new Color(196, 0, 1));
        bRegistrar.setForeground(Color.WHITE);
        bRegistrar.setBorder(null);
        bRegistrar.setContentAreaFilled(true);
        bRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
        bRegistrar.addActionListener(this.vistacomponent);
        panel.add(bRegistrar);
    }

    public JButton getbVolver() {
        return bVolver;
    }

    public JButton getbRegistrar() {
        return bRegistrar;
    }

    public JButton getbSalir() {
        return bSalir;
    }

    public JTextField gettNombreUsuario() {
        return tNombreUsuario;
    }

    public JTextField gettEmail() {
        return tEmail;
    }

    public JTextField gettApellidoUsuario() {
        return tApellidoUsuario;
    }

    public JTextField gettTelefono() {
        return tTelefono;
    }

    public JTextField gettDireccion() {
        return tDireccion;
    }

    public JTextField gettTCredito() {
        return tTCredito;
    }
}
