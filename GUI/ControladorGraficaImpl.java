package src.GUI;

import javax.swing.JFrame;
import src.GUI.InterfacesGUI.ControladorGrafica;
import src.GUI.Observers.Observer;
import src.Juego.ControladorDeJuego;
import src.Juego.EntidadLogica;
import src.Jugador.SnowBro;

public class ControladorGraficaImpl implements ControladorGrafica {
    private PanelPartida panelPartida;;
    
    public ControladorGraficaImpl() {
        ventanaPrincipal = new JFrame("Snow Bros");
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLayout(null);
    }

    @Override
    public void configurarVentana() {
        ventanaPrincipal.setVisible(true);
    }

    @Override
    public void mostrarPantallaMenu() {
        // Implementación...
    }

    @Override
    public void mostrarPantallaPartida() {
        // Implementación...
    }

    @Override
    public void mostrarPantallaRanking() {}

    @Override
    public void mostrarPantallaFinDeJuego() {}

    @Override
    public void registrarControladorDeJuego(ControladorDeJuego juego) {}

    @Override
    public Observer registrarEntidad(EntidadLogica entidad) {
        return null;
    }

    @Override
    public Observer registrarSnowBro(SnowBro snowBro) {
        return null;
    }

    // ✅ Método nuevo:
    @Override
    public PanelPartida getPanelPartida() {
        return panelPartida;
    }
}