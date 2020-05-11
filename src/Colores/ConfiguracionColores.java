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
public abstract class ConfiguracionColores {
    public Color COLOR_BACKGROUND;
    public ArrayList<ColoresVertices> COLORES_VERTICES;
    public Color COLOR_ARISTA;  
    
    protected abstract ArrayList<ColoresVertices> coloresVertices();    
}
