package pe.edu.utp.aed.week16.GrafoNoDirigido;

import java.util.*;

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

    public void recorridoPorAmplitud(String root) {
        Set<String> visitados = new LinkedHashSet<>();
        Queue<String> cola = new LinkedList<>();
        cola.offer(root);
        visitados.add(root);

        while (!cola.isEmpty()) {
            String u = cola.poll();
            System.out.println(u);
            int idx = Arrays.binarySearch(nodos, u);
            for (String v : arreglo[idx]) {
                System.out.print(v + ",");
                if (!visitados.contains(v)) {
                    visitados.add(v);
                    cola.offer(v);
                }
            }
            System.out.println();
        }
    }

    public LinkedList<LinkedList<String>> recorridoPorAmplitud(String root, String destino) {
        LinkedList<LinkedList<String>> rutas = new LinkedList<>();

        Set<String> visitados = new LinkedHashSet<>();
        Queue<String> cola = new LinkedList<>();
        cola.offer(root);
        visitados.add(root);

        LinkedList<String> ruta = new LinkedList<>();
        ruta.add(root);
        rutas.add(ruta);

        while (!cola.isEmpty()) {
            String u = cola.poll();
            int idx = Arrays.binarySearch(nodos, u);
            for (String v : arreglo[idx]) {
                if (!ruta.contains(v))
                    ruta.add(v);
                else {
                    LinkedList<String> nuevaRuta = new LinkedList<>();
                    nuevaRuta.add(root);
                    rutas.add(nuevaRuta);
                }

                if (!visitados.contains(v) && !v.equals(destino)) {
                    visitados.add(v);
                    cola.offer(v);
                } else {
                    return rutas;
                }
            }
        }

        return null;
    }

    public void recorridoEnProfundidad(String root) {
        Set<String> visitados = new LinkedHashSet<>();
        Stack<String> pila = new Stack<>();
        pila.push(root);

        while(!pila.isEmpty()) {
            String u = pila.pop();
            System.out.println(u);
            int idx = Arrays.binarySearch(nodos, u);
            if(!visitados.contains(u)) {
                visitados.add(u);
                for(String v: arreglo[idx]) {
                    System.out.print(v + ",");
                    pila.push(v);
                }
                System.out.println();
            }
        }
    }
}
