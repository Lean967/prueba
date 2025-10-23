package src.Municiones;
import src.Fabricas.Sprites;
import src.Juego.Entidad;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class Municion extends Entidad implements Colisionador {
    public Municion(Sprites sprites, Posicion pos){
        super(sprites, pos);
    }
}
