package Controlador;

import Excepciones.VerticeExisteException;
import Modelo.Vertice;
import Vista.PanelDibujo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    public void mouseClicked(MouseEvent e) {
        try {
            Vertice<String> vertice = new Vertice<String>(
                    " ",
                    e.getX() - grafico.getDesign().getDIAMETRO_VERTICES() / 2,
                    e.getY() - grafico.getDesign().getDIAMETRO_VERTICES() / 2);
            grafico.getGrafo().nuevoVertice(vertice);    
            grafico.repaint();            
            
            String nombre = JOptionPane.showInputDialog("Nombre del vértice: ");            
            vertice.setElemento(nombre);
        } catch (VerticeExisteException ex) {
            Logger.getLogger(GraphMouseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        grafico.repaint();
    } 

    @Override
    public void mousePressed(MouseEvent e) {

    }

}
