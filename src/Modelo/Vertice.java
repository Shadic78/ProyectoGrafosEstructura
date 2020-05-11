/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Equipo1
 */
public class Vertice <T> {
    public int numVertice;
    public T elemento;
    public Punto coords;

    public Vertice(T elemento) {
        this.elemento = elemento;
        this.numVertice = -1;
        this.coords = new Punto(50, 50);        
    } 
    
    public Vertice(T elemento, int x, int y) {
        this.elemento = elemento;
        this.numVertice = -1;
        this.coords = new Punto(x, y);
    }        

    public int getNumVertice() {
        return numVertice;
    }

    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Punto getCoords() {
        return coords;
    }

    public void setCoords(Punto coords) {
        this.coords = coords;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertice<?> other = (Vertice<?>) obj;
        if (!Objects.equals(this.elemento, other.elemento)) {
            return false;
        }
        return true;
    }    
    
}
