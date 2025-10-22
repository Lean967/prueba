package src.GUI;

import java.awt.Dimension;

import src.CapaDatos.ConstantesVistas;
import src.GUI.InterfacesGUI.ControladorVistas;

public class PanelRanking extends PanelVista {
    public PanelRanking(ControladorVistas controladorVistas) {
        super(controladorVistas);
        setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));

    }
}
