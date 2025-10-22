package src.Niveles.Modos;
import src.Niveles.Nivel;
public abstract class ModoDeJuego {
    protected String ruta;
    
    protected ModoDeJuego(String ruta){
        this.ruta = ruta;
        // Juego va a crear los modos, pasandole la ruta a la carpeta con los archivos de texto por parametro
    }


    public abstract String getRuta();
    public abstract Nivel getNivel();
    
}
