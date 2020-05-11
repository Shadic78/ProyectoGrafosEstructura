package Controlador;

import Excepciones.VerticeExisteException;
import Excepciones.VerticeNoExisteException;
import Modelo.Vertice;
import Vista.PanelDibujo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Equipo1
 */
public class GraphMouseManager extends MouseAdapter {
    private final PanelDibujo grafico;
    private int xd = 0;

    public GraphMouseManager(PanelDibujo grafico) {
        this.grafico = grafico;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        try {
            Vertice<String> vertice = new Vertice<String>("Vertice " + xd, e.getX(), e.getY());
            xd++;
            grafico.getGrafo().nuevoVertice(vertice);
            if(xd > 1) {
                try {
                    grafico.getGrafo().union("Vertice " + (xd - 1), "Vertice " + (xd - 2));
                } catch (VerticeNoExisteException ex) {
                    Logger.getLogger(GraphMouseManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        } catch (VerticeExisteException ex) {
            Logger.getLogger(GraphMouseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        grafico.repaint();
    }

}
