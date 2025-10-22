package src.Fabricas;

import java.util.Map;

public class Sprites {
    protected Map<Integer, String> estadoImagen;
    protected int estadoActual;

    public Sprites(Map<Integer, String> mapeoEstadoImagen, int estadoInicial){
        this.estadoImagen = mapeoEstadoImagen;
        this.estadoActual = estadoInicial;
    }

    public void setEstadoActual(int estado){
        this.estadoActual = estado;
    }

    public String getRutaImagenActual(){
        return estadoImagen.get(estadoActual);
    }
}
