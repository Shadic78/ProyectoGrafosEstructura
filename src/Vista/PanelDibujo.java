package Vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Equipo1
 */
public class PanelDibujo extends JPanel {

    public ArrayList<Integer> coordX = new ArrayList<>();
    public ArrayList<Integer> coordY = new ArrayList<>();

    public PanelDibujo() {
        this.setBackground(new Color(232, 233, 234));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        configuraciones(g2d);

        /*if(coordX.size() > 1) {
            g2d.setColor(new Color(255, 141, 141));
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(coordX.get(0) + 22, coordY.get(0) + 22, coordX.get(1) + 22, coordY.get(1) + 22);
        }*/
        for (int i = 0; i < coordX.size(); i++) {
            if (i > 0) {
                g2d.setColor(new Color(255, 141, 141));
                g2d.setStroke(new BasicStroke(2));
                g2d.drawLine(coordX.get(i - 1) + 22, coordY.get(i - 1) + 22, coordX.get(i) + 22, coordY.get(i) + 22);
            }
        }

        for (int i = 0; i < coordX.size(); i++) {
            g2d.setColor(new Color(70, 206, 205));
            g2d.fillOval(coordX.get(i) - 4, coordY.get(i) - 4, 52, 52);
            g2d.setColor(new Color(81, 237, 236));
            g2d.fillOval(coordX.get(i), coordY.get(i), 44, 44);
        }

        g.dispose();
    }

    private void configuraciones(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
    }

}
