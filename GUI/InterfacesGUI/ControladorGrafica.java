package src.GUI.InterfacesGUI;
import src.Juego.EntidadLogica;

import javax.swing.JFrame;

import src.GUI.PanelPartida;
import src.GUI.Observers.Observer;
import src.Juego.ControladorDeJuego;
import src.Jugador.SnowBro;

public interface ControladorGrafica {
    public void mostrarPantallaPartida();
    public void mostrarPantallaRanking();
    public void mostrarPantallaMenu();
    public void mostrarPantallaFinDeJuego();
    public void registrarControladorDeJuego(ControladorDeJuego juego);
    public Observer registrarEntidad(EntidadLogica entidad);
    public Observer registrarSnowBro(SnowBro snowBro);
    public void configurarVentana();

    public PanelPartida getPanelPartida();
}
