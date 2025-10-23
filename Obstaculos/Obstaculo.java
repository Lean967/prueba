package src.Obstaculos;
import src.Fabricas.Sprites;
import src.Juego.Entidad;
import src.Juego.Posicion;
import src.Visitor.Colisionable;
public class Obstaculo extends Entidad  implements Colisionable {
    public Obstaculo(Sprites sprites, Posicion pos){
        super(sprites, pos);
    }
    
}
