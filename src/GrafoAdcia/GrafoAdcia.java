/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrafoAdcia;

import Excepciones.ArcoNoExisteException;
import Excepciones.VerticeExisteException;
import Excepciones.VerticeNoExisteException;
import Modelo.ArcoDoble;
import Modelo.Grafo;
import Modelo.Punto;
import Modelo.Vertice;
import java.util.ArrayList;

/**
 *
 * @author Equipo1
 */
public class GrafoAdcia<T> implements Grafo<T> {

    private int numVerts;
    public static int maxVerts = 20;
    private VerticeAdy<T>[] tablAdc;

    public GrafoAdcia(int mx) {
        tablAdc = new VerticeAdy[mx];
        numVerts = 0;
        maxVerts = mx;
    }

    public GrafoAdcia() {
        this(maxVerts);
    }

    public int numeroDeVertices() {
        return numVerts;
    }

    public VerticeAdy[] vertices() {
        return tablAdc;
    }

//La operación listaAdyc()devuelve la lista de adyacencia del vértice v.
    public ArrayList<Arco> listaAdyc(int v) throws Exception {
        if (v < 0 || v >= numVerts) {
            throw new Exception(" Vértice fuera de rango ");
        }
        return tablAdc[v].lad;
    }
    
// numVertice() busca el vértice en la tabla. 
// Devuelve -1 si no lo encuentra:
    public int numVertice(T nm) {
        VerticeAdy<T> v = new VerticeAdy(nm);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado;) {
            encontrado = tablAdc[i].equals(v);
            if (!encontrado) {
                i++;
            }
        }
        return (i < numVerts) ? i : -1;
    }
    
    public boolean isEmpty() {
        boolean vacio = true;
        if(numVerts > 0) {
            vacio = false;
        }
        return vacio;
    }    

    public void imprimirGrafo() {
        for (int i = 0; i < tablAdc.length; i++) {
            if (tablAdc[i] != null) {
                System.out.println(tablAdc[i].getNumVertice() + ".- " + tablAdc[i].getNombre());
                System.out.println("    Arcos: ");
                tablAdc[i].getLad().forEach((arco) -> {
                    System.out.println("    Destino: " + tablAdc[arco.getDestino()].getNombre() + ", Peso: " + arco.getPeso());
                });
            }
        }
    }

    @Override
    public ArrayList<ArcoDoble> getArcos() {
        ArrayList<ArcoDoble> arcos = new ArrayList<>();
        for (int i = 0; i < numVerts; i++) {
            for(int j = 0; j < tablAdc[i].getLad().size(); j++) {
                Vertice<T> v1 = new Vertice(tablAdc[i].getNombre());
                v1.setCoords(tablAdc[i].getCoords());
                
                ArrayList<Arco> arcosV = tablAdc[i].getLad();
                Arco arcoIndividual = arcosV.get(j);
                int destino = arcoIndividual.getDestino();
                
                Vertice<T> v2 = new Vertice(tablAdc[destino].getNombre());
                v2.setCoords(tablAdc[tablAdc[i].getLad().get(j).getDestino()].getCoords());
                
                ArcoDoble arco = new ArcoDoble(v1, v2);
                if(!arcos.contains(arco)) {
                    arcos.add(arco);
                }
            }
        }
        return arcos;
    }
    
    public void imprimirArcos() {
        for(int i = 0; i < numVerts; i++) {
            System.out.println(i + "- " + tablAdc[i].getNombre() + ", arcos: " + tablAdc[i].getLad());
        }
    }

    @Override
    public ArrayList<Vertice> getVertices() {
        ArrayList<Vertice> vertices = new ArrayList<>();
        for(int i = 0; i < numVerts; i++) {
            Vertice<T> v = new Vertice(tablAdc[i].getNombre());
            v.setCoords(tablAdc[i].getCoords());
            vertices.add(v);
        }
        return vertices;
    }

    @Override
    public void borrarArco(T elemento1, T elemento2) throws VerticeNoExisteException, ArcoNoExisteException {
        int va, vb;
        va = numVertice(elemento1);
        vb = numVertice(elemento2);
        if (va < 0 || vb < 0) {
            throw new VerticeNoExisteException("Vértice no existe");
        }
        
        for(int i = 0; i < tablAdc[va].lad.size(); i++) {
            if(tablAdc[va].lad.get(i).getDestino() == vb) {
                tablAdc[va].lad.remove(i);
                break;
            }
        }
        for(int i = 0; i < tablAdc[vb].lad.size(); i++) {
            if(tablAdc[vb].lad.get(i).getDestino() == va) {
                tablAdc[vb].lad.remove(i);
                break;
            }
        }        
        /*Arco ab = new Arco(vb);
        Arco ab2 = new Arco(va);
        tablAdc[va].lad.remove(ab);
        tablAdc[vb].lad.remove(ab2);*/
    }
    
    private void actualizarArcos(int eliminado) {
        for(int i = 0; i < numVerts; i++) {
            for(int j = 0; j < tablAdc[i].getLad().size(); j++) {
                if(tablAdc[i].getLad().get(j).getDestino() > eliminado) {
                    tablAdc[i].getLad().get(j).setDestino(tablAdc[i].getLad().get(j).getDestino() - 1);
                }
            }
        }
    }
    
    @Override
    public void borrarVertice(T elemento) throws VerticeNoExisteException {
        int va = numVertice(elemento);
        if (va < 0) {
            throw new VerticeNoExisteException("Vertice no existe");
        }
        //Borrar los vertices que son adyacentes a el
        for (int i = 0; i < numVerts; i++) {
            try {
                borrarArco(getElemento(i), elemento);
            } catch (ArcoNoExisteException ex) {
                System.out.println("Grafo Lista: " + ex.getMessage());
            }
        }
        //Corre todos los vertices
        for (int i = va; i < numVerts - 1; i++) {
            tablAdc[i + 1].asigVert(tablAdc[i].getNumVertice());
            tablAdc[i] = tablAdc[i + 1];
        }
        tablAdc[numVerts - 1] = null;
        numVerts--;
        actualizarArcos(va);
    }    

    @Override
    public boolean adyacente(T elemento1, T elemento2) throws VerticeNoExisteException {
        int va = numVertice(elemento1);
        int vb = numVertice(elemento2);        
        if (va < 0 || vb < 0) {
            throw new VerticeNoExisteException("Vértice no existe");
        }
        if (tablAdc[va].lad.contains(new Arco(vb))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void nuevoVertice(T elemento) throws VerticeExisteException {
        boolean esta = numVertice(elemento) >= 0;
        if (!esta) {
            VerticeAdy<T> v = new VerticeAdy(elemento);
            v.asigVert(numVerts);
            tablAdc[numVerts++] = v;
        }
    }

    @Override
    public void nuevoVertice(Vertice<T> vertice) throws VerticeExisteException {
        boolean esta = numVertice(vertice.getElemento()) >= 0;
        if (!esta) {
            VerticeAdy<T> v = new VerticeAdy(vertice.getElemento());
            v.setCoords(vertice.getCoords());
            v.asigVert(numVerts);
            tablAdc[numVerts++] = v;
        }
        else {
            throw new VerticeExisteException("El vértice ya existe");
        }
    }

    @Override
    public void union(T elemento1, T elemento2) throws VerticeNoExisteException {
        if (!adyacente(elemento1, elemento2)) {
            int va = numVertice(elemento1);
            int vb = numVertice(elemento2);
            if (va < 0 || vb < 0) {
                throw new VerticeNoExisteException("Vértice no existe");
            }
            Arco ab = new Arco(vb);
            Arco ab2 = new Arco(va);
            tablAdc[va].lad.add(ab);
            tablAdc[vb].lad.add(ab2);
        }
    }

    @Override
    public boolean buscarProfundidad(T elemento) throws VerticeNoExisteException {
        boolean encontrado = true;
        if(this.recorrerProfundidad().indexOf(elemento) < 0) {
            encontrado = false;
        }
        return encontrado;    }
    
    @Override
    public ArrayList<T> recorrerProfundidad() throws VerticeNoExisteException {
        ArrayList<T> recorrido = new ArrayList<>();
        ArrayList<VerticeAdy<T>> pila = new ArrayList<>();
        ArrayList<VerticeAdy<T>> verticesRecorridos = new ArrayList<>();

        if (!isEmpty()) {
            pila.add(tablAdc[0]);
            verticesRecorridos.add(tablAdc[0]);
        }

        return recorridoProfundidad(pila, verticesRecorridos, recorrido);
    } 

    private ArrayList<T> recorridoProfundidad(ArrayList<VerticeAdy<T>> pila, ArrayList<VerticeAdy<T>> verticesRecorridos, ArrayList<T> recorrido) {
        if (!pila.isEmpty()) {
            VerticeAdy<T> verticeActual = pila.remove(pila.size() - 1);
            System.out.println("Actual: " + verticeActual);
            for (int i = 0; i < tablAdc[verticeActual.getNumVertice()].getLad().size(); i++) {
                int verticeAdy = tablAdc[verticeActual.getNumVertice()].getLad().get(i).getDestino();

                if (!verticesRecorridos.contains(tablAdc[verticeAdy])) {
                    pila.add(tablAdc[verticeAdy]);
                    verticesRecorridos.add(tablAdc[verticeAdy]);
                }
            }

            recorrido.add(verticeActual.getNombre());
            recorridoProfundidad(pila, verticesRecorridos, recorrido);
        }

        return recorrido;
    }

    @Override
    public boolean buscarAmplitud(T elemento) throws VerticeNoExisteException {
        boolean encontrado = true;
        if(this.recorrerAmplitud().indexOf(elemento) < 0) {
            encontrado = false;
        }
        return encontrado;
    }

    @Override
    public ArrayList<T> recorrerAmplitud() throws VerticeNoExisteException {
        int inicio = 0;
        ArrayList<VerticeAdy> colaRecorrido = new ArrayList<VerticeAdy>();
        ArrayList<T> verticesRecorridos = new ArrayList<>();      
        if (!isEmpty()) {
            // Meter en la cola y procesar el vertice de inicio
            colaRecorrido.add(0, tablAdc[inicio]);
            verticesRecorridos.add(tablAdc[inicio].getNombre());

            while (!colaRecorrido.isEmpty()) {
                VerticeAdy<T> siguienteVertice = colaRecorrido.remove(0);

                for (int i = 0; i < tablAdc[siguienteVertice.getNumVertice()].getLad().size(); i++) {
                    Arco arc = (Arco) tablAdc[siguienteVertice.getNumVertice()].getLad().get(i);
                    int verticeAdy = arc.getDestino();
                    if (!verticesRecorridos.contains(tablAdc[verticeAdy].getNombre())) {
                        verticesRecorridos.add(tablAdc[verticeAdy].getNombre());
                        colaRecorrido.add(colaRecorrido.size(), tablAdc[verticeAdy]);
                    }
                }
            }
        }
        return verticesRecorridos;
    }

    @Override
    public int getNumeroVertices() {
        return this.numVerts;
    }

    @Override
    public T getElemento(int vertice) throws VerticeNoExisteException {
        return this.tablAdc[vertice].getNombre();
    }

    @Override
    public boolean adyacente(int num1, int num2) throws VerticeNoExisteException {
        if (num1 < 0 || num2 < 0) {
            throw new VerticeNoExisteException("Vértice no existe");
        }
        if (tablAdc[num1].lad.contains(new Arco(num2))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existeVertice(T elemento) {
        boolean existe = false;
        for(int i = 0; i < numVerts; i++) {
            if(tablAdc[i].getNombre().equals(elemento)) {
                existe = true;
                break;
            }
        }
        return existe;
    }
    
}
