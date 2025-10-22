package src.Plataformas;

import src.Fabricas.Sprites;
import src.Juego.Entidad;
import src.Juego.Posicion;
import src.Visitor.Colisionable;
public class Plataforma extends Entidad implements Colisionable{
    public Plataforma(Sprites sprites, Posicion posicion){
        super(sprites, posicion);
    }
}
