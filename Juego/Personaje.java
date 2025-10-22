package src.Juego;

import src.CapaDatos.EstadoDireccion;
import src.Fabricas.Sprites;
import src.Municiones.Municion;

public class Personaje extends Entidad {
    protected int vida;
    protected int velocidad;

    public Personaje(Sprites misSprites, Posicion posicion) {
        super(misSprites, posicion);
    }
    public void moverse(EstadoDireccion ed){

    }
    public void recibirAtaque(Municion m){

    }
    public void disparar(){

    }
    public void aumentarPuntaje(int puntos){

    }
    public void subirBajarPlataforma(){

    }
    public void recibirImpacto(Personaje p){

    }
    public void saltar(){

    }
    public void acceptColision(Entidad e){

    }
    public void getState(){

    }
    public void setState(){

    }
   
}
