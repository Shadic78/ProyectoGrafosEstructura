package Controlador;

import Excepciones.ArcoNoExisteException;
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
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo1
 */
public class ControladorVista {
    private final Vista vista;
    private PanelDibujo graficoGrafo;
    private GraphDesign design;
    private Grafo<String> grafo = null;

    public ControladorVista(Vista vista) {
        this.vista = vista;
        this.vista.getBtnAgregarVertice().addActionListener(this::agregarVertice);
        this.vista.getBtnAgregarArista().addActionListener(this::agregarArista);
        this.vista.getBtnCrearGrafo().addActionListener(this::crearGrafo);
        this.vista.getBtnBorrarArista().addActionListener(this::borrarArista);
        this.vista.getBtnBorrarVertice().addActionListener(this::borrarVertice);
        this.vista.getBtnAdyacencia().addActionListener(this::comprobarAdyacencia);
        this.vista.getBtnVerticeBusqueda().addActionListener(this::buscarVertice);
    }

    private void iniciarPanel(Grafo grafo, GraphDesign design) {
        if(this.graficoGrafo == null) {
            this.graficoGrafo = new PanelDibujo(grafo, design);         
            vista.getPanelGraficoGrafo().add(graficoGrafo, null);

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
    
    private void borrarVertice(ActionEvent e) {
        try {
            if(this.grafo == null) {
                throw new GrafoNoCreadoException();
            }
            String nombre = JOptionPane.showInputDialog(null, "Nombre del vértice a borrar:");
            grafo.borrarVertice(nombre);
            graficoGrafo.repaint();
        }
        catch (GrafoNoCreadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (VerticeNoExisteException ex) {
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
            Logger.getLogger(ControladorVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void borrarArista(ActionEvent e) {
        try {
            if(this.grafo == null) {
                throw new GrafoNoCreadoException();                
            }
            String origen = JOptionPane.showInputDialog(null, "Vértice origen:");
            String destino = JOptionPane.showInputDialog(null, "Vértice destino:");   
            grafo.borrarArco(origen, destino);
            graficoGrafo.repaint();
        } catch (GrafoNoCreadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (VerticeNoExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ArcoNoExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private void comprobarAdyacencia(ActionEvent e) {
        try {
            if(this.grafo == null) {
                throw new GrafoNoCreadoException();                
            }
            String origen = vista.getTxtAdyacenciaOrigen().getText();
            String destino = vista.getTxtAdyacenciaDestino().getText();
            System.out.println("Origen: " + origen);
            System.out.println("Destino: " + destino);
            if(grafo.adyacente(origen, destino)) {
                JOptionPane.showMessageDialog(null, "Los vertices son adyacentes");
            }
            else {
                JOptionPane.showMessageDialog(null, "Los vertices no son adyacentes");                
            }
        } catch (GrafoNoCreadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (VerticeNoExisteException ex) {
            JOptionPane.showMessageDialog(null, "Uno de los vertices no existe");
        }
    }
    
    private void crearGrafo(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Se creo el grafo");
        this.grafo = new GrafoMatriz();
        this.design.setGrafo(grafo);
        iniciarPanel(grafo, design);
    }
    
    private void buscarVertice(ActionEvent e) {
        String nombreVertice = vista.getTxtVerticeBusqueda().getText();
        String tipoBusqueda = vista.getComboTipoBusqueda().getActionCommand();
        try {
            if (tipoBusqueda.equals("Anchura")) {
                if(grafo.buscarAmplitud(nombreVertice)) {
                    JOptionPane.showMessageDialog(null, "Se encontro el vértice");
                }
                else {
                    JOptionPane.showMessageDialog(null, "No se encontro el vértice");
                }
            } else if (grafo.buscarProfundidad(nombreVertice)) {
                JOptionPane.showMessageDialog(null, "Se encontro el vértice");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el vértice");
            }
        } catch (VerticeNoExisteException ex) {
            JOptionPane.showMessageDialog(null, "Uno de los vertices no existe");
        }
    }

    public void setDesign(GraphDesign design) {
        this.design = design;
    }

}
