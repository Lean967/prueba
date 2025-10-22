package src.Niveles.Modos;
import src.Niveles.Nivel;
import src.Niveles.NivelClasico;

public class Clasico extends ModoDeJuego {

    public Clasico(String ruta) {
        super(ruta);
    }

    public String getRuta(){
        return ruta;
    }

    public Nivel getNivel(){
        return new NivelClasico();
    }
}
