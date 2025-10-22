package src.GUI;

import javax.swing.*;
import java.awt.*;

import src.CapaDatos.ConstantesVistas;
import src.GUI.InterfacesGUI.ControladorVistas;
import src.GUI.Observers.Observer;
import src.GUI.Observers.ObserverGrafico;
import src.GUI.Observers.ObserverJugador;
import src.Juego.EntidadLogica;
import src.Jugador.Jugador;
import src.Jugador.SnowBro;

public class PanelPartida extends PanelVista{
    private JLabel lienzoJuego;

    public PanelPartida(ControladorVistas controladorVistas) {
        super(controladorVistas);
        setFocusable(true);
        setLayout(null);
        setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));
        configurarLienzo();
    }

    protected void configurarLienzo(){
        lienzoJuego = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/src/imagenes/Fondonivel2.png"));
        Image imagenEscalada = iconoImagen.getImage();
		imagenEscalada = imagenEscalada.getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO,  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
		lienzoJuego.setIcon(iconoImagenEscalado);
		lienzoJuego.setBounds(0,0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		add(lienzoJuego);
    }

    public Observer incorporarSnowBro(SnowBro snowBro){
        ObserverJugador observerJugador = new ObserverJugador(this, snowBro);
        Dimension preferida = observerJugador.getPreferredSize();
        if (preferida == null || preferida.width == 0 || preferida.height == 0) {
          preferida = new Dimension(48, 48); // Ajustar según el tamaño real del sprite
          observerJugador.setPreferredSize(preferida);
        }
        observerJugador.setSize(preferida);
        //PARA QUE SIRVE ESTO?
        //observerJugador.setLocation((ConstantesVistas.PANEL_ANCHO - preferida.width) / 2, (ConstantesVistas.PANEL_ALTO - preferida.height) / 2);
    
        lienzoJuego.add(observerJugador);
        lienzoJuego.setComponentZOrder(observerJugador, 0);
        observerJugador.update();
        actualizar();
        return observerJugador;
    }

    public Observer incorporarEntidad(EntidadLogica entidad){
        ObserverGrafico observerEntidad = new ObserverGrafico( entidad);
        lienzoJuego.add(observerEntidad);

        actualizar();
        return observerEntidad;
    }

    

    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }

    protected void actualizar(){
        revalidate();
        repaint();
    }
}
