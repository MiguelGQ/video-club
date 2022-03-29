/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Cinta;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author PC
 */
public class PrestamoTemplate extends JFrame {

    private PrestamoComponent vistacomponent;
    private JPanel pDerecha, pIzquierda, pDatosDer, pDatosIzq;
    private JLabel logo, lTitulo, lTitulo2;
    private JLabel lBusqueda, lCliente, lPrestamo;
    private JLabel lNombreCliente, lNCliente;
    private JLabel nomActor, tMostrarCinta, tidCinta, tNomPeli, tItem, tValor;
    private JLabel[] lIdCinta, lNomPeli;
    private JLabel[] lIdCintaCliente, lNomPeliCliente, lItem, lValor;
    private JTextField tBuscarPelicula, tCinta, tValorCinta, tNombreUsuario;
    private JButton bBusqueda, bAgregar, bGuardar, bSalir;
    private ImageIcon iDimAux, iSalir, iTitulo;
    private JRadioButton rbNombre, rbActor;
    private ButtonGroup Buscar;

    public PrestamoTemplate(PrestamoComponent vistacomponent) {
        this.vistacomponent = vistacomponent;
        this.lIdCinta = new JLabel[30];
        this.lNomPeli = new JLabel[30];

        this.lIdCintaCliente = new JLabel[30];
        this.lNomPeliCliente = new JLabel[30];
        this.lItem = new JLabel[30];
        this.lValor = new JLabel[30];

        this.crearObjetosDecoradores();
        this.crearJPanel();
        this.crearJRadioButton();
        this.crearJTextField();
        this.crearJButton();
        this.labelsPanelIzq();
        this.crearJLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 750);
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
        pDatosDer = new JPanel();
        pDatosDer.setSize(299, 299);
        pDatosDer.setLocation(0, 0);
        pDatosDer.setLayout(null);
        pDatosDer.setBackground(new Color(17, 17, 23));
        pDatosDer.setBorder(null);
        this.add(pDatosDer);

        pDatosIzq = new JPanel();
        pDatosIzq.setSize(300, 299);
        pDatosIzq.setLocation(300, 0);
        pDatosIzq.setLayout(null);
        pDatosIzq.setBackground(new Color(17, 17, 23));
        pDatosIzq.setBorder(null);
        this.add(pDatosIzq);

        pIzquierda = new JPanel();
        pIzquierda.setSize(299, 900);
        pIzquierda.setLocation(0, 300);
        pIzquierda.setLayout(null);
        pIzquierda.setBackground(new Color(17, 17, 23));
        pIzquierda.setBorder(null);
        this.add(pIzquierda);

