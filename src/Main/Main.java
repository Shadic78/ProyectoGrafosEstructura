package Main;

import Colores.DarkDesignColors1;
import Controlador.ControladorVista;
import GraphDesigns.DarkDesign1;
import Vista.Vista;
import java.awt.EventQueue;

/**
 *
 * @author Equipo1
 */
public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Vista vista = new Vista();
            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
            ControladorVista vistaController = new ControladorVista(vista);
            vistaController.setDesign(new DarkDesign1(new DarkDesignColors1()));
        });
    }

}
