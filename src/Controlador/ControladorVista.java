package Controlador;

import Excepciones.ArcoNoExisteException;
import Excepciones.GrafoNoCreadoException;
import Excepciones.VerticeExisteException;
import Excepciones.VerticeNoExisteException;
import GrafoAdcia.GrafoAdcia;
import GrafoMatriz.GrafoMatriz;
import GraphDesigns.GraphDesign;
import Modelo.Grafo;
import Modelo.Random;
import Modelo.Vertice;
import Recorridos.RecorridoDesign1;
import Vista.PanelDibujo;
import Vista.RecorridosVista;
import Vista.Vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
    private RecorridosVista recorridosVista = null;
    private RecorridoDesign1 recorridoDesign;

    public ControladorVista(Vista vista) {
        this.vista = vista;
        this.vista.getBtnAgregarVertice().addActionListener(this::agregarVertice);
        this.vista.getBtnAgregarArista().addActionListener(this::agregarArista);
        this.vista.getBtnCrearGrafo().addActionListener(this::crearGrafo);
        this.vista.getBtnBorrarArista().addActionListener(this::borrarArista);
        this.vista.getBtnBorrarVertice().addActionListener(this::borrarVertice);
        this.vista.getBtnAdyacencia().addActionListener(this::comprobarAdyacencia);
        this.vista.getBtnVerticeBusqueda().addActionListener(this::buscarVertice);
        this.vista.getBtnRecorridoAnchura().addActionListener(this::recorridoAnchura);
        this.vista.getBtnRecorridoProfundidad().addActionListener(this::recorridoProfundidad);
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
            
            if(nombre != null) {
                Vertice v = new Vertice(
                        nombre, 
                        Random.randomNumber(30, graficoGrafo.getWidth() - 50),
                        Random.randomNumber(30, graficoGrafo.getHeight() - 50)                    
                );
                grafo.nuevoVertice(v);
                graficoGrafo.repaint();                
            }
            else {
                JOptionPane.showMessageDialog(null, "Se cancelo la creación del vértice");
            }
            
        } catch (VerticeExisteException ex) {
            JOptionPane.showMessageDialog(null, "El vértice ya existe");
        } catch (GrafoNoCreadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Se alcanzo el límite de vértices");
        }
    }
    
    private void borrarVertice(ActionEvent e) {
        try {
            if(this.grafo == null) {
                throw new GrafoNoCreadoException();
            }
            String nombre = JOptionPane.showInputDialog(null, "Nombre del vértice a borrar:");
            
            if(nombre != null) {
                grafo.borrarVertice(nombre);
                graficoGrafo.repaint();                
            }
            else {
                JOptionPane.showMessageDialog(null, "Se cancelo el borrado del vértice");
            }
            
        }
        catch (GrafoNoCreadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (VerticeNoExisteException ex) {
            JOptionPane.showMessageDialog(null, "El vértice no existe");
        }        
    }
    
    private void agregarArista(ActionEvent e) {
        try {
            if (this.grafo == null) {
                throw new GrafoNoCreadoException();
            }

            String origen = JOptionPane.showInputDialog(null, "Vértice origen:");
            String destino = JOptionPane.showInputDialog(null, "Vértice destino:");
            
            if(origen == null || destino == null) {
                throw new VerticeNoExisteException("Alguno de los vértices no existe");
            }

            grafo.union(origen, destino);
            graficoGrafo.repaint();
        } catch (VerticeNoExisteException ex) {
            JOptionPane.showMessageDialog(null, "Alguno de los vértices no existe");
        } catch (GrafoNoCreadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private void borrarArista(ActionEvent e) {
        try {
            if(this.grafo == null) {
                throw new GrafoNoCreadoException();                
            }
            String origen = JOptionPane.showInputDialog(null, "Vértice origen:");
            String destino = JOptionPane.showInputDialog(null, "Vértice destino:");   
            
            if(origen == null || destino == null) {
                throw new VerticeNoExisteException("Alguno de los vértices no existe");
            }            
            
            grafo.borrarArco(origen, destino);
            graficoGrafo.repaint();
        } catch (GrafoNoCreadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (VerticeNoExisteException ex) {
            JOptionPane.showMessageDialog(null, "Alguno de los vértices no existe");
        } catch (ArcoNoExisteException ex) {
            JOptionPane.showMessageDialog(null, "La arista no existe");
        }
    }
    
    private void comprobarAdyacencia(ActionEvent e) {
        try {
            if(this.grafo == null) {
                throw new GrafoNoCreadoException();                
            }
            String origen = vista.getTxtAdyacenciaOrigen().getText();
            String destino = vista.getTxtAdyacenciaDestino().getText();
            
            if(origen == null || destino == null) {
                throw new VerticeNoExisteException("Alguno de los vértices no existe");
            }            
            
            if(grafo.adyacente(origen, destino)) {
                JOptionPane.showMessageDialog(null, "Los vertices son adyacentes");
            }
            else {
                JOptionPane.showMessageDialog(null, "Los vertices no son adyacentes");                
            }
            
        } catch (GrafoNoCreadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (VerticeNoExisteException ex) {
            JOptionPane.showMessageDialog(null, "Alguno de los vértices no existe");
        }
    }
    
    private void crearGrafo(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Se creo el grafo");
        this.grafo = new GrafoAdcia<String>();
        this.design.setGrafo(grafo);
        iniciarPanel(grafo, design);
    }
    
    private void buscarVertice(ActionEvent e) {
        try {
            if(this.grafo == null) {
                throw new GrafoNoCreadoException();
            }
            
            String nombreVertice = vista.getTxtVerticeBusqueda().getText();
            String tipoBusqueda = vista.getComboTipoBusqueda().getActionCommand();

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
            JOptionPane.showMessageDialog(null, "El vértice no existe");
        } catch (GrafoNoCreadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private void recorridoAnchura(ActionEvent e) {
        try {
            if(this.grafo == null) {
                throw new GrafoNoCreadoException();
            }            
            
            ArrayList<String> recorrido = grafo.recorrerAmplitud();
            System.out.println("Anchura: " + recorrido);
            iniciarPanelRecorrido(recorrido, "Recorrido en anchura");
            
        } catch (VerticeNoExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (GrafoNoCreadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private void recorridoProfundidad(ActionEvent e) {
        try {
            if(this.grafo == null) {
                throw new GrafoNoCreadoException();
            }             
            
            ArrayList<String> recorrido = grafo.recorrerProfundidad();
            System.out.println("Profundidad: " + recorrido);
            iniciarPanelRecorrido(recorrido, "Recorrido en profundidad");            
        } catch (VerticeNoExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (GrafoNoCreadoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private void iniciarPanelRecorrido(ArrayList<String> lista, String titulo) {
        RecorridosVista v = new RecorridosVista();
        v.setTitle(titulo);
        v.setLocationRelativeTo(null);
        
        this.recorridoDesign = new RecorridoDesign1(lista, v.getPanelDibujo().getWidth());
        
        v.getPanelDibujo().add(recorridoDesign, BorderLayout.CENTER);
        v.setVisible(true);
    }

    public void setDesign(GraphDesign design) {
        this.design = design;
    }

}
