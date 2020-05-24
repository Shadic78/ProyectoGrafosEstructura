/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recorridos;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Equipo1
 */
public class RecorridoDesign1 extends JPanel {
    private ArrayList<String> lista;
    /******* Tamanios *******/
    // Ancho
    private int sizePanel;
    private int maxRectangles = 3;
    private int marginLRRectangles = 30;
    private int marginTBRectangles = 25;
    private int altoRectangulos = 40;
    private int sizeRectangles;
    private int xInicial, yInicial;
    /******* Fin tamanios *******/    
    /******* Colores ************/
    private Color colorBackgroundVentana = new Color(242, 242, 242);
    private ArrayList<Color> coloresRectangulos = asignarColoresRectangulos();
    private Color colorConexiones = new Color(64, 64, 64);
    /******* Fin olores **********/    

    public RecorridoDesign1(ArrayList<String> lista, int sizePanel) {
        this.lista = lista;
        this.sizePanel = sizePanel;
        this.sizeRectangles = calcularTamRectangles(sizePanel, maxRectangles, marginLRRectangles);
        this.xInicial = marginLRRectangles + altoRectangulos / 2;
        this.yInicial = 25;
        this.setBackground(colorBackgroundVentana);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        configuraciones(g2d);
        
        dibujar(g2d);

        g.dispose();
    }
    
    private int calcularTamRectangles(int sizePanel, int maxRectangles, int margenes) {
        int totalMargenes = margenes * (maxRectangles + 1) + altoRectangulos + altoRectangulos;
        int espacioSobrante  = sizePanel - totalMargenes;
        int tamRectangulos = espacioSobrante / maxRectangles;
        return tamRectangulos;
    }
    
    public void dibujar(Graphics2D g2d) {
        this.xInicial = marginLRRectangles + altoRectangulos / 2;
        this.yInicial = 25;
        dibujarConectoresSeguidos(g2d);
        dibujarRectangulosSeguidos(g2d);
    }
    
    private void dibujarRectangulos(Graphics2D g2d) {
        int coordYInicio = yInicial;
        for (int i = 0; i < lista.size(); i++) {
            // Continuar a la siguiente fila
            if (i != 0 && ((i % maxRectangles) + 1) == 1) {
                coordYInicio += altoRectangulos + marginTBRectangles;
            }

            // Rectangulo
            int pos = i % maxRectangles;
            int coordX = xInicial + ((sizeRectangles + marginLRRectangles) * pos);
            int radioCirculo = altoRectangulos / 2;
            g2d.setColor(coloresRectangulos.get(i % coloresRectangulos.size()));

            if (i == 0) { // El inicio
                g2d.fillOval(coordX, coordYInicio, altoRectangulos, altoRectangulos);
                g2d.fillRect(coordX + radioCirculo, coordYInicio, sizeRectangles - radioCirculo, altoRectangulos);
            } else if (i == (lista.size() - 1)) { // El final
                g2d.fillOval(coordX + sizeRectangles - radioCirculo * 2, coordYInicio, altoRectangulos, altoRectangulos);
                g2d.fillRect(coordX, coordYInicio, sizeRectangles - radioCirculo, altoRectangulos);
            } else { // El intermedio
                g2d.fillRect(coordX, coordYInicio, sizeRectangles, altoRectangulos);
            }

            // Texto
            g2d.setColor(Color.white);
            drawCenteredString(
                    g2d,
                    lista.get(i),
                    new Rectangle(
                            coordX,
                            coordYInicio,
                            sizeRectangles,
                            altoRectangulos
                    ),
                    new Font("Dialog", Font.PLAIN, 14)
            );
        }
    }
    
    private void dibujarRectangulosSeguidos(Graphics2D g2d) {
        int coordYInicio = yInicial;
        boolean invertir = false;
        for (int i = 0; i < lista.size(); i++) {
            // Continuar a la siguiente fila
            if (i != 0 && ((i % maxRectangles) + 1) == 1) {
                coordYInicio += altoRectangulos + marginTBRectangles;
                if(invertir) {
                   invertir = false; 
                }
                else {
                    invertir = true;
                }
            }

            // Rectangulo
            int pos = i % maxRectangles;
            if(invertir) {
                pos = maxRectangles - pos - 1;
            }
            int coordX = xInicial + ((sizeRectangles + marginLRRectangles) * pos);
            int radioCirculo = altoRectangulos / 2;
            g2d.setColor(coloresRectangulos.get(i % coloresRectangulos.size()));

            if (i == 0) { // El inicio
                g2d.fillOval(coordX, coordYInicio, altoRectangulos, altoRectangulos);
                g2d.fillRect(coordX + radioCirculo, coordYInicio, sizeRectangles - radioCirculo, altoRectangulos);
            } else if (i == (lista.size() - 1)) { // El final
                if (invertir) {
                    g2d.fillOval(coordX, coordYInicio, altoRectangulos, altoRectangulos);
                    g2d.fillRect(coordX + radioCirculo, coordYInicio, sizeRectangles - radioCirculo, altoRectangulos);
                }
                else {
                    g2d.fillOval(coordX + sizeRectangles - radioCirculo * 2, coordYInicio, altoRectangulos, altoRectangulos);
                    g2d.fillRect(coordX, coordYInicio, sizeRectangles - radioCirculo, altoRectangulos);
                }
            } else { // El intermedio
                g2d.fillRect(coordX, coordYInicio, sizeRectangles, altoRectangulos);
            }

            // Texto
            g2d.setColor(Color.white);
            drawCenteredString(
                    g2d,
                    lista.get(i),
                    new Rectangle(
                            coordX,
                            coordYInicio,
                            sizeRectangles,
                            altoRectangulos
                    ),
                    new Font("Dialog", Font.PLAIN, 14)
            );
        }
    }    
    
