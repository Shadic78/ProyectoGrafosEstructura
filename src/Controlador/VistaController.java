package Controlador;

import Excepciones.VerticeExisteException;
import Excepciones.VerticeNoExisteException;
import GrafoMatriz.GrafoMatriz;
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
    private Grafo<String> grafo;

    public VistaController(Vista vista) {
        this.vista = vista;
        this.vista.getBtnAgregarVertice().addActionListener(this::agregarVertice);
        this.vista.getBtnAgregarArista().addActionListener(this::agregarArista);
        initComponents();
    }

    private void initComponents() {
        iniciarPanel();
    }

    private void iniciarPanel() {
        this.grafo = new GrafoMatriz<String>();
        this.graficoGrafo = new PanelDibujo(grafo);
        vista.getPanelGraficoGrafo().add(graficoGrafo, BorderLayout.CENTER);

        GraphMouseManager graphMouseManager = new GraphMouseManager(graficoGrafo);
        graficoGrafo.addMouseListener(graphMouseManager);
        graficoGrafo.addMouseMotionListener(graphMouseManager);
    }
    
    private void agregarVertice(ActionEvent e) {
        try {
            String nombre = JOptionPane.showInputDialog(null, "Nombre del vértice:");
            Vertice v = new Vertice(
                    nombre, 
                    Random.randomNumber(30, graficoGrafo.getWidth() - 50),
                    Random.randomNumber(30, graficoGrafo.getHeight() - 50)                    
            );
            grafo.nuevoVertice(v);
            graficoGrafo.repaint();
        } catch (VerticeExisteException ex) {
            Logger.getLogger(VistaController.class.getName()).log(Level.SEVERE, null, ex);
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

}