        pDerecha = new JPanel();
        pDerecha.setSize(300, 900);
        pDerecha.setLocation(300, 300);
        pDerecha.setLayout(null);
        pDerecha.setBackground(new Color(17, 17, 23));
        pDerecha.setBorder(null);
        this.add(pDerecha);
    }

    private void crearJLabel() {
        iDimAux = new ImageIcon(iTitulo.getImage().getScaledInstance(50, 40, Image.SCALE_AREA_AVERAGING));
        logo = new JLabel();
        logo.setSize(50, 40);
        logo.setIcon(iDimAux);
        logo.setLocation(125, 255);
        logo.setForeground(Color.WHITE);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        pDatosIzq.add(logo);

        lTitulo = new JLabel("Heimdall");
        lTitulo.setSize(50, 20);
        lTitulo.setLocation(125, 230);
        lTitulo.setForeground(new Color(196, 0, 1));
        lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo.setFont(new Font("Haettenschweiler", Font.PLAIN, 15));
        lTitulo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(196, 0, 1)));
        pDatosIzq.add(lTitulo);

        lTitulo2 = new JLabel("Heimdall");
        lTitulo2.setSize(200, 30);
        lTitulo2.setLocation(50, 10);
        lTitulo2.setForeground(new Color(196, 0, 1));
        lTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
        lTitulo2.setFont(new Font("Haettenschweiler", Font.PLAIN, 30));
        lTitulo2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(196, 0, 1)));
        pDatosDer.add(lTitulo2);

        lCliente = new JLabel("Cliente");
        lCliente.setSize(200, 30);
        lCliente.setLocation(50, 50);
        lCliente.setForeground(Color.WHITE);
        lCliente.setHorizontalAlignment(SwingConstants.LEFT);
        lCliente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        lCliente.setBorder(null);
        pDatosDer.add(lCliente);

        lBusqueda = new JLabel("Sección de Busqueda");
        lBusqueda.setSize(200, 30);
        lBusqueda.setLocation(50, 130);
        lBusqueda.setForeground(Color.WHITE);
        lBusqueda.setHorizontalAlignment(SwingConstants.LEFT);
        lBusqueda.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        lBusqueda.setBorder(null);
        pDatosDer.add(lBusqueda);

        lPrestamo = new JLabel("Sección de Prestamo");
        lPrestamo.setSize(200, 30);
        lPrestamo.setLocation(50, 20);
        lPrestamo.setForeground(Color.WHITE);
        lPrestamo.setHorizontalAlignment(SwingConstants.LEFT);
        lPrestamo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        lPrestamo.setBorder(null);
        pDatosIzq.add(lPrestamo);

        lNCliente = new JLabel("Cliente:");
        lNCliente.setSize(100, 30);
        lNCliente.setLocation(50, 60);
        lNCliente.setForeground(Color.WHITE);
        lNCliente.setHorizontalAlignment(SwingConstants.LEFT);
        lNCliente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        lNCliente.setBorder(null);
        pDatosIzq.add(lNCliente);

        lNombreCliente = new JLabel();
        lNombreCliente.setSize(200, 30);
        lNombreCliente.setLocation(100, 60);
        lNombreCliente.setForeground(Color.WHITE);
        lNombreCliente.setHorizontalAlignment(SwingConstants.LEFT);
        lNombreCliente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        lNombreCliente.setBorder(null);
        pDatosIzq.add(lNombreCliente);
    }

    private void crearJTextField() {
        tNombreUsuario = new JTextField();
        tNombreUsuario.setSize(200, 30);
        tNombreUsuario.setLocation(50, 90);
        tNombreUsuario.setText("Membresia de Usuario");
        tNombreUsuario.setForeground(Color.WHITE);
        tNombreUsuario.setBackground(new Color(32, 33, 39));
        tNombreUsuario.setCaretColor(new Color(196, 0, 1));
        tNombreUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        tNombreUsuario.setBorder(null);
        tNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        tNombreUsuario.addFocusListener(this.vistacomponent);
        pDatosDer.add(tNombreUsuario);

        tBuscarPelicula = new JTextField();
        tBuscarPelicula.setSize(200, 30);
        tBuscarPelicula.setLocation(50, 170);
        tBuscarPelicula.setText("Pelicula o Actor");
        tBuscarPelicula.setForeground(Color.WHITE);
        tBuscarPelicula.setBackground(new Color(32, 33, 39));
        tBuscarPelicula.setCaretColor(new Color(196, 0, 1));
        tBuscarPelicula.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        tBuscarPelicula.setBorder(null);
        tBuscarPelicula.setHorizontalAlignment(SwingConstants.CENTER);
        tBuscarPelicula.addFocusListener(this.vistacomponent);
        pDatosDer.add(tBuscarPelicula);

        tCinta = new JTextField();
        tCinta.setSize(60, 30);
        tCinta.setLocation(50, 100);
        tCinta.setText("ID Cinta");
        tCinta.setForeground(Color.WHITE);
        tCinta.setBackground(new Color(32, 33, 39));
        tCinta.setCaretColor(new Color(196, 0, 1));
        tCinta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        tCinta.setBorder(null);
        tCinta.setHorizontalAlignment(SwingConstants.CENTER);
        tCinta.addFocusListener(this.vistacomponent);
        pDatosIzq.add(tCinta);

        tValorCinta = new JTextField();
        tValorCinta.setSize(140, 30);
        tValorCinta.setLocation(120, 100);
        tValorCinta.setText("Valor Cinta");
        tValorCinta.setForeground(Color.WHITE);
        tValorCinta.setBackground(new Color(32, 33, 39));
        tValorCinta.setCaretColor(new Color(196, 0, 1));
        tValorCinta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        tValorCinta.setBorder(null);
        tValorCinta.setHorizontalAlignment(SwingConstants.CENTER);
        tValorCinta.addFocusListener(this.vistacomponent);
        pDatosIzq.add(tValorCinta);
    }

    private void crearJButton() {
        bSalir = new JButton();
        bSalir.setSize(25, 25);
        bSalir.setLocation(270, 10);
        iDimAux = new ImageIcon(iSalir.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING));
        bSalir.setIcon(iDimAux);
        bSalir.setFocusable(false);
        bSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bSalir.setBorder(null);
        bSalir.setContentAreaFilled(false);
        bSalir.setHorizontalAlignment(SwingConstants.CENTER);
        bSalir.addActionListener(this.vistacomponent);
        pDatosIzq.add(bSalir);

        bBusqueda = new JButton("BUSCAR");
        bBusqueda.setSize(200, 30);
        bBusqueda.setLocation(50, 250);
        bBusqueda.setFocusable(false);
        bBusqueda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bBusqueda.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        bBusqueda.setBackground(new Color(196, 0, 1));
        bBusqueda.setForeground(Color.WHITE);
        bBusqueda.setBorder(null);
        bBusqueda.setContentAreaFilled(true);
        bBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
        bBusqueda.addActionListener(this.vistacomponent);
        pDatosDer.add(bBusqueda);

        bAgregar = new JButton("Agregar");
        bAgregar.setSize(100, 30);
        bAgregar.setLocation(50, 140);
        bAgregar.setFocusable(false);
        bAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bAgregar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        bAgregar.setBackground(new Color(17, 17, 23));
        bAgregar.setForeground(Color.WHITE);
        bAgregar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(196, 0, 1)));
        bAgregar.setContentAreaFilled(true);
        bAgregar.setHorizontalAlignment(SwingConstants.CENTER);
        bAgregar.addActionListener(this.vistacomponent);
        pDatosIzq.add(bAgregar);

        bGuardar = new JButton("GUARDAR");
        bGuardar.setSize(200, 30);
        bGuardar.setLocation(50, 190);
        bGuardar.setFocusable(false);
        bGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bGuardar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        bGuardar.setBackground(new Color(196, 0, 1));
        bGuardar.setForeground(Color.WHITE);
        bGuardar.setBorder(null);
        bGuardar.setContentAreaFilled(true);
        bGuardar.setHorizontalAlignment(SwingConstants.CENTER);
        bGuardar.addActionListener(this.vistacomponent);
        pDatosIzq.add(bGuardar);
    }

    private void crearJRadioButton() {
        rbNombre = new JRadioButton("Pelicula");
        rbNombre.setSize(100, 25);
        rbNombre.setFocusable(false);
        rbNombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        rbNombre.setForeground(Color.WHITE);
        rbNombre.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rbNombre.setContentAreaFilled(false);
        rbNombre.setHorizontalAlignment(SwingConstants.LEFT);
        rbNombre.setLocation(50, 210);
        pDatosDer.add(rbNombre);

        rbActor = new JRadioButton("Actor");
        rbActor.setSize(100, 25);
        rbActor.setFocusable(false);
        rbActor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        rbActor.setForeground(Color.WHITE);
        rbActor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rbActor.setContentAreaFilled(false);
        rbActor.setHorizontalAlignment(SwingConstants.LEFT);;
        rbActor.setLocation(150, 210);
        pDatosDer.add(rbActor);

        Buscar = new ButtonGroup();
        Buscar.add(rbNombre);
        Buscar.add(rbActor);
    }

    public void MostrarCintas(ArrayList cintas, boolean Actor) {
        if (Actor) {
            ArrayList<Cinta> Cinta = new ArrayList<Cinta>();
            Cinta = cintas;
            nomActor = new JLabel("Actor: " + Cinta.get(Cinta.size() - 1).getActor());
            nomActor.setSize(200, 30);
            nomActor.setLocation(10, 55);
            nomActor.setForeground(Color.WHITE);
            nomActor.setHorizontalAlignment(SwingConstants.LEFT);
            nomActor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
            nomActor.setBorder(null);
            pIzquierda.add(nomActor);
            for (int i = 0; i < Cinta.size(); i++) {
                lIdCinta[i] = new JLabel(Cinta.get(i).getIdCinta());
                lIdCinta[i].setSize(30, 30);
                lIdCinta[i].setLocation(10, 110 + (30 * i));
                lIdCinta[i].setForeground(Color.WHITE);
                lIdCinta[i].setHorizontalAlignment(SwingConstants.CENTER);
                lIdCinta[i].setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
                lIdCinta[i].setBorder(null);
                pIzquierda.add(lIdCinta[i]);

                lNomPeli[i] = new JLabel(Cinta.get(i).getNomPelicula());
                lNomPeli[i].setSize(230, 30);
                lNomPeli[i].setLocation(50, 110 + (30 * i));
                lNomPeli[i].setForeground(Color.WHITE);
                lNomPeli[i].setHorizontalAlignment(SwingConstants.LEFT);
                lNomPeli[i].setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
                lNomPeli[i].setBorder(null);
                pIzquierda.add(lNomPeli[i]);
            }
        } else {
            ArrayList<Cinta> Cinta = new ArrayList<Cinta>();
            Cinta = cintas;
            for (int i = 0; i < Cinta.size(); i++) {
                lIdCinta[i] = new JLabel(Cinta.get(i).getIdCinta());
                lIdCinta[i].setSize(30, 30);
                lIdCinta[i].setLocation(10, 110 + (30 * i));
                lIdCinta[i].setForeground(Color.WHITE);
                lIdCinta[i].setHorizontalAlignment(SwingConstants.CENTER);
                lIdCinta[i].setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
                lIdCinta[i].setBorder(null);
                pIzquierda.add(lIdCinta[i]);

                lNomPeli[i] = new JLabel(Cinta.get(i).getNomPelicula());
                lNomPeli[i].setSize(230, 30);
                lNomPeli[i].setLocation(50, 110 + (30 * i));
                lNomPeli[i].setForeground(Color.WHITE);
                lNomPeli[i].setHorizontalAlignment(SwingConstants.LEFT);
                lNomPeli[i].setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
                lNomPeli[i].setBorder(null);
                pIzquierda.add(lNomPeli[i]);
            }
        }
    }

    public void MostrarCintasCliente(ArrayList cintas, String nomCliente, ArrayList<String> valor,ArrayList<Integer> item) {
        ArrayList<Cinta> Cinta = new ArrayList<Cinta>();
        Cinta = cintas;
        this.labelsPanelDer(nomCliente);
        for (int i = 0; i < Cinta.size(); i++) {
            lItem[i] = new JLabel(item.get(i)+ "");
            lItem[i].setSize(30, 30);
            lItem[i].setLocation(10, 80 + (30 * i));
            lItem[i].setForeground(Color.WHITE);
            lItem[i].setHorizontalAlignment(SwingConstants.CENTER);
            lItem[i].setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
            lItem[i].setBorder(null);
            pDerecha.add(lItem[i]);

            lIdCintaCliente[i] = new JLabel(Cinta.get(i).getIdCinta());
            lIdCintaCliente[i].setSize(30, 30);
            lIdCintaCliente[i].setLocation(40, 80 + (30 * i));
            lIdCintaCliente[i].setForeground(Color.WHITE);
            lIdCintaCliente[i].setHorizontalAlignment(SwingConstants.CENTER);
            lIdCintaCliente[i].setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
            lIdCintaCliente[i].setBorder(null);
            pDerecha.add(lIdCintaCliente[i]);

            lNomPeliCliente[i] = new JLabel(Cinta.get(i).getNomPelicula());
            lNomPeliCliente[i].setSize(160, 30);
            lNomPeliCliente[i].setLocation(80, 80 + (30 * i));
            lNomPeliCliente[i].setForeground(Color.WHITE);
            lNomPeliCliente[i].setHorizontalAlignment(SwingConstants.LEFT);
            lNomPeliCliente[i].setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
            lNomPeliCliente[i].setBorder(null);
            pDerecha.add(lNomPeliCliente[i]);

            lValor[i] = new JLabel("$ " + valor.get(i));
            lValor[i].setSize(60, 30);
            lValor[i].setLocation(240, 80 + (30 * i));
            lValor[i].setForeground(Color.WHITE);
            lValor[i].setHorizontalAlignment(SwingConstants.LEFT);
            lValor[i].setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
            lValor[i].setBorder(null);
            pDerecha.add(lValor[i]);
        }

    }

    public void labelsPanelIzq() {
        tMostrarCinta = new JLabel("<html><div align='center'>Cintas en la Tienda<br>"
                + "(Disponibles)"
                + "</div></html>");
        tMostrarCinta.setSize(200, 50);
        tMostrarCinta.setLocation(80, 0);
        tMostrarCinta.setForeground(new Color(196, 0, 1));
        tMostrarCinta.setHorizontalAlignment(SwingConstants.LEFT);
        tMostrarCinta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        tMostrarCinta.setBorder(null);
        pIzquierda.add(tMostrarCinta);

        tidCinta = new JLabel("id");
        tidCinta.setSize(30, 30);
        tidCinta.setLocation(10, 80);
        tidCinta.setForeground(Color.WHITE);
        tidCinta.setHorizontalAlignment(SwingConstants.CENTER);
        tidCinta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        tidCinta.setBorder(null);
        pIzquierda.add(tidCinta);

        tNomPeli = new JLabel("Nombre de la Cinta");
        tNomPeli.setSize(230, 30);
        tNomPeli.setLocation(50, 80);
        tNomPeli.setForeground(Color.WHITE);
        tNomPeli.setHorizontalAlignment(SwingConstants.LEFT);
        tNomPeli.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        tNomPeli.setBorder(null);
        pIzquierda.add(tNomPeli);
    }

    public void labelsPanelDer(String nomCliente) {
        tMostrarCinta = new JLabel("<html><div align='center'>Cintas para el Cliente<br>"
                + nomCliente
                + "</div></html>");
        tMostrarCinta.setSize(200, 50);
        tMostrarCinta.setLocation(80, 0);
        tMostrarCinta.setForeground(new Color(196, 0, 1));
        tMostrarCinta.setHorizontalAlignment(SwingConstants.LEFT);
        tMostrarCinta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        tMostrarCinta.setBorder(null);
        pDerecha.add(tMostrarCinta);

        tItem = new JLabel("item");
        tItem.setSize(30, 30);
        tItem.setLocation(10, 50);
        tItem.setForeground(Color.WHITE);
        tItem.setHorizontalAlignment(SwingConstants.CENTER);
        tItem.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        tItem.setBorder(null);
        pDerecha.add(tItem);

        tidCinta = new JLabel("id");
        tidCinta.setSize(30, 30);
        tidCinta.setLocation(40, 50);
        tidCinta.setForeground(Color.WHITE);
        tidCinta.setHorizontalAlignment(SwingConstants.CENTER);
        tidCinta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        tidCinta.setBorder(null);
        pDerecha.add(tidCinta);

        tNomPeli = new JLabel("Nombre de la Cinta");
        tNomPeli.setSize(180, 30);
        tNomPeli.setLocation(80, 50);
        tNomPeli.setForeground(Color.WHITE);
        tNomPeli.setHorizontalAlignment(SwingConstants.LEFT);
        tNomPeli.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        tNomPeli.setBorder(null);
        pDerecha.add(tNomPeli);

        tValor = new JLabel("Valor");
        tValor.setSize(60, 30);
        tValor.setLocation(240, 50);
        tValor.setForeground(Color.WHITE);
        tValor.setHorizontalAlignment(SwingConstants.LEFT);
        tValor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        tValor.setBorder(null);
        pDerecha.add(tValor);
    }

    public JLabel getlNombreCliente() {
        return lNombreCliente;
    }

    public JTextField gettBuscarPelicula() {
        return tBuscarPelicula;
    }

    public JTextField gettCinta() {
        return tCinta;
    }

    public JTextField gettValorCinta() {
        return tValorCinta;
    }

    public JTextField gettNombreUsuario() {
        return tNombreUsuario;
    }

    public JButton getbBusqueda() {
        return bBusqueda;
    }

    public JButton getbAgregar() {
        return bAgregar;
    }

    public JButton getbGuardar() {
        return bGuardar;
    }

    public JButton getbSalir() {
        return bSalir;
    }

    public ButtonGroup getBuscar() {
        return Buscar;
    }

    public JRadioButton getRbNombre() {
        return rbNombre;
    }

    public JRadioButton getRbActor() {
        return rbActor;
    }

    public JPanel getpDerecha() {
        return pDerecha;
    }

    public JPanel getpIzquierda() {
        return pIzquierda;
    }
}
