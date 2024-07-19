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
        NodoG nodoOrigen = obtenerNodo(origen);
        NodoG nodoDestino = obtenerNodo(destino);
        nodoOrigen.getEnlaces().add(new Enlace(nodoDestino, costo));
    }

    public NodoG obtenerNodo(Ciudad ciudad) {
        for (NodoG nodo : nodos) {
            if (nodo.getCiudad().equals(ciudad)) {
                return nodo;
            }
        }
        return null;
    }

    // Función para encontrar todas las rutas entre dos nodos
    public List<List<Ciudad>> encontrarRutas(Ciudad origen, Ciudad destino) {
        NodoG nodoOrigen = obtenerNodo(origen);
        NodoG nodoDestino = obtenerNodo(destino);
        List<List<Ciudad>> rutas = new ArrayList<>();
        List<Ciudad> rutaActual = new ArrayList<>();
        encontrarRutasRecursivo(nodoOrigen, nodoDestino, rutaActual, rutas);
        return rutas;
    }

    private void encontrarRutasRecursivo(NodoG nodoActual, NodoG nodoDestino, List<Ciudad> rutaActual, List<List<Ciudad>> rutas) {
        rutaActual.add(nodoActual.getCiudad());

        if (nodoActual.equals(nodoDestino)) {
            rutas.add(new ArrayList<>(rutaActual));
        } else {
            for (Enlace enlace : nodoActual.getEnlaces()) {
                if (!rutaActual.contains(enlace.getDestino().getCiudad())) {
                    encontrarRutasRecursivo(enlace.getDestino(), nodoDestino, rutaActual, rutas);
                }
            }
        }

        rutaActual.remove(rutaActual.size() - 1);
    }

    // Función para calcular el costo de una ruta
    private double calcularCostoRuta(List<Ciudad> ruta) {
        double costo = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            NodoG nodoOrigen = obtenerNodo(ruta.get(i));
            NodoG nodoDestino = obtenerNodo(ruta.get(i + 1));
            for (Enlace enlace : nodoOrigen.getEnlaces()) {
                if (enlace.getDestino().equals(nodoDestino)) {
                    costo += enlace.getCosto();
                    break;
                }
            }
        }
        return costo;
    }

    // Función para encontrar la ruta de menor costo
    public List<Ciudad> rutaMenorCosto(Ciudad origen, Ciudad destino) {
        List<List<Ciudad>> rutas = encontrarRutas(origen, destino);
        List<Ciudad> rutaMenorCosto = null;
        double menorCosto = Double.MAX_VALUE;

        for (List<Ciudad> ruta : rutas) {
            double costoRuta = calcularCostoRuta(ruta);
            if (costoRuta < menorCosto) {
                menorCosto = costoRuta;
                rutaMenorCosto = ruta;
            }
        }

        return rutaMenorCosto;
    }
}
