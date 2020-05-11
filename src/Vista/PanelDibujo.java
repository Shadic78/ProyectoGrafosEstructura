package Vista;

import Colores.DarkDesignColors1;
import GraphDesigns.GraphDesign;
import GraphDesigns.OriginalDesign;
import Modelo.Grafo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Equipo1
 */
public class PanelDibujo extends JPanel {
    private Grafo grafo;
    private GraphDesign design;

    public PanelDibujo(Grafo grafo) {
        this.grafo = grafo;
        this.design = new OriginalDesign(grafo, new DarkDesignColors1());
        this.setBackground(design.getColores().COLOR_BACKGROUND);
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        configuraciones(g2d);
        
        design.draw(g2d);
        
        g.dispose();
    }

    private void configuraciones(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
    }

}
