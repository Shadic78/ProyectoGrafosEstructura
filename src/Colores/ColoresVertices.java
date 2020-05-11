/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colores;

import java.awt.Color;

/**
 *
 * @author Equipo1
 */
public class ColoresVertices {
    private Color colorRelleno;
    private Color colorBorde;

    public ColoresVertices(Color colorRelleno, Color colorBorde) {
        this.colorRelleno = colorRelleno;
        this.colorBorde = colorBorde;
    }

    public Color getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(Color colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public Color getColorBorde() {
        return colorBorde;
    }

    public void setColorBorde(Color colorBorde) {
        this.colorBorde = colorBorde;
    }
    
}
