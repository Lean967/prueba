package src.Jugador;


public class Jugador {
    protected String nombre;
    protected SnowBro snowBro;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setSnowBro(SnowBro snowBro) {
        this.snowBro = snowBro;
    }

    public SnowBro getSnowBro() {
        return this.snowBro;
    }


}
