/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrafoAdcia;

/**
 *
 * @author Equipo1
 */
public class Arco {
    private int destino;
    private double peso;

    public Arco(int d) {
        destino = d;
    }

    public Arco(int d, double p) {
        this(d);
        peso = p;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public boolean equals(Object n) {
        Arco a = (Arco) n;
        return destino == a.destino;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Arco{" + "destino=" + destino + ", peso=" + peso + '}';
    }

}
