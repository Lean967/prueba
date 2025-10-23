package src.Juego;

import java.util.ArrayList;
import java.util.List;

import src.Enemigo.Enemigo;
import src.Jugador.SnowBro;
import src.Municiones.Municion;
import src.Niveles.Nivel;
import src.Visitor.Colisionable;

public class ControladorColisiones {
    protected Nivel nivel;

    public ControladorColisiones(Nivel nivel){
        this.nivel = nivel;
    }

    public void detectarColisiones(){
        List<Entidad> pasivos = new ArrayList<>();
        List<Enemigo> enemigos = new ArrayList<>();
        List<Municion> municiones = new ArrayList<>();

        for(Entidad  plataforma: nivel.getPlataformas()){
            pasivos.add(plataforma);
        }
        for(Entidad obstaculo: nivel.getObstaculos()){
            pasivos.add(obstaculo);
        }
        for(Entidad powerUp : nivel.getPowers()){
            pasivos.add(powerUp);
        }
        for(Enemigo enemigo: nivel.getEnemigos()){
            enemigos.add(enemigo);
        }
        for(Municion municion: nivel.getMuniciones()){
            municiones.add(municion);
        }
        SnowBro snowBro = nivel.getSnowBro();

        //Colisiones SnowBro - Enemigos
        for(Enemigo enemigo : enemigos){
            if(estanColisionando(snowBro, enemigo)){
                enemigo.aceptarColision(snowBro);
            }
        }

        //Colisiones SnowBro - Proyectiles
        for(Municion municion : municiones){
            if(estanColisionando(snowBro, municion)){
                snowBro.aceptarColision(municion);
            }
        }

        //Colisiones SnowBro - Pasivos
        for(Entidad pasivo : pasivos){
            if(estanColisionando(snowBro, pasivo)){
                pasivo.aceptarColision(snowBro);
            }
        }

        //colisiones Enemigos - Proyectiles
        for(Enemigo enemigo : enemigos){
            for(Municion municion : municiones){
                if(estanColisionando(enemigo, municion)){
                    enemigo.aceptarColision(municion);
                }
            }
        }

        //colisiones Enemigos - Pasivos
        for(Enemigo enemigo : enemigos){
            for(Entidad pasivo : pasivos){
                if(estanColisionando(enemigo, pasivo)){
                    pasivo.aceptarColision(enemigo);
                }
            }
        }
    }

    protected boolean estanColisionando(Entidad entidad1, Entidad entidad2) {
        // --- DEBES REEMPLAZAR ESTO ---
        int anchoEntidad1 = 48; // Reemplazar con e1.getAncho()
        int altoEntidad1 = 48;  // Reemplazar con e1.getAlto()
        int anchoEntidad2 = 48; // Reemplazar con e2.getAncho()
        int altoEntidad2 = 48;  // Reemplazar con e2.getAlto()
        // -----------------------------

        int xEntidad1 = entidad1.getPosicion().getX();
        int yEntidad1 = entidad1.getPosicion().getY();
        int xEntidad2 = entidad2.getPosicion().getX();
        int yEntidad2 = entidad2.getPosicion().getY();

        // Lógica de colisión AABB
        return (xEntidad1 < xEntidad2 + anchoEntidad2 &&
                xEntidad1 + anchoEntidad1 > xEntidad2 &&
                yEntidad1 < yEntidad2 + altoEntidad2 &&
                yEntidad1 + altoEntidad1 > yEntidad2);
    
        }
}
