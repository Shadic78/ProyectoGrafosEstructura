/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrafoMatriz;

import Excepciones.ArcoNoExisteException;
import Excepciones.VerticeExisteException;
import Excepciones.VerticeNoExisteException;
import Modelo.ArcoDoble;
import Modelo.Grafo;
import Modelo.Vertice;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 *
 * @author emman
 */
public class GrafoMatriz<T> implements Grafo<T> {

    private int numeroVertices;
    private static final int MAXVERTICES = 21;
    private Vertice<T>[] vertices;
    private int[][] matrizAdyacencia;

    public GrafoMatriz(int maximoVertices) {
        matrizAdyacencia = new int[maximoVertices][maximoVertices];
        vertices = new Vertice[maximoVertices];
        for (int i = 0; i < maximoVertices; i++) {
            for (int j = 0; j < maximoVertices; j++) {
                matrizAdyacencia[i][j] = 0;
            }
        }
        numeroVertices = 0;
    }

    public GrafoMatriz() {
        this(MAXVERTICES);
    }

    @Override
    public boolean adyacente(int num1, int num2) throws VerticeNoExisteException {
        if (num1 < 0 || num2 < 0) {
            throw new VerticeNoExisteException("Vertice no existe");
        }
        return matrizAdyacencia[num1][num2] == 1;
    }

    private int getNumeroVertice(T elemento) {
        Vertice<T> v = new Vertice(elemento);

        for (int i = 0; i < numeroVertices; i++) {
            if (vertices[i].equals(v)) {

                return i;
            }

        }
        return -1;
    }

    @Override
    public String toString() {
        int dim = matrizAdyacencia.length;
        String matriz = "  ";
        for (int i = 0; i < dim; i++) {
            if (vertices[i] == null) {
                matriz += "#" + " ";
            } else {
                matriz += vertices[i].getElemento() + " ";
            }

        }
        matriz += "\n";
        for (int i = 0; i < dim; i++) {
            if (vertices[i] == null) {
                matriz += "#" + " ";
            } else {

                matriz += vertices[i].getElemento() + " ";
            }
            for (int j = 0; j < dim; j++) {
                matriz += matrizAdyacencia[i][j] + " ";
            }
            matriz += "\n";
        }
        return matriz;
    }

    @Override
    public void borrarArco(T elemento1, T elemento2) throws VerticeNoExisteException, ArcoNoExisteException {
        int va, vb;
        va = getNumeroVertice(elemento1);
        vb = getNumeroVertice(elemento2);
        if (va < 0 || vb < 0) {
            throw new VerticeNoExisteException("Vertice no existe");
        }

        matrizAdyacencia[va][vb] = 0;
        matrizAdyacencia[vb][va] = 0;
    }

    @Override
    public boolean adyacente(T elemento1, T elemento2) throws VerticeNoExisteException {
        int va, vb;
        va = getNumeroVertice(elemento1);
        vb = getNumeroVertice(elemento2);
        if (va < 0 || vb < 0) {
            throw new VerticeNoExisteException("Vertice no existe");
        }
        return matrizAdyacencia[va][vb] == 1;
    }

    @Override
    public void nuevoVertice(T elemento) throws VerticeExisteException {
        boolean esta = getNumeroVertice(elemento) >= 0;
        if (esta) {
            throw new VerticeExisteException("El vertice existe");
        }
        Vertice<T> v = new Vertice(elemento);
        v.setNumVertice(numeroVertices);
        vertices[numeroVertices++] = v;
    }
    
    @Override
    public void nuevoVertice(Vertice<T> vertice) throws VerticeExisteException {
        if(numeroVertices == MAXVERTICES) {
            throw new ArrayIndexOutOfBoundsException(); 
        }
        boolean esta = getNumeroVertice(vertice.getElemento()) >= 0;
        if (esta) {
            throw new VerticeExisteException("El vertice existe");
        }
        vertice.setNumVertice(numeroVertices);
        vertices[numeroVertices++] = vertice;
    }    

