package Main;

import Colores.DarkDesignColors1;
import Controlador.VistaController;
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
            VistaController vistaController = new VistaController(vista);
            vistaController.setDesign(new DarkDesign1(new DarkDesignColors1()));
        });
    }

}
