/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphDesigns;

import Modelo.ArcoDoble;
import Modelo.Grafo;
import Modelo.Vertice;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Equipo1
 */
public abstract class GraphDesign {
    private int DIAMETRO_VERTICES;
    private int GROSOR_BORDE;
    private int GROSOR_ARISTA;
    private ArrayList<ArcoDoble> arcos;
    private ArrayList<Vertice> vertices;
    private Grafo grafo;

    public GraphDesign(Grafo grafo) {
        this.grafo = grafo;
    }    
    
    public abstract void draw(Graphics2D g2d);

    public int getDIAMETRO_VERTICES() {
        return DIAMETRO_VERTICES;
    }

    public void setDIAMETRO_VERTICES(int DIAMETRO_VERTICES) {
        this.DIAMETRO_VERTICES = DIAMETRO_VERTICES;
    }

    public int getGROSOR_BORDE() {
        return GROSOR_BORDE;
    }

    public void setGROSOR_BORDE(int GROSOR_BORDE) {
        this.GROSOR_BORDE = GROSOR_BORDE;
    }

    public int getGROSOR_ARISTA() {
        return GROSOR_ARISTA;
    }

    public void setGROSOR_ARISTA(int GROSOR_ARISTA) {
        this.GROSOR_ARISTA = GROSOR_ARISTA;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public ArrayList<ArcoDoble> getArcos() {
        return arcos;
    }

    public void setArcos(ArrayList<ArcoDoble> arcos) {
        this.arcos = arcos;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }
      
}
