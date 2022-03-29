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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author PC
 */
public class AdminTemplate extends JFrame{
    private JPanel panel;
    private JLabel logo, lTitulo,lTitulo2;
    private JButton bRegistarCliente, bPrestamo,bSalir;
    private ImageIcon iDimAux, iSalir, iTitulo;
    private AdminComponent vistacomponent;
    
    public AdminTemplate(AdminComponent vistacomponent) {
        this.vistacomponent = vistacomponent;
        
        this.crearObjetosDecoradores();
        this.crearJPanel();
        this.crearJButton();
        this.crearJLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 400);
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
        panel.setSize(300, 400);
        panel.setLocation(0, 0);
        panel.setLayout(null);
        panel.setBackground(new Color(17, 17, 23));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        this.add(panel);
    }
    
    private void crearJLabel() {
        iDimAux = new ImageIcon(iTitulo.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
        logo = new JLabel();
        logo.setSize(50, 50);
        logo.setIcon(iDimAux);
        logo.setLocation(125, 340);
        logo.setForeground(Color.WHITE);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(logo);

        lTitulo2 = new JLabel("Heimdall");
        lTitulo2.setSize(50, 20);
        lTitulo2.setLocation(125, 310);
        lTitulo2.setForeground(new Color(196, 0, 1));
        lTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo2.setFont(new Font("Haettenschweiler", Font.PLAIN, 18));
        lTitulo2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(196, 0, 1)));
        panel.add(lTitulo2);
        
        lTitulo = new JLabel("Heimdall");
        lTitulo.setSize(200, 30);
        lTitulo.setLocation(50, 30);
        lTitulo.setForeground(new Color(196, 0, 1));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo.setFont(new Font("Haettenschweiler", Font.PLAIN, 30));
        lTitulo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(196, 0, 1)));
        panel.add(lTitulo);
    }
    
    private void crearJButton() {
        bSalir = new JButton();
        bSalir.setSize(25, 25);
        bSalir.setLocation(265, 10);
        iDimAux = new ImageIcon(iSalir.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING));
        bSalir.setIcon(iDimAux);
        bSalir.setFocusable(false);
        bSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bSalir.setBorder(null);
        bSalir.setContentAreaFilled(false);
        bSalir.setHorizontalAlignment(SwingConstants.CENTER);
        bSalir.addActionListener(this.vistacomponent);
        panel.add(bSalir);

        bRegistarCliente = new JButton("Registrar Cliente");
        bRegistarCliente.setSize(250, 30);
        bRegistarCliente.setLocation(25, 150);
        bRegistarCliente.setFocusable(false);
        bRegistarCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bRegistarCliente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        bRegistarCliente.setBackground(new Color(196, 0, 1));
        bRegistarCliente.setForeground(Color.WHITE);
        bRegistarCliente.setBorder(null);
        bRegistarCliente.setContentAreaFilled(true);
        bRegistarCliente.setHorizontalAlignment(SwingConstants.CENTER);
        bRegistarCliente.addActionListener(this.vistacomponent);
        panel.add(bRegistarCliente);
        
        bPrestamo = new JButton("Prestamo de Pelicula");
        bPrestamo.setSize(250, 30);
        bPrestamo.setLocation(25, 200);
        bPrestamo.setFocusable(false);
        bPrestamo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bPrestamo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        bPrestamo.setBackground(new Color(196, 0, 1));
        bPrestamo.setForeground(Color.WHITE);
        bPrestamo.setBorder(null);
        bPrestamo.setContentAreaFilled(true);
        bPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
        bPrestamo.addActionListener(this.vistacomponent);
        panel.add(bPrestamo);
    }

    public JButton getbPrestamo() {
        return bPrestamo;
    }

    public JButton getbRegistarCliente() {
        return bRegistarCliente;
    }

    public JButton getbSalir() {
        return bSalir;
    }
    
}