    private void dibujarConectores(Graphics2D g2d) {
        int coordYInicio = yInicial;

        for (int i = 0; i < lista.size(); i++) {
            // Continuar a la siguiente fila
            if (i != 0 && ((i % maxRectangles) + 1) == 1) {
                coordYInicio += altoRectangulos + marginTBRectangles;
            }            
            
            int pos = i % maxRectangles;
            int coordX = xInicial + ((sizeRectangles + marginLRRectangles) * pos);
            
            //No dibujar conector si es el ultimo de la fila o el ultimo elemento del array
            if (i != lista.size() - 1 && pos != maxRectangles - 1) {
                g2d.setColor(colorConexiones);
                g2d.fillRect(coordX + sizeRectangles, coordYInicio + 3, marginLRRectangles, altoRectangulos - 6);
            }
        }
    }
    
    private void dibujarConectoresSeguidos(Graphics2D g2d) {
        int coordYInicio = yInicial;
        boolean invertir = false;
        
        for (int i = 0; i < lista.size(); i++) {
            // Continuar a la siguiente fila
            if (i != 0 && ((i % maxRectangles) + 1) == 1) {
                coordYInicio += altoRectangulos + marginTBRectangles;
                if (invertir) {
                    invertir = false;
                } 
                else {
                    invertir = true;
                }            
            }            
            
            int pos = i % maxRectangles;
            if(invertir) {
                pos = maxRectangles - pos - 1;
            }            
            int coordX = xInicial + ((sizeRectangles + marginLRRectangles) * pos);
            
            g2d.setColor(colorConexiones);            
            // Si es el ultimo de la fila (derecha) y aun hay mas objetos en la lista
            if(!invertir && pos == maxRectangles - 1 && i < lista.size() - 1) {
                Polygon triangulo = new Polygon();
                triangulo.addPoint(coordX + sizeRectangles, coordYInicio);
                triangulo.addPoint(coordX + sizeRectangles, coordYInicio + altoRectangulos);
                triangulo.addPoint(coordX + sizeRectangles + altoRectangulos, coordYInicio + altoRectangulos);
                g2d.fillPolygon(triangulo);
                
                g2d.fillRect(coordX + sizeRectangles, coordYInicio + altoRectangulos, altoRectangulos, marginTBRectangles);
                
                Polygon triangulo2 = new Polygon();
                triangulo2.addPoint(coordX + sizeRectangles, coordYInicio + altoRectangulos + marginTBRectangles);
                triangulo2.addPoint(coordX + sizeRectangles, coordYInicio + altoRectangulos + marginTBRectangles + altoRectangulos);
                triangulo2.addPoint(coordX + sizeRectangles + altoRectangulos, coordYInicio + altoRectangulos + marginTBRectangles);
                g2d.fillPolygon(triangulo2);                
            } // Si se esta inviertiendo, se es el ultimo de la fila (izquierda) y has mas objetos en la lista
            else if(invertir && pos == 0 && i < lista.size() - 1) {
                Polygon triangulo = new Polygon();
                triangulo.addPoint(coordX, coordYInicio);
                triangulo.addPoint(coordX, coordYInicio + altoRectangulos);
                triangulo.addPoint(coordX - altoRectangulos, coordYInicio + altoRectangulos);
                g2d.fillPolygon(triangulo);

                g2d.fillRect(coordX - altoRectangulos, coordYInicio + altoRectangulos, altoRectangulos, marginTBRectangles);

                Polygon triangulo2 = new Polygon();
                triangulo2.addPoint(coordX, coordYInicio + altoRectangulos + marginTBRectangles);
                triangulo2.addPoint(coordX, coordYInicio + altoRectangulos + marginTBRectangles + altoRectangulos);
                triangulo2.addPoint(coordX - altoRectangulos, coordYInicio + altoRectangulos + marginTBRectangles);
                g2d.fillPolygon(triangulo2);
            }
            //No dibujar conector si es el ultimo de la fila o el ultimo elemento del array
            else if (i != lista.size() - 1) {
                if(invertir && pos != 0) {
                    g2d.fillRect(coordX - marginLRRectangles, coordYInicio + 3, marginLRRectangles, altoRectangulos - 6);                    
                }
                else if(!invertir && pos != maxRectangles - 1) {
                    g2d.fillRect(coordX + sizeRectangles, coordYInicio + 3, marginLRRectangles, altoRectangulos - 6);                    
                }
            }
        }
    }    
    
    private ArrayList<Color> asignarColoresRectangulos() {
        ArrayList<Color>  colores = new ArrayList<>();
        
        colores.add(new Color(224, 57, 49));
        colores.add(new Color(253, 133, 21));
        colores.add(new Color(123, 182, 2));
        colores.add(new Color(13, 165, 178));
        
        return colores;
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

    public void setLista(ArrayList<String> lista) {
        this.lista = lista;
    }

    public void setSizePanel(int sizePanel) {
        this.sizePanel = sizePanel;
    }
       
    
    private void configuraciones(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
    }

}
