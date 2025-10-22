package src.GUI.Observers;

import java.awt.Dimension;
import java.awt.Panel;

import src.GUI.PanelPartida;
import src.Jugador.SnowBro;

public class ObserverJugador extends ObserverGrafico{
    private PanelPartida panelPartida;
    private SnowBro snowBroObservado;

    public ObserverJugador(PanelPartida panelPartida, SnowBro jugadorObservado){
        super(jugadorObservado);
        this.panelPartida = panelPartida;
        this.snowBroObservado = jugadorObservado;
        setOpaque(false);
        ajustarTamañoPorDefecto();
        update();
    }

    private void ajustarTamañoPorDefecto(){
        Dimension pref = getPreferredSize();
        if (pref == null || pref.width == 0 || pref.height == 0) {
            pref = new Dimension(48, 48); // ajustar según tamaño real del sprite
            setPreferredSize(pref);
        }
        setSize(pref);
    }

    public void update(){
        super.update();
        setLocation(snowBroObservado.getPosicion().getX(), snowBroObservado.getPosicion().getY());
        // Asegura que tenga tamaño visible en layouts null
        ajustarTamañoPorDefecto();
        revalidate();
        repaint();
    }
}
