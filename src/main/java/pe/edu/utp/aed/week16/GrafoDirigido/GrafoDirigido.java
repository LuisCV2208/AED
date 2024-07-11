package pe.edu.utp.aed.week16.GrafoDirigido;

import java.util.*;

public class GrafoDirigido {
    ArrayList<NodoG> nodos;

    public GrafoDirigido(Collection<Ciudad> ciudades) {
        nodos = new ArrayList<>();
        for (Ciudad ciudad : ciudades) {
            nodos.add(new NodoG(ciudad));
        }
    }

    public void agregarEnlace(Ciudad origen, Ciudad destino, double costo) {
        NodoG nodoOrigen = nodos.stream().filter((NodoG ng) -> ng.getCiudad().equals(origen)).toList().get(0);
        NodoG nodoDestino = nodos.stream().filter((NodoG ng) -> ng.getCiudad().equals(destino)).toList().get(0);
        nodoOrigen.getEnlaces().add(new Enlace(nodoDestino, costo));
    }

    public void recorridoGrafo(Ciudad origen, Ciudad destino) {
        NodoG nodoOrigen = nodos.stream().filter((NodoG ng) -> ng.getCiudad().equals(origen)).toList().get(0);
        NodoG nodoDestino = nodos.stream().filter((NodoG ng) -> ng.getCiudad().equals(destino)).toList().get(0);
        visitaNodo(nodoOrigen, nodoDestino, "");
    }

    private void visitaNodo(NodoG nodoActual, NodoG nodoDestino, String ruta) {
        if (nodoActual.getCiudad().equals(nodoDestino.getCiudad())) {
            // TODO: cambiar por una estructura que almacene las rutas posibles
            // entre un origen y un destino
            System.out.println(ruta + nodoActual.getCiudad().getNombre());
            return;
        }
        for (Enlace enlace : nodoActual.getEnlaces()) {
            visitaNodo(enlace.getDestino(), nodoDestino, ruta + nodoActual.getCiudad().getNombre() + "/");
        }
    }

    public String obtenerReporteCostosMinimos(Ciudad origen) {
        // Algoritmo de Dijkstra para hallar costos mínimos
        // Adaptado de: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
        double[] costos = new double[nodos.size()];
        boolean[] visitados = new boolean[nodos.size()];

        PriorityQueue<Enlace> colaPrioritaria =
                new PriorityQueue<>(nodos.size(), Comparator.comparingDouble(Enlace::getCosto));
        Arrays.fill(costos, Double.MAX_VALUE);

        int indiceOrigen = obtenerPosicion(origen);
        costos[indiceOrigen] = 0;

        colaPrioritaria.add(new Enlace(obtenerNodo(origen), 0));

        while (!colaPrioritaria.isEmpty()) {
            NodoG nodoDestino = colaPrioritaria.poll().getDestino();
            int posicionDestino = obtenerPosicion(nodoDestino.getCiudad());
            visitados[posicionDestino] = true;

            for (Enlace enlace : nodoDestino.getEnlaces()) {
                int posicionDestinoEnlace = obtenerPosicion(enlace.getDestino().getCiudad());
                if (!visitados[posicionDestinoEnlace] &&
                        costos[posicionDestino] != Double.MAX_VALUE &&
                        costos[posicionDestino] + enlace.getCosto() < costos[posicionDestinoEnlace]) {
                    costos[posicionDestinoEnlace] = costos[posicionDestino] + enlace.getCosto();
                    colaPrioritaria.add(new Enlace(enlace.getDestino(), costos[posicionDestinoEnlace]));
                }
            }
        }

        return generarReporte(costos);
    }

    private String generarReporte(double[] costos) {
        StringBuilder sbReporte = new StringBuilder();
        for (int i = 0; i < costos.length; i++) {
            sbReporte.append(String.format("%s %f\n", nodos.get(i).getCiudad().getNombre(), costos[i]));
        }
        return sbReporte.toString();
    }

    private int obtenerPosicion(Ciudad ciudad) {
        for (int i = 0; i < nodos.size(); i++) {
            if (nodos.get(i).getCiudad().getNombre().equals(ciudad.getNombre()))
                return i;
        }
        return -1;
    }

    private NodoG obtenerNodo(Ciudad ciudad) {
        for (NodoG nodo : nodos) {
            if (nodo.getCiudad().getNombre().equals(ciudad.getNombre()))
                return nodo;
        }
        return null;
    }
}