    @Override
    public void borrarVertice(T elemento) throws VerticeNoExisteException {
        int va = getNumeroVertice(elemento);
        if (va < 0) {
            throw new VerticeNoExisteException("Vertice no exite");
        }

        //Borro los arcos adyacentes
        for (int i = 0; i < numeroVertices; i++) {
            if (adyacente(va, i)) {
                try {

                    borrarArco(elemento, getElemento(i));
                } catch (ArcoNoExisteException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        for (int i = va; i < numeroVertices; i++) {
            if(i != numeroVertices - 1) {
                vertices[i] = vertices[i + 1];                
            }
            else {
                vertices[i] = null;
            }
        }
        moverColumnas(va);
        moverfilas(va);
        numeroVertices--;
    }

    @Override
    public void union(T elemento1, T elemento2) throws VerticeNoExisteException {
        int va, vb;
        va = getNumeroVertice(elemento1);
        vb = getNumeroVertice(elemento2);
        if (va < 0 || vb < 0) {
            throw new VerticeNoExisteException("Vertice no existe");
        }

        //Manejando grafos no dirigidos
        matrizAdyacencia[va][vb] = 1;
        matrizAdyacencia[vb][va] = 1;
    }

    @Override
    public boolean buscarProfundidad(T elemento) throws VerticeNoExisteException {
        boolean encontrado = true;
        if(this.recorrerProfundidad().indexOf(elemento) < 0) {
            encontrado = false;
        }
        return encontrado;
    }

    @Override
    public boolean buscarAmplitud(T elemento) throws VerticeNoExisteException {
        //numero del vertice inicial y vertice a buscar
        int vi = 0;
        int vb = getNumeroVertice(elemento);
        boolean encontrado = false;
        //Estructuras para el algortimo
        Boolean procesados[] = new Boolean[numeroVertices];
        Arrays.fill(procesados, false);
        Queue<Integer> colaNumVertices = new ArrayDeque<>();
        //Paso 1 Marcar como prodesado el vertice inicial
        procesados[vi] = true;
        //Pasa 2 meter el vertice inicial a la cola
        colaNumVertices.add(vi);
        //Paso repetir paso 4 y paso 5 mientras la cola no este vacía
        while (!colaNumVertices.isEmpty()) {
            //paso 4 visitar el vertice del frente de la cola
            int verticeActual = colaNumVertices.remove();
            if (verticeActual == vb) {
                encontrado = true;
                break;
            }

            //paso 5 agregar todos los vertices adyacentes y que no esten procesados a la cola y marcarlos como procesados
            for (int i = 0; i < numeroVertices; i++) {
                if (adyacente(verticeActual, i) && !procesados[i]) {
                    colaNumVertices.add(i);
                    procesados[i] = true;
                }
            }

        }

        return encontrado;
    }

    @Override
    public ArrayList<T> recorrerAmplitud() {
        int inicio = 0;
        ArrayList<Vertice> colaRecorrido = new ArrayList<Vertice>();
        ArrayList<T> verticesRecorridos = new ArrayList<>();
        if (!isEmpty()) {
            // Meter en la cola y procesar el vertice de inicio
            colaRecorrido.add(0, vertices[inicio]);
            verticesRecorridos.add(vertices[inicio].getElemento());

            while (!colaRecorrido.isEmpty()) {
                Vertice siguienteVertice = colaRecorrido.remove(0);
                for (int i = 0; i < matrizAdyacencia[siguienteVertice.getNumVertice()].length; i++) {
                    if (matrizAdyacencia[siguienteVertice.getNumVertice()][i] == 1 && !verticesRecorridos.contains(vertices[i].getElemento())) {
                        verticesRecorridos.add(vertices[i].getElemento());
                        colaRecorrido.add(colaRecorrido.size(), vertices[i]);
                    }
                }
            }
        }
        return verticesRecorridos;
    }

    @Override
    public ArrayList<T> recorrerProfundidad() {
        return recorridoProfundidad(0);
    }

    public ArrayList<T> recorridoProfundidad(int numeroVertice) {
        ArrayList<T> recorrido = new ArrayList<>();
        ArrayList<Vertice<T>> pila = new ArrayList<>();
        ArrayList<Vertice<T>> verticesRecorridos = new ArrayList<>();

        if (!isEmpty()) {
            pila.add(vertices[numeroVertice]);
            verticesRecorridos.add(vertices[numeroVertice]);
        }

        return recorridoProfundidad(pila, verticesRecorridos, recorrido);
    }

    private ArrayList<T> recorridoProfundidad(ArrayList<Vertice<T>> pila, ArrayList<Vertice<T>> verticesRecorridos, ArrayList<T> recorrido) {
        if (!pila.isEmpty()) {
            Vertice<T> verticeActual = pila.remove(pila.size() - 1);

            for (int i = 0; i < matrizAdyacencia[verticeActual.getNumVertice()].length; i++) {
                if (matrizAdyacencia[verticeActual.getNumVertice()][i] == 1 && !verticesRecorridos.contains(vertices[i])) {
                    pila.add(vertices[i]);
                    verticesRecorridos.add(vertices[i]);
                }
            }

            recorrido.add(verticeActual.getElemento());
            recorridoProfundidad(pila, verticesRecorridos, recorrido);
        }

        return recorrido;
    }

    public boolean isEmpty() {
        return numeroVertices == 0;
    }

    @Override
    public int getNumeroVertices() {
        return numeroVertices;
    }

    @Override
    public T getElemento(int vertice) throws VerticeNoExisteException {
        return vertices[vertice].getElemento();
    }

    //Debemo correr las columnas y filas
    private void moverColumnas(int columna) {
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = columna; j < numeroVertices; j++) {
                if (j == numeroVertices - 1) {
                    matrizAdyacencia[i][j] = 0;
                } // De lo contrario se realiza el procedimiento de mover las columnas
                else {
                    // Mover una columna a la izquierda los valores
                    matrizAdyacencia[i][j] = matrizAdyacencia[i][j + 1];
                }
            }
        }
    }

    private void moverfilas(int fila) {
        for (int i = fila; i < numeroVertices; i++) {
            for (int j = 0; j < numeroVertices; j++) {
                if (i == numeroVertices - 1) {
                    matrizAdyacencia[i][j] = 0;
                } // De lo contrario se realiza el procedimiento de mover las columnas
                else {
                    // Mover una columna a la izquierda los valores
                    matrizAdyacencia[i][j] = matrizAdyacencia[i + 1][j];
                }
            }
        }
    }

    @Override
    public ArrayList<ArcoDoble> getArcos() {
        ArrayList<ArcoDoble> arcos = new ArrayList<>();
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < numeroVertices; j++) {
                if(matrizAdyacencia[i][j] == 1) {
                    arcos.add(new ArcoDoble(vertices[i], vertices[j]));
                }
            }                     
        }
        return arcos;
    }

    @Override
    public ArrayList<Vertice> getVertices() {
        ArrayList<Vertice> verticesList = new ArrayList<>();
        for(int i = 0; i < vertices.length; i++) {
            if(vertices[i] != null) {
                verticesList.add(vertices[i]);                
            }
        }
        return verticesList;
    }

    @Override
    public boolean existeVertice(T elemento) {
        boolean existe = false;
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != null) {
                if (vertices[i].getElemento().equals(elemento)) {
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }

}
