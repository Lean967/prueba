package src.GUI.Observers;

import src.Juego.EntidadLogica;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ObserverGrafico extends JLabel implements Observer{
    protected EntidadLogica entidadObservada;
    
    public ObserverGrafico(EntidadLogica observada){
        super();
        this.entidadObservada = observada;
        //this.update();
    }
    
    public void update(){
        actualizarImagen();
        actualizarPosicionTamaño();
    }

    protected void actualizarImagen(){
       
        String rutaImagen = entidadObservada.getSprites().getRutaImagenActual();
        if (!rutaImagen.startsWith("/")) {
          rutaImagen = "/" + rutaImagen;
        }
        URL url = getClass().getResource(rutaImagen);
        if (url != null) {
          setIcon(new ImageIcon(url));
        } else {
          setIcon(new ImageIcon()); // Icono vacío como fallback
        }
    }

    protected void actualizarPosicionTamaño(){
        int x = entidadObservada.getPosicion().getX();
        int y = entidadObservada.getPosicion().getY();
        int ancho = 48;
        int alto = 48;
        if (getIcon() != null && getIcon().getIconWidth() > 0) {
            ancho = getIcon().getIconWidth();
            alto = getIcon().getIconHeight();
        } else {
            setPreferredSize(new Dimension(ancho, alto));
        }
        setBounds(x, y, ancho, alto);
    }    
}
