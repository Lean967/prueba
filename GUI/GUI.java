package src.GUI;

import javax.swing.JFrame;

import src.CapaDatos.ConstantesVistas;
import src.CapaDatos.TeclasJugador;
import src.GUI.InterfacesGUI.ControladorGrafica;
import src.GUI.InterfacesGUI.ControladorVistas;
import src.GUI.Observers.Observer;
import src.GUI.Observers.ObserverJugador;
import src.Juego.ControladorDeJuego;
import src.Juego.EntidadLogica;
import src.Jugador.Jugador;
import src.Jugador.SnowBro;

public class GUI implements ControladorGrafica, ControladorVistas {
    protected JFrame ventana;
    protected PanelPartida panelPartida;
    protected PanelMenu panelMenu;
    protected PanelRanking panelRanking;
    protected ControladorDeJuego controladorJuego;

    public GUI(){
        panelPartida = new PanelPartida(this);
        panelMenu = new PanelMenu(this);
        panelRanking = new PanelRanking(this);
    }

    public void configurarVentana(){
        ventana = new JFrame("TdP :: Snowbros Nick & Tom");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(ConstantesVistas.VENTANA_ANCHO, ConstantesVistas.VENTANA_ALTO);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setFocusable(true);

        mostrarPantallaMenu();
	}
    
    public void iniciarJuego(){
        controladorJuego.iniciar();
    }

    public Observer registrarSnowBro(SnowBro snowBro){
        Observer observerJugador = panelPartida.incorporarSnowBro(snowBro);
        actualizarGUI();
        return observerJugador;
    }

    public Observer registrarEntidad(EntidadLogica entidad){
        Observer observerEntidad = panelPartida.incorporarEntidad(entidad);
        actualizarGUI();
        return observerEntidad;
    }

    public void configurarControles(SnowBro snowBro){
        panelPartida.configurarTeclasJugador(snowBro);

    }

    public void mostrarPantallaMenu(){
        ventana.setContentPane(panelMenu);
        actualizarGUI();
    }

    public void mostrarPantallaPartida(){
        ventana.setContentPane(panelPartida);
        actualizarGUI();
    }

    public void mostrarPantallaRanking(){
        ventana.setContentPane(panelRanking);
        actualizarGUI();
    }

    public void mostrarPantallaFinDeJuego(){

    }


    protected void actualizarGUI() {
		ventana.revalidate();
		ventana.repaint();
	}

    public void registrarControladorDeJuego(ControladorDeJuego juego) {
        this.controladorJuego = juego;
    }

    public PanelPartida getPanelPartida() {
        return panelPartida;
    }
    
}