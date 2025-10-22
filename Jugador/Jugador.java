package src.Jugador;


public class Jugador {
    protected String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }


}
