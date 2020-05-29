/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import GrafoAdcia.GrafoAdcia;
import GrafoMatriz.GrafoMatriz;
import Modelo.Grafo;

/**
 *
 * @author Equipo1
 */
public class FactoryGrafos {
    
    public static Grafo crearGrafo(String tipo) {
        Grafo<String> grafo = null;
        if(tipo.equals("Matriz de adyacencia")) {
            grafo = new GrafoMatriz<String>();
        }
        else if(tipo.equals("Lista de adyacencia")) {
            grafo = new GrafoAdcia<String>();
        }
        return grafo;
    }
    
}
