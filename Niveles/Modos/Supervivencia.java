package src.Niveles.Modos;
import src.Niveles.Nivel;
import src.Niveles.NivelSupervivencia;

public class Supervivencia extends ModoDeJuego{
    
    public Supervivencia(String ruta) {
        super(ruta);

    }

    public String getRuta(){
        return ruta;

    }
     public Nivel getNivel(){
        return new NivelSupervivencia();
    }
}
