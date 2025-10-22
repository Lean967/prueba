package src.Niveles.Modos;
import src.Niveles.Nivel;
import src.Niveles.NivelContrarreloj;
public class Contrarreloj extends ModoDeJuego {
    

    public Contrarreloj(String ruta) {
        super(ruta);

    }

    public String getRuta(){
        return ruta;

    }

    public Nivel getNivel(){
        return new NivelContrarreloj();
    }
}
