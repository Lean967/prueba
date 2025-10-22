package src.Fabricas;

import src.Enemigo.*;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Plataformas.*;
public class FabricaEntidades {
    protected FabricaSprites sprites;

    public FabricaEntidades (FabricaSprites fabrica){
        sprites=fabrica;
    }

    // Nivel llama a estos metodos con la posicion que le sea indicada mediante LectorDeNivel
    public DemonioRojo getDemonioRojo(Posicion pos){
        DemonioRojo demonio= new DemonioRojo(sprites.getSpritesDemonioRojo(), pos);
        return demonio;
    }

    public SnowBro getSnowBro(Posicion pos){
        SnowBro snow= new SnowBro(sprites.getSpritesSnowBro(), pos);
        return snow;
    }

    public Estatica getPlataformaEstatica(Posicion pos){
        return new Estatica(sprites.getSpritesEstatica(),pos);
    }
}
