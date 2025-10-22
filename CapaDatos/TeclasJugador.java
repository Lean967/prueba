package src.CapaDatos;

import java.awt.event.KeyAdapter;//permite eschuchar los eventos del teclado
import java.awt.event.KeyEvent;//representa un evento de teclado. Cada vez que el usuario presiona, suelta o escribe una tecla, se genera un KeyEvent que nos permite saber que tecla se presionó
import java.awt.event.KeyListener;

import src.Juego.Entidad;

public class TeclasJugador implements KeyListener{
    private boolean arriba, abajo, izquierda, derecha,quieto;
    protected Entidad entidad;
    protected int direccion;

    public TeclasJugador(Entidad entidad) {
        arriba = false;
        abajo = false;
        izquierda = false;
        derecha = false;
        quieto=true;

        this.entidad = entidad;
        this.direccion = ConstantesTeclado.Quieto; 
    }

    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        switch(tecla) {
            case KeyEvent.VK_W:
                arriba = true;
                break;
            case KeyEvent.VK_S:    
                abajo = true;
                break;
            case KeyEvent.VK_A: 
                izquierda = true;
                break;
            case KeyEvent.VK_D:
                derecha = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int tecla = e.getKeyCode();
        switch(tecla) {
            case KeyEvent.VK_W:
                arriba = false;
                break;
            case KeyEvent.VK_S:
                abajo = false;
                break;
            case KeyEvent.VK_A:
                izquierda = false;
                break;
            case KeyEvent.VK_D:
                derecha = false;
                break;
        }
    }
    public void keyTyped(KeyEvent e) {}
    public boolean getArriba(){
        return arriba;
    }
    public boolean getAbajo(){
        return abajo;
    }
    public boolean getIzquierda(){
        return izquierda;
    }
    public boolean getDerecha(){
        return derecha;
    }

    public int get_direccion(){
        if(arriba) return -1;
        if(abajo) return 1;
        if(izquierda) return -10;
        if(derecha) return 10;
        if(quieto) return 0;
        return 0;
    }
}