package src.Enemigo;

import src.Juego.Personaje;
import src.Visitor.Colisionable;
import src.Visitor.Colisionador;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
public class Enemigo extends Personaje implements Colisionador, Colisionable{
    public Enemigo(Sprites sprites, Posicion posicion){
        super(sprites, posicion);
    }
}
