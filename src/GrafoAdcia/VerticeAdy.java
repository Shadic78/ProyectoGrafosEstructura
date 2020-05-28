/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrafoAdcia;

import Modelo.Punto;
import java.util.ArrayList;

/**
 *
 * @author Equipo1
 */
public class VerticeAdy<T> {
    private T nombre;
    private int numVertice;
    public ArrayList<Arco> lad;
    public Punto coords;    

    public VerticeAdy(T x) {
        nombre = x;
        numVertice = -1;
        lad = new ArrayList<Arco>();
        this.coords = new Punto(50, 50);                
    }

    public boolean equals(Object d) {
        VerticeAdy dos = (VerticeAdy) d;
        return nombre.equals(dos.nombre);
    }

    public void asigVert(int n) {
        numVertice = n;
    }

    public T nomVertice() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + numVertice + ")";
    }

    public T getNombre() {
        return nombre;
    }

    public int getNumVertice() {
        return numVertice;
    }

    public ArrayList<Arco> getLad() {
        return lad;
    }

    public Punto getCoords() {
        return coords;
    }

    public void setCoords(Punto coords) {
        this.coords = coords;
    }
    
}


