/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colores;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Equipo1
 */
public class DarkDesignColors1 extends ConfiguracionColores {

    public DarkDesignColors1() {
        COLOR_BACKGROUND = new Color(58, 76, 94);
        COLORES_VERTICES = coloresVertices();  
        COLOR_ARISTA = new Color(112, 127, 143);        
    }    

    @Override
    protected ArrayList<ColoresVertices> coloresVertices() {
        ArrayList<ColoresVertices> colores = new ArrayList<>();

        colores.add(new ColoresVertices(
                new Color(255, 115, 115),
                new Color(136, 91, 102)
        ));

        colores.add(new ColoresVertices(
                new Color(73, 214, 242),
                new Color(63, 131, 153)
        ));

        colores.add(new ColoresVertices(
                new Color(222, 121, 242),
                new Color(123, 93, 153)
        ));

        colores.add(new ColoresVertices(
                new Color(85, 164, 242),
                new Color(68, 111, 153)
        ));
        
        colores.add(new ColoresVertices(
                new Color(165, 229, 88),
                new Color(105, 169, 27)
        ));            

        return colores;
    }
    
}
