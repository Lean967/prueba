package src.Niveles;
import java.util.LinkedList;
import src.Jugador.Jugador;
import src.Jugador.SnowBro;
import src.Municiones.Municion;
import src.Juego.Entidad;
import src.Juego.Posicion;
import src.Obstaculos.Obstaculo;
import src.Enemigo.*;
import src.Powers.PowerUp;
import src.Plataformas.Plataforma;
import src.Fabricas.FabricaEntidades;
public abstract class Nivel {

    protected LinkedList<Entidad> listaEntidades;
    protected LinkedList<Obstaculo> obstaculos;
    protected LinkedList<Enemigo> enemigos;
    protected SnowBro snowBro;
    protected LinkedList<PowerUp> powers;
    protected LinkedList<Plataforma> plataformas;
    protected LinkedList<Municion> municiones;
    protected FabricaEntidades fabricaEntidades;
    protected int frecuenciaEnemigos;

    protected Nivel(){
        listaEntidades = new LinkedList<>();
        obstaculos = new LinkedList<>();
        enemigos = new LinkedList<>();
        powers = new LinkedList<>();
        plataformas = new LinkedList<>();
        municiones = new LinkedList<>();
    }

    public abstract void iniciarNivel();

    public void setFabricaEntidades (FabricaEntidades fabrica){
        this.fabricaEntidades=fabrica;
    }

    public Entidad obtenerEntidadEnPos(int x, int y);
    public abstract void reiniciar();
    

    // Enemigos

    //Jugador
    public void setSnowBro (int x, int y){
        this.snowBro= fabricaEntidades.getSnowBro(new Posicion(x, y));
    }

    // Obstaculos
    public void setTrampa(int x, int y);
    public void setPared(int x, int y);
    public void setSueloResbaladizo(int x, int y);
    public void setEscalera(int x, int y);
    public void setParedDestructible(int x, int y);
    
    // Powers
    public void setPocionAzul(int x, int y);
    public void setPocionRoja(int x, int y);
    public void setFruta(int x, int y);
    public void setPocionVerde(int x, int y);
    public void setVidaExtra(int x, int y);

    // Enemigos
    public void setCalabaza(int x, int y);
    public void setTrollAmarillo(int x, int y);
    public void setFantasma(int x, int y);
    public void setDemonioRojo(int x, int y){
        listaEntidades.addLast(fabricaEntidades.getDemonioRojo(new Posicion(x, y)));
    }
    public void setRanaDeFuego(){
        
    }
    public abstract void setMoguera();
    public abstract void setKamakichi();

    //Plataformas
    public void setPared(int x, int y);
    public void setSueloResbaladizo(int x, int y);
    public void setParedIndestructible(int x, int y);
    public void setTrampa(int x, int y);
    public void setEscalera(int x, int y);

    public void setPlataformaEstatica(int x, int y){
        listaEntidades.addLast(fabricaEntidades.getPlataformaEstatica(new Posicion(x, y)));
    }
    
    public void setPlataformaQuebradiza(int x, int y);
    public void setPlataformaMovediza(int x, int y);


    //Frecuencias (DUDOSO)
    public abstract void setFrecuenciaEnemigos(int frecuencia);
    public abstract void setFrecuenciaPowers(int frecuencia);

    public SnowBro getSnowBro(){
        return this.snowBro;
    }

    public Iterable<Entidad> getEntidades(){
        return this.listaEntidades;
    }

    public Iterable<Obstaculo> getObstaculos(){
        return this.obstaculos;
    }

    public Iterable<Enemigo> getEnemigos(){
        return this.enemigos;
    }

    public Iterable<PowerUp> getPowers(){
        return this.powers;
    }

    public Iterable<Plataforma> getPlataformas(){
        return this.plataformas;
    }

    public Iterable<Municion> getMuniciones(){
        return this.municiones;
    }
    
    
}
