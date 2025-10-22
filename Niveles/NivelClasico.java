package src.Niveles;

import java.util.LinkedList;

import src.CapaDatos.ConstantesVistas;
import src.Enemigo.JefeDeNivel;
import src.Juego.Entidad;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
public class NivelClasico extends Nivel {
    protected JefeDeNivel jefe;
    
    public NivelClasico (){
        super();
    }

    public void iniciarNivel(){

    }

    public void reiniciar() {
    }


    public void setTrollAmarillo(int x, int y) {
    }

    public void setRanaDeFuego(int x, int y) {
    }

    public void setFantasma(int x, int y) {
    }
    public void setCalabaza(int x, int y) {
    }


    public void setTrampa() {
    }

    public void setPared() {
    }
    public void setSueloResbaladizo() {
    }

    public void setEscalera() {
    }

    public void setParedDestructible() {
    }

    public void setPocionAzul() {

    }

    public void setPocionRoja() {
    }

    public void setFruta() {
    }

    @Override
    public void setPocionVerde() {

    }

    @Override
    public void setVidaExtra() {

    }

    @Override
    public void setCalabaza() {

    }

    @Override
    public void setTrollAmarillo() {

    }

    @Override
    public void setFantasma() {

    }

    @Override
    public void setRanaDeFuego() {

    }

    @Override
    public void setMoguera() {

    }

    @Override
    public void setKamakichi() {

    }

    @Override
    public void setPared(int x, int y) {

    }

    @Override
    public void setSueloResbaladizo(int x, int y) {

    }

    @Override
    public void setParedIndestructible(int x, int y) {

    }

    @Override
    public void setTrampa(int x, int y) {

    }

    @Override
    public void setEscalera(int x, int y) {

    }

    @Override
    public void setPlataformaEstatica(int x, int y) {

    }

    @Override
    public void setPlataformaQuebradiza(int x, int y) {

    }

    @Override
    public void setPlataformaMovediza(int x, int y) {
        super.setPlataformaMovediza(x, y);
    }

    @Override
    public void setFrecuenciaEnemigos(int frecuencia) {

    }

    @Override
    public void setFrecuenciaPowers(int frecuencia) {

    }
    
}
