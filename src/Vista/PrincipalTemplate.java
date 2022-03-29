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
import javax.swing.JComboBox;
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
public class PrincipalTemplate extends JFrame {

    private JPanel panel;
    private JLabel logo, lTitulo;
    private JButton bEntrar, bSalir;
    private ImageIcon iDimAux, iSalir, iTitulo;
    private JTextField tNombreUsuario;
    private JPasswordField tClaveUsuario;
    private PrincipalComponent vistacomponent;

    public PrincipalTemplate(PrincipalComponent vistacomponent) {
        this.vistacomponent = vistacomponent;

        this.crearObjetosDecoradores();
        this.crearJPanel();
        this.crearJTextField();
        this.crearJPasswordField();
        this.crearJButton();
        this.crearJLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    private void crearObjetosDecoradores() {
        iSalir = new ImageIcon("resources/img/salir.png");
        iTitulo = new ImageIcon("resources/img/Logo2.png");
    }

    private void crearJPanel() {
        panel = new JPanel();
        panel.setSize(400, 600);
        panel.setLocation(0, 0);
        panel.setLayout(null);
        panel.setBackground(new Color(17, 17, 23));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        this.add(panel);
    }

    private void crearJLabel() {
        iDimAux = new ImageIcon(iTitulo.getImage().getScaledInstance(250, 200, Image.SCALE_AREA_AVERAGING));
        logo = new JLabel();
        logo.setSize(250, 200);
        logo.setIcon(iDimAux);
        logo.setLocation(75, 70);
        logo.setForeground(Color.WHITE);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(logo);

        lTitulo = new JLabel("Heimdall");
        lTitulo.setSize(250, 30);
        lTitulo.setLocation(75, 30);
        lTitulo.setForeground(new Color(196, 0, 1));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo.setFont(new Font("Haettenschweiler", Font.PLAIN, 40));
        lTitulo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(196, 0, 1)));
        panel.add(lTitulo);
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

        bEntrar = new JButton("INICIAR SESIÓN");
        bEntrar.setSize(250, 30);
        bEntrar.setLocation(75, 410);
        bEntrar.setFocusable(false);
        bEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bEntrar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        bEntrar.setBackground(new Color(196, 0, 1));
        bEntrar.setForeground(Color.WHITE);
        bEntrar.setBorder(null);
        bEntrar.setContentAreaFilled(true);
        bEntrar.setHorizontalAlignment(SwingConstants.CENTER);
        bEntrar.addActionListener(this.vistacomponent);
        panel.add(bEntrar);
    }

    private void crearJTextField() {
        tNombreUsuario = new JTextField();
        tNombreUsuario.setSize(320, 30);
        tNombreUsuario.setLocation(40, 300);
        tNombreUsuario.setText("Nombre de Usuario");
        tNombreUsuario.setForeground(Color.WHITE);
        tNombreUsuario.setBackground(new Color(32, 33, 39));
        tNombreUsuario.setCaretColor(new Color(196, 0, 1));
        tNombreUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        tNombreUsuario.setBorder(null);
        tNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        tNombreUsuario.addFocusListener(this.vistacomponent);
        panel.add(tNombreUsuario);
    }

    private void crearJPasswordField() {
        tClaveUsuario = new JPasswordField();
        tClaveUsuario.setSize(320, 30);
        tClaveUsuario.setLocation(40, 350);
        tClaveUsuario.setText("Clave de Usuario");
        tClaveUsuario.setForeground(Color.WHITE);
        tClaveUsuario.setBackground(new Color(32, 33, 39));
        tClaveUsuario.setCaretColor(new Color(196, 0, 1));
        tClaveUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        tClaveUsuario.setBorder(null);
        tClaveUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        tClaveUsuario.addFocusListener(this.vistacomponent);
        panel.add(tClaveUsuario);
    }

    public JButton getbEntrar() {
        return bEntrar;
    }

    public JButton getbSalir() {
        return bSalir;
    }

    public JTextField gettNombreUsuario() {
        return tNombreUsuario;
    }

    public JPasswordField gettClaveUsuario() {
        return tClaveUsuario;
    }
}
