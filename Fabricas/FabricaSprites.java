package src.Fabricas;

import java.util.HashMap;
import java.util.Map;

public abstract class FabricaSprites {
    protected String rutaASprites;

    protected FabricaSprites(){
        //HARCODEO
        this.rutaASprites = "src/imagenes/";
    }

    /*private Map<Integer,String> getMapeoImagenHarcoding(String imagen_unica){
		Map<Integer,String> mapeo_estado_imagen = new HashMap<Integer,String>();
		String ruta_a_imagen_unica = rutaASprites + "/" + imagen_unica;
		mapeo_estado_imagen.put(0, ruta_a_imagen_unica);
		return mapeo_estado_imagen;
	} */


    public Sprites getSpritesDemonioRojo() {
        // probar setear sin los state para ver si logramos mostrar el demonio y el Snow
        // supongo 1 DemonioRojo quieto, quien lo usara el demonio rojo en State normal
        // supongo 2 DemonioRojo caminando (podria haber un State moviendose, ya que el observer hara getState().getSprites() y tiene que devolverle el icono)
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(1, rutaASprites+"/demonio_rojo/Botom_01.png");
        return (new Sprites (mapeoSprites, 01));
	}

    public Sprites getSpritesSnowBro(){
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(1, rutaASprites+"/SnowBro/snow01.png");
        return (new Sprites (mapeoSprites, 01));
    }

    public Sprites getSpritesEstatica(){
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(1, rutaASprites+"/platform.png");
        return (new Sprites (mapeoSprites, 01));
    }
}
