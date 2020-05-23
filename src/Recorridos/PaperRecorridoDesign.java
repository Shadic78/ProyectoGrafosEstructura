/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recorridos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Equipo1
 */
public class PaperRecorridoDesign extends JPanel {
    private ArrayList<String> lista;
    /******* Colores y tamanios *******/
    // Ancho
    private int sizePanel;
    private int maxRectangles = 5;
    private int marginLRRectangles = 30;
    private int marginTBRectangles = 25;
    private int altoRectangulos = 30;
    private int sizeRectangles;
    private int xInicial, yInicial;
    /******* Fin colores y tamanios *******/    
    
    public PaperRecorridoDesign(int sizePanel) {
        this.sizePanel = sizePanel;
        this.sizeRectangles = calcularTamRectangles(sizePanel, maxRectangles, marginLRRectangles);
        this.xInicial = marginLRRectangles;
        this.yInicial = 25;
    }    
    
    private int calcularTamRectangles(int sizePanel, int maxRectangles, int margenes) {
        int totalMargenes = margenes * maxRectangles + 1;
        int espacioSobrante  = sizePanel - totalMargenes;
        int tamRectangulos = espacioSobrante / maxRectangles;
        return tamRectangulos;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillRect(20, 20, 200, 100);
        Graphics2D g2d = (Graphics2D) g;        
        //draw2(g2d);
        g.dispose();
    }
    
    public void draw2(Graphics2D g2d) {
        this.xInicial = marginLRRectangles;
        this.yInicial = 25;        
        for(int i = 0; i < lista.size(); i++) {
            dibujarConectores(g2d, i);
            dibujarRectangulos(g2d, i, lista.get(i));
        }
    }
    
    private void dibujarRectangulos(Graphics2D g2d, int i, String texto) {
        if(i >= maxRectangles) {
            yInicial += altoRectangulos + marginTBRectangles;
        }
        int coordX = xInicial + ((sizeRectangles  + marginLRRectangles) * i);
        g2d.setColor(Color.red);
        g2d.drawRect(coordX, yInicial, sizeRectangles, altoRectangulos);
    }
    
    private void dibujarConectores(Graphics2D g2d, int i) {
        
    }

    public void setLista(ArrayList<String> lista) {
        this.lista = lista;
    }

    public void setSizePanel(int sizePanel) {
        this.sizePanel = sizePanel;
    }
    
}
