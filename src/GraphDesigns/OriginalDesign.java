/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphDesigns;

import Modelo.Grafo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Equipo1
 */
public class OriginalDesign extends GraphDesign {

    public OriginalDesign(Grafo grafo) {
        super(grafo);
        configurar();
    }
    
    private void configurar() {
        super.setDIAMETRO_VERTICES(40);
        super.setGROSOR_ARISTA(2);
        super.setGROSOR_BORDE(4);
    }

    @Override
    public void draw(Graphics2D g2d) {
        setArcos(getGrafo().getArcos());
        setVertices(getGrafo().getVertices());
        
        // Arcos
        for (int i = 0; i < getGrafo().getNumeroVertices(); i++) {
            g2d.setColor(new Color(255, 141, 141));
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(coordX.get(i - 1) + 22, coordY.get(i - 1) + 22, coordX.get(i) + 22, coordY.get(i) + 22);
        }

        for (int i = 0; i < coordX.size(); i++) {
            g2d.setColor(new Color(70, 206, 205));
            g2d.fillOval(coordX.get(i) - 4, coordY.get(i) - 4, 52, 52);
            g2d.setColor(new Color(81, 237, 236));
            g2d.fillOval(coordX.get(i), coordY.get(i), 44, 44);
        }        
    }
    
}
