package Controlador;

import Excepciones.VerticeExisteException;
import Excepciones.VerticeNoExisteException;
import Modelo.Vertice;
import Vista.PanelDibujo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
                    "        ",
                    e.getX() - grafico.getDesign().getDIAMETRO_VERTICES() / 2,
                    e.getY() - grafico.getDesign().getDIAMETRO_VERTICES() / 2);
            grafico.getGrafo().nuevoVertice(vertice);    
            grafico.repaint();            
            
            String nombre = JOptionPane.showInputDialog("Nombre del vértice: ");   
            
            if(nombre != null) {
                /*grafico.getGrafo().nuevoVertice(new Vertice(nombre));
                grafico.getGrafo().borrarVertice(nombre);

                vertice.setElemento(nombre);
                grafico.repaint();

                vertice.setElemento(nombre);   */
                if(grafico.getGrafo().existeVertice(nombre)) {
                    grafico.getGrafo().borrarVertice("        ");
                    throw new VerticeExisteException("El vértice ya existe");
                }
                else {
                    grafico.getGrafo().borrarVertice("        ");                    
                    vertice.setElemento(nombre);
                    grafico.getGrafo().nuevoVertice(vertice);
                    grafico.repaint();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Se canceló la creación del vértice");
                grafico.getGrafo().borrarVertice("        ");
            }
            
        } catch (VerticeExisteException ex) {
            JOptionPane.showMessageDialog(null, "El vértice ya existe");
            grafico.repaint();
        } catch (VerticeNoExisteException ex) {
            Logger.getLogger(GraphMouseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Se alcanzo el límite de vértices");
            try {            
                grafico.getGrafo().borrarVertice("        ");
            } catch (VerticeNoExisteException ex1) {
                Logger.getLogger(GraphMouseManager.class.getName()).log(Level.SEVERE, null, ex1);
            }
            grafico.repaint();            
        }
        grafico.repaint();
    } 

    @Override
    public void mousePressed(MouseEvent e) {

    }

}
