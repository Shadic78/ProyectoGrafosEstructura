package Controlador;

import Vista.PanelDibujo;
import Vista.Vista;
import java.awt.BorderLayout;

/**
 *
 * @author Nicolás
 */
public class VistaController {
    private final Vista vista;
    private PanelDibujo graficoGrafo;

    public VistaController(Vista vista) {
        this.vista = vista;
        initComponents();
    }

    private void initComponents() {
        iniciarPanel();
    }

    private void iniciarPanel() {
        this.graficoGrafo = new PanelDibujo();
        vista.getPanelGraficoGrafo().add(graficoGrafo, BorderLayout.CENTER);

        GraphMouseManager graphMouseManager = new GraphMouseManager(graficoGrafo);
        graficoGrafo.addMouseListener(graphMouseManager);
        graficoGrafo.addMouseMotionListener(graphMouseManager);
    }

}
