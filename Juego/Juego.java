package src.Juego;

import src.CapaDatos.TeclasJugador;
import src.Fabricas.FabricaEntidades;
import src.Fabricas.FabricaSprites;
import src.Fabricas.SpritesOriginal;
import src.Fabricas.SpritesPersonal;
import src.GUI.InterfacesGUI.ControladorGrafica;
import src.GUI.Observers.Observer;
import src.GUI.Observers.ObserverJugador;
import src.Jugador.Jugador;
import src.Jugador.SnowBro;
import src.Niveles.AdministradorNivel;
import src.Niveles.Nivel;
import src.Niveles.Modos.Clasico;
import src.Niveles.Modos.ModoDeJuego;

public class Juego implements ControladorDeJuego{
    protected Jugador jugador; //me parece mucho tener a jugador, puntaje y ranking en juego.
    protected int puntaje;
    protected ModoDeJuego modoDeJuego;
    protected Ranking ranking;
    protected ControladorGrafica controladorGrafica;
    protected AdministradorNivel administradorNivel;
    protected Nivel nivelActual; //lo sacaria si esta en administradorNivel
    protected FabricaEntidades fabricaEntidades;


    public Juego(ControladorGrafica grafica){
        this.controladorGrafica = grafica;
        this.ranking = new Ranking();

        //HARDCODEO
        this.modoDeJuego = new Clasico("src/CapaDatos/Clasico/EjemploArchivoNivel.txt");
        fabricaEntidades = new FabricaEntidades(new SpritesOriginal());
    }

    public void setDominio(String Dominio){
        // va a haber que crear clases de tipo Dominio donde c/u tenga su propia fabrica de sprites
        // entonces Juego va a poder hacer dominio.getFabrica y asociarsela a la fabrica de entidades
    }

    @Override
    public void cambiarModoDeJuego(ModoDeJuego modo) {
        this.modoDeJuego = modo;
    }

    //lo llama Launcher
    public void configurar(){
        controladorGrafica.configurarVentana();
        controladorGrafica.mostrarPantallaMenu();
    }

    public void iniciar() {
        this.administradorNivel = new AdministradorNivel(modoDeJuego, fabricaEntidades);
        Jugador jugadorSnowBro = new Jugador("pou");
        this.jugador = jugadorSnowBro;
        nivelActual = administradorNivel.getSiguienteNivel();
        jugador.setSnowBro(administradorNivel.getNivelActual().getSnowBro());
        nivelActual.iniciarNivel();
        registrarObservers();
        configurarControles();
        controladorGrafica.mostrarPantallaPartida();

        hacerCicloDeJuego();
    }

    protected void registrarObservers(){
        registrarObserverJugador(administradorNivel.getNivelActual().getSnowBro());
        registrarObserverEntidades(administradorNivel.getNivelActual().getEntidades());
    }

    protected void configurarControles(){
        controladorGrafica.configurarControles(jugador.getSnowBro());
    }

    protected void registrarObserverJugador(SnowBro snowBro){
        Observer observerJugador = controladorGrafica.registrarSnowBro(snowBro);
        snowBro.registrarObserver(observerJugador);

    }

    protected void registrarObserverEntidades(Iterable<Entidad> entidades){
        for (Entidad entidad : entidades) {
            Observer observerEntidad = controladorGrafica.registrarEntidad(entidad);
            entidad.registrarObserver(observerEntidad);
        }
        
    }

    public void setFabricaEntidades(FabricaEntidades fabrica){
        this.fabricaEntidades = fabrica;
    }

    public void hacerCicloDeJuego(){
        javax.swing.Timer timer = new javax.swing.Timer(20, e -> {
            jugador.getSnowBro().moverse();
            });
        timer.start();
    }


    /*public void crearFabricaOriginal(){
        FabricaSprites fabricaSprites = new SpritesOriginal();
        this.fabricaEntidades = new FabricaEntidades(fabricaSprites);
    }

    public void crearFabricaPersonal(){
        FabricaSprites fabricaSprites = new SpritesPersonal();
        this.fabricaEntidades = new FabricaEntidades(fabricaSprites);
    }*/
}