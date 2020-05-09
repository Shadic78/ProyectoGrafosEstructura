package Controlador;

import Vista.PanelDibujo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Equipo1
 */
public class GraphMouseManager extends MouseAdapter {
    private final PanelDibujo grafico;

    public GraphMouseManager(PanelDibujo grafico) {
        this.grafico = grafico;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        grafico.coordX.add(e.getX());
        grafico.coordY.add(e.getY());
        grafico.repaint();
        System.out.println("Presionado");
    }

}
