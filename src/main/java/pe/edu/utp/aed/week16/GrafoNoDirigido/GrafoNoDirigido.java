package pe.edu.utp.aed.week16.GrafoNoDirigido;

import java.util.Arrays;

public class GrafoNoDirigido {
    int[][] matriz;
    String[] nodos;

    public GrafoNoDirigido(String[] nodos) {
        this.nodos = nodos;
        matriz = new int[nodos.length][nodos.length];
        Arrays.sort(this.nodos);
    }

    public void agregarEnlace(String inicial, String _final) {
        int idxInicial = Arrays.binarySearch(nodos, inicial);
        int idxFinal = Arrays.binarySearch(nodos, _final);
        matriz[idxInicial][idxFinal] = 1;
        matriz[idxFinal][idxInicial] = 1;
    }
}
