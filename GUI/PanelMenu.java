package src.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import src.CapaDatos.ConstantesVistas;
import src.GUI.InterfacesGUI.ControladorVistas;

public class PanelMenu extends PanelVista{

    private JLabel imagenMenu;
    private JButton botonIniciarPartida;
    private JButton botonRanking;
    

    public PanelMenu(ControladorVistas controladorVistas) {
        super(controladorVistas);
        setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        setLayout(null);
        agregarImagenFondo();
        agregarBotonIniciarPartida();
        //Forzamos el botón a estar en la capa superior 
        setComponentZOrder(botonIniciarPartida, 0);
        setFocusable(true);
        // Para que el boton de Iniciar Partida START aparezca despues de 1 seg
        iniciarTimerAparicion(1000);
    }

    protected void agregarImagenFondo(){
        imagenMenu = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/src/imagenes/pantallainicio.jpeg"));
        Image imagenEscalada = iconoImagen.getImage();
		imagenEscalada = imagenEscalada.getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO,  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
		imagenMenu.setIcon(iconoImagenEscalado);
		imagenMenu.setBounds(0,0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		add(imagenMenu);
    }   

    protected void agregarBotonIniciarPartida(){
        botonIniciarPartida = new JButton();
        botonIniciarPartida.setVisible(false);
        botonIniciarPartida.setBounds((ConstantesVistas.PANEL_ANCHO / 2) - 100 ,ConstantesVistas.PANEL_ALTO - 150, 200 , 50);
        // Hacer el botón transparente
        botonIniciarPartida.setOpaque(false);
        botonIniciarPartida.setContentAreaFilled(false);
        botonIniciarPartida.setBorderPainted(false);
        botonIniciarPartida.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/start_icono.png"));        
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(botonIniciarPartida.getWidth(), botonIniciarPartida.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonIniciarPartida.setIcon(iconoImagenEscalado);

        botonIniciarPartida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.mostrarPantallaPartida();
                controladorVistas.iniciarJuego();
            }
        });

        this.add(botonIniciarPartida);
    }
    private void iniciarTimerAparicion(int delay) {
        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botonIniciarPartida.setVisible(true); // Hace visible el botón
                PanelMenu.this.revalidate();
                PanelMenu.this.repaint();
                ((Timer)e.getSource()).stop();       // Detiene el Timer después de la ejecución
            }
        });
        timer.setRepeats(false); // Asegura que se ejecute una sola vez
        timer.start();
    }

    // Cuando el panel se agrega a la ventana, pedimos el foco para que reciba eventos del teclado sin hacer clic
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }

    /*protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja portada escalada al tamaño del panel
        g.drawImage(portada, 0, 0, getWidth(), getHeight(), this);
        
    }*/


}