package src.Niveles;
import src.Fabricas.FabricaEntidades;
import src.Niveles.Modos.ModoDeJuego;

public class AdministradorNivel {
   protected FabricaEntidades fabrica;
   protected String rutaActual;
   protected int indiceNivelActual;
   protected Nivel nivel;

   public AdministradorNivel(ModoDeJuego modo, FabricaEntidades fabricaEntidades){
      this.rutaActual= modo.getRuta();
      this.fabrica=fabricaEntidades;
      this.indiceNivelActual = 1;
      nivel = modo.getNivel();
      nivel.setFabricaEntidades(fabricaEntidades);
   }

   public String getRuta(){
      return  rutaActual;
   }

   public Nivel getSiguienteNivel(){
      LectorDeNivel lector = new LectorDeNivel();
      // HARCODEO
      nivel = lector.generarNivel(rutaActual, fabrica, nivel);
      //nivel = lector.generarNivel(rutaActual + "/" + indiceNivelActual + ".txt", fabrica, nivel);

      return nivel;
   }

   public Nivel getNivelActual(){
      return this.nivel;
   }

}
