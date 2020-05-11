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
public class ColoresGrafo {
    public static final Color COLOR_BACKGROUND = new Color(58, 76, 94);
    public static final ArrayList<ColoresVertices> COLORES_VERTICES = coloresVertices();
    
    private static ArrayList<ColoresVertices> coloresVertices() {
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
        
        return colores;
    }
}
