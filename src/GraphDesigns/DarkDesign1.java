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
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Equipo1
 */
public class DarkDesign1 extends GraphDesign {

    public DarkDesign1(Grafo grafo, ConfiguracionColores colores) {
        super(grafo, colores);
        configurar();
    }
    
    private void configurar() {
        super.setDIAMETRO_VERTICES(40);
        super.setGROSOR_ARISTA(2);
        super.setGROSOR_BORDE(3);
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
        /*for (int i = 0; i < vertices.size(); i++) {
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
            );*/
        
        for (int i = 0; i < vertices.size(); i++) {
            ColoresVertices color = colores.COLORES_VERTICES.get(i % colores.COLORES_VERTICES.size());
            Vertice vertice = vertices.get(i);
            // Borde externo
            g2d.setColor(color.getColorBorde());
            g2d.fillOval(
                    vertice.getCoords().getX() - GROSOR_BORDE * 2, 
                    vertice.getCoords().getY() - GROSOR_BORDE * 2,
                    DIAMETRO_VERTICES +  (GROSOR_BORDE * 4),
                    DIAMETRO_VERTICES +  (GROSOR_BORDE * 4)                    
            );      

            // Borde interno
            g2d.setColor(colores.COLOR_BACKGROUND);
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
            
            // Nombre del vertice
            g2d.setColor(Color.WHITE);
            drawCenteredString(
                    g2d,
                    vertice.getElemento().toString(),
                    new Rectangle(
                            vertice.getCoords().getX() - GROSOR_BORDE * 2,
                            vertice.getCoords().getY() + DIAMETRO_VERTICES - GROSOR_BORDE * 3,
                            DIAMETRO_VERTICES +  (GROSOR_BORDE * 4), 
                            DIAMETRO_VERTICES +  (GROSOR_BORDE * 4)
                    ),
                    new Font("Dialog", Font.PLAIN, 14)
            );
        }           
    }

    /**
     * Draw a String centered in the middle of a Rectangle.
     *
     * @param g The Graphics instance.
     * @param text The String to draw.
     * @param rect The Rectangle to center the text in.
     */
    public void drawCenteredString(Graphics2D g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }
      
}
