/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Excepciones.ArcoNoExisteException;
import Excepciones.VerticeExisteException;
import Excepciones.VerticeNoExisteException;
import java.util.ArrayList;

/**
 *
 * @author Equipo1
 */
public interface Grafo <T> {
    
    public ArrayList<ArcoDoble> getArcos();
    
    public ArrayList<Vertice> getVertices();
    
    public void borrarArco(T elemento1, T elemento2) throws VerticeNoExisteException, ArcoNoExisteException;

    public boolean adyacente(T elemento1, T elemento2) throws VerticeNoExisteException;

    public void nuevoVertice(T elemento) throws VerticeExisteException;
    
    public void nuevoVertice(Vertice<T> vertice) throws VerticeExisteException;    

    public void borrarVertice(T elemento) throws VerticeNoExisteException;

    public void union(T elemento1, T elemento2) throws VerticeNoExisteException;

    public boolean buscarProfundidad(T elemento) throws VerticeNoExisteException;

    public boolean buscarAmplitud(T elemento) throws VerticeNoExisteException;

    public ArrayList<T> recorrerAmplitud() throws VerticeNoExisteException;

    public ArrayList<T> recorrerProfundidad() throws VerticeNoExisteException;

    public int getNumeroVertices();

    public boolean adyacente(int num1, int num2) throws VerticeNoExisteException;

    public T getElemento(int vertice) throws VerticeNoExisteException;    
}
