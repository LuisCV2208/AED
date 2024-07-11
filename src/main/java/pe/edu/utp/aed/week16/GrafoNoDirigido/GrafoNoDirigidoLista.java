package pe.edu.utp.aed.week16.GrafoNoDirigido;

import java.util.Arrays;
import java.util.LinkedList;

public class GrafoNoDirigidoLista {
    LinkedList<String>[] arreglo;
    String[] nodos;

    public GrafoNoDirigidoLista(String[] nodos) {
        this.nodos = nodos;
        arreglo = new LinkedList[nodos.length];
        for (int i = 0; i < nodos.length; i++) {
            arreglo[i] = new LinkedList<>();
        }
        Arrays.sort(nodos);
    }

    public void agregarEnlace(String inicial, String _final) {
        int idxInicial = Arrays.binarySearch(nodos, inicial);
        int idxFinal = Arrays.binarySearch(nodos, _final);
        arreglo[idxInicial].add(nodos[idxFinal]);
        arreglo[idxFinal].add(nodos[idxInicial]);
    }
}
