package src.Jugador;

import src.Fabricas.Sprites;
import src.Juego.Posicion;

public class SnowNormal extends SnowBro implements EstadoS{

    public SnowNormal(Sprites misSprites, Posicion posicion) {
        super(misSprites, posicion);
    }
        // @ttatimd hay que setear los Sprites correspondientes a cada estado
    public Sprites getSprites(){
        return this.misSprites;
    }
    
}
