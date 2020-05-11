/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphDesigns;

import Colores.ColoresVertices;
import Colores.ConfiguracionColores;
import Modelo.Grafo;
import Modelo.Vertice;
import java.awt.BasicStroke;
import java.awt.Graphics2D;

/**
 *
 * @author Equipo1
 */
public class OriginalDesign extends GraphDesign {

    public OriginalDesign(Grafo grafo, ConfiguracionColores colores) {
        super(grafo, colores);
        configurar();
    }
    
    private void configurar() {
        super.setDIAMETRO_VERTICES(40);
        super.setGROSOR_ARISTA(2);
        super.setGROSOR_BORDE(4);
    }

    @Override
    public void draw(Graphics2D g2d) {
        arcos = grafo.getArcos();
        vertices = grafo.getVertices();
        int radio = DIAMETRO_VERTICES / 2;
        
        dibujarArcos(g2d, radio);
        dibujarVertices(g2d);
     
    }
    
    private void dibujarArcos(Graphics2D g2d, int radio) {
        for (int i = 0; i < arcos.size(); i++) {
            Vertice origen = arcos.get(i).getOrigen();
            Vertice destino = arcos.get(i).getDestino();            
            
            g2d.setColor(colores.COLOR_ARISTA);
            g2d.setStroke(new BasicStroke(GROSOR_ARISTA));
            g2d.drawLine(
                    origen.getCoords().getX() + radio,
                    origen.getCoords().getY() + radio,
                    destino.getCoords().getX() + radio,
                    destino.getCoords().getY() + radio
            );
        }        
    }
    
    private void dibujarVertices(Graphics2D g2d) {
        for (int i = 0; i < vertices.size(); i++) {
            ColoresVertices color = colores.COLORES_VERTICES.get(i % colores.COLORES_VERTICES.size());
            Vertice vertice = vertices.get(i);
            System.out.println("Pintar: " + vertice.getCoords());
            // Borde
            g2d.setColor(color.getColorBorde());
            g2d.fillOval(
                    vertice.getCoords().getX() - GROSOR_BORDE, 
                    vertice.getCoords().getY() - GROSOR_BORDE,
                    DIAMETRO_VERTICES +  (GROSOR_BORDE * 2),
                    DIAMETRO_VERTICES +  (GROSOR_BORDE * 2)                    
            );
            
            // Relleno
            g2d.setColor(color.getColorRelleno());
            g2d.fillOval(
                    vertice.getCoords().getX(),
                    vertice.getCoords().getY(), 
                    DIAMETRO_VERTICES,
                    DIAMETRO_VERTICES
            );
        }           
    }
    
}
