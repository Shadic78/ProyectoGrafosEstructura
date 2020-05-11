/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphDesigns;

import Colores.ConfiguracionColores;
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
    protected int DIAMETRO_VERTICES;
    protected int GROSOR_BORDE;
    protected int GROSOR_ARISTA;
    protected ConfiguracionColores colores;
    protected ArrayList<ArcoDoble> arcos;
    protected ArrayList<Vertice> vertices;
    protected Grafo grafo;

    public GraphDesign(Grafo grafo, ConfiguracionColores colores) {
        this.grafo = grafo;
        this.colores = colores;
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

    public ConfiguracionColores getColores() {
        return colores;
    }

    public void setColores(ConfiguracionColores colores) {
        this.colores = colores;
    }
      
}
