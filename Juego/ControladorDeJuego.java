package src.Juego;
import src.Niveles.Modos.*;
public interface ControladorDeJuego {
    public void setDominio(String dominio);
    public void cambiarModoDeJuego(ModoDeJuego modo);
    public void iniciar();
}
