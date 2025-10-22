package src.Niveles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import src.Fabricas.FabricaEntidades;

public class LectorDeNivel {
    
    public LectorDeNivel() {
    }

    public Nivel generarNivel(String rutaNivel, FabricaEntidades fabricaEntidades, Nivel nivel) {
       //TODO implementar

        try(BufferedReader lector = new BufferedReader(new FileReader(rutaNivel))){
            String linea;

            while((linea = lector.readLine()) != null){
                linea = linea.trim(); // Quitar espacios al inicio/final
                if(linea.isEmpty() || linea.startsWith("#")){ // Ignorar líneas vacías o comentarios
                    continue;
                }

                parsearLinea(linea,  fabricaEntidades, nivel);


            }
            
        }catch (IOException e) {
            System.err.println("Error al leer el archivo de nivel: " + rutaNivel);
        }
        catch (NumberFormatException e) {
             System.err.println("Error de formato numérico en el archivo de nivel: " + rutaNivel);
        }

        return nivel;
    }

    private void parsearLinea(String linea,FabricaEntidades fabricaEntidades ,Nivel nivel) {
        String[] partes = linea.split(":", 2);
        if (partes.length != 2) {
            System.err.println("Formato de línea incorrecto: " + linea);
            return;
        }

        String tipoEntidad = partes[0].toUpperCase();
        Map<String, String> parametros = parsearParametros(partes[1]);

        int x = Integer.parseInt(parametros.get("x"));
        int y = Integer.parseInt(parametros.get("y"));

        switch (tipoEntidad) {
            //SNOWBRO
            case "SNOWBRO":
                nivel.setSnowBro(x, y);
                break;
            //ENEMIGOS
            case "DEMONIOROJO":
                nivel.setDemonioRojo(x, y);
                break;
            //PLATAFORMAS Y ELEMENTOS
             case "PARED":
                 nivel.setPared(x, y);
                 break;
            case "SUELORESBALADIZO":
                nivel.setSueloResbaladizo(x, y);
                break;
            case "PAREDINDESTRUCTIBLE":
                nivel.setParedIndestructible(x, y);
                break;
            case "TRAMPA":
                nivel.setTrampa(x, y);
                break;
            case "ESCALERA":
                nivel.setEscalera(x, y);
                break;
            case "PLATAFORMAESTATICA":
                nivel.setPlataformaEstatica(x, y);
                break;
            case "PLATAFORMAQUEBRADIZA":
                nivel.setPlataformaQuebradiza(x, y);
                break;
            case "PLATAFORMAMOVEDIZA":
                nivel.setPlataformaMovediza(x, y);
                break;
            default:
                System.err.println("Tipo de entidad desconocido: " + tipoEntidad);
                break;
        }
    }

    private Map<String, String> parsearParametros(String parametrosString) {
        Map<String, String> parametros = new HashMap<>();
        String[] pares = parametrosString.split(",");
        for (String par : pares) {
            String[] claveValor = par.split("=", 2);
            if (claveValor.length == 2) {
                parametros.put(claveValor[0].trim().toLowerCase(), claveValor[1].trim()); // Clave en minúscula
            }
        }
        return parametros;
    }



}