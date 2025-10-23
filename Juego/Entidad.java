package src.Juego;

import java.util.LinkedList;
import java.util.List;
import src.Fabricas.Sprites;
import src.GUI.Observers.Observer;
import src.Visitor.Colisionable;

public class Entidad implements EntidadLogica, Colisionable { 
    protected Posicion posicion;
    protected List<Observer> observers;
    protected Sprites misSprites;

    public Entidad(Sprites sprites, Posicion pos){
        this.misSprites = sprites;
        this.posicion = pos;
        this.observers= new LinkedList<>();
    }
    public void aceptarColision(Entidad e){

    }
    public void getState(){}
    public void setState(){}

    public void update(){
        // @ssunburst
        for (Observer o : observers) {
            o.update();
        }
    }
    
    public void registrarObserver(Observer observer){
        this.observers.add(observer);
    }

    public void setPosicion(int deltax, int deltay){
        this.posicion.setX(posicion.getX()+deltax);
        this.posicion.setY(posicion.getY()+deltay);
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public Sprites getSprites() {
        return misSprites;
    }
    
    protected void notificarObservers() {
        for (Observer o : observers) {
            o.update(); // llama al método update() del observer (como en ObserverJugador)
        }
    }
}
