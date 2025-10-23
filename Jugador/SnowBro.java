package src.Jugador;

import src.Fabricas.Sprites;
import src.Juego.Entidad;
import src.Juego.Personaje;
import src.Juego.Posicion;
import src.Visitor.Colisionable;
import src.Visitor.Colisionador;
import src.CapaDatos.ConstantesTeclado;
import src.CapaDatos.TeclasJugador;
import src.Municiones.Municion;

public class SnowBro extends Personaje implements Colisionador, Colisionable {
    protected EstadoS state;
    protected TeclasJugador teclas;

    public SnowBro(Sprites misSprites, Posicion posicion) {
        super(misSprites, posicion);
    }
    // @ttatimd SnowBro debe redefinir getSprites() para pedirselo a su state 
    
    public void moverse(){
        int paso = 2; // velocidad del movimiento

        //System.out.println("Y: "+posicion.getY()+"// X: "+posicion.getX());

        if (teclas.getArriba()) {
            if(posicion.getY() - paso < -10)
                posicion.setY(-10);
            else
                posicion.setY(posicion.getY() - paso);
        }
        if (teclas.getAbajo()) {
            if(posicion.getY() + paso > 520)
                posicion.setY(520);
            else
                posicion.setY(posicion.getY() + paso);
        }
        if (teclas.getIzquierda()) {
            if(posicion.getX() - paso < -10)
                posicion.setX(-10);
            else
                posicion.setX(posicion.getX() - paso);
        }
        if (teclas.getDerecha()) {
            if(posicion.getX() + paso > 760)
                posicion.setX(760);
            else 
                posicion.setX(posicion.getX() + paso);
        }

        notificarObservers();
    }

    public void setTeclas(TeclasJugador teclas){
        this.teclas=teclas;
    }

    public TeclasJugador getTeclasJugador(){
        return this.teclas;
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