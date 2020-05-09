package Main;

import Controlador.VistaController;
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
        });
    }

}
