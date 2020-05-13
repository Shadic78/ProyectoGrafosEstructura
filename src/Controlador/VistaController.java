package Controlador;

import Excepciones.GrafoNoCreadoException;
import Excepciones.VerticeExisteException;
import Excepciones.VerticeNoExisteException;
import GrafoMatriz.GrafoMatriz;
import GraphDesigns.GraphDesign;
import Modelo.Grafo;
import Modelo.Random;
import Modelo.Vertice;
import Vista.PanelDibujo;
import Vista.Vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolás
 */
public class VistaController {
    private final Vista vista;
    private PanelDibujo graficoGrafo;
    private GraphDesign design;
    private Grafo<String> grafo = null;

    public VistaController(Vista vista) {
        this.vista = vista;
        this.vista.getBtnAgregarVertice().addActionListener(this::agregarVertice);
        this.vista.getBtnAgregarArista().addActionListener(this::agregarArista);
        this.vista.getBtnCrearGrafo().addActionListener(this::crearGrafo);
    }

    private void iniciarPanel(Grafo grafo, GraphDesign design) {
        if(this.graficoGrafo == null) {
            this.graficoGrafo = new PanelDibujo(grafo, design);         
            vista.getPanelGraficoGrafo().add(graficoGrafo, BorderLayout.CENTER);

            GraphMouseManager graphMouseManager = new GraphMouseManager(graficoGrafo);
            graficoGrafo.addMouseListener(graphMouseManager);
            graficoGrafo.addMouseMotionListener(graphMouseManager);            
        }
        else {
            this.graficoGrafo.setGrafo(grafo);
            this.design.setGrafo(grafo);
            this.graficoGrafo.repaint();
        }
        vista.validate();
    }
    
    private void agregarVertice(ActionEvent e) {
        try {
            if(this.grafo == null) {
                throw new GrafoNoCreadoException();
            }
            String nombre = JOptionPane.showInputDialog(null, "Nombre del vértice:");
            Vertice v = new Vertice(
                    nombre, 
                    Random.randomNumber(30, graficoGrafo.getWidth() - 50),
                    Random.randomNumber(30, graficoGrafo.getHeight() - 50)                    
            );
            grafo.nuevoVertice(v);
            graficoGrafo.repaint();
        } catch (VerticeExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (GrafoNoCreadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private void agregarArista(ActionEvent e) {
        String origen = JOptionPane.showInputDialog(null, "Vértice origen:");
        String destino = JOptionPane.showInputDialog(null, "Vértice destino:");
        try {
            grafo.union(origen, destino);
            graficoGrafo.repaint();
        } catch (VerticeNoExisteException ex) {
            Logger.getLogger(VistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void crearGrafo(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Se creo el grafo");
        this.grafo = new GrafoMatriz();
        this.design.setGrafo(grafo);
        iniciarPanel(grafo, design);
    }

    public void setDesign(GraphDesign design) {
        this.design = design;
    }

}
