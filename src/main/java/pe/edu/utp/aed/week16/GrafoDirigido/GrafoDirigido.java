package pe.edu.utp.aed.week16.GrafoDirigido;

import java.util.*;

public class GrafoDirigido {
    private final ArrayList<NodoG> nodos;

    public GrafoDirigido(Collection<Ciudad> ciudades) {
        nodos = new ArrayList<>();
        for (Ciudad ciudad : ciudades) {
            nodos.add(new NodoG(ciudad));
        }
    }

    public void agregarEnlace(Ciudad origen, Ciudad destino, double costo) {
        NodoG nodoOrigen = obtenerNodo(origen);
        NodoG nodoDestino = obtenerNodo(destino);
        if (nodoOrigen != null && nodoDestino != null) {
            nodoOrigen.getEnlaces().add(new Enlace(nodoDestino, costo));
        }
    }

    public List<Ciudad> encontrarRutaMinima(Ciudad origen, Ciudad destino) {
        Map<Ciudad, Ciudad> predecesores = new HashMap<>();
        Map<Ciudad, Double> distancias = new HashMap<>();
        PriorityQueue<NodoG> cola = new PriorityQueue<>(Comparator.comparingDouble(nodo -> distancias.get(nodo.getCiudad())));

        for (NodoG nodo : nodos) {
            distancias.put(nodo.getCiudad(), Double.MAX_VALUE);
        }
        distancias.put(origen, 0.0);
        cola.add(obtenerNodo(origen));

        while (!cola.isEmpty()) {
            NodoG actual = cola.poll();

            for (Enlace enlace : actual.getEnlaces()) {
                NodoG vecino = enlace.getDestino();
                double nuevaDistancia = distancias.get(actual.getCiudad()) + enlace.getCosto();

                if (nuevaDistancia < distancias.get(vecino.getCiudad())) {
                    distancias.put(vecino.getCiudad(), nuevaDistancia);
                    predecesores.put(vecino.getCiudad(), actual.getCiudad());
                    cola.add(vecino);
                }
            }
        }

        List<Ciudad> ruta = new LinkedList<>();
        Ciudad paso = destino;
        if (predecesores.get(paso) != null || paso.equals(origen)) {
            while (paso != null) {
                ruta.add(0, paso);
                paso = predecesores.get(paso);
            }
        }
        return ruta.isEmpty() ? null : ruta;
    }

    public List<Ciudad> encontrarSegundaRutaMinima(Ciudad origen, Ciudad destino) {
        List<Ciudad> rutaMinima = encontrarRutaMinima(origen, destino);
        if (rutaMinima == null || rutaMinima.isEmpty()) {
            return null;
        }

        PriorityQueue<List<Ciudad>> rutas = new PriorityQueue<>(Comparator.comparingDouble(this::calcularCostoRuta));
        rutas.add(rutaMinima);

        Set<String> visitadas = new HashSet<>();
        visitadas.add(rutaMinima.toString());

        List<Ciudad> segundaRutaMinima = null;

        while (!rutas.isEmpty()) {
            List<Ciudad> rutaActual = rutas.poll();

            if (segundaRutaMinima != null && calcularCostoRuta(rutaActual) > calcularCostoRuta(segundaRutaMinima)) {
                break;
            }

            if (!rutaActual.equals(rutaMinima)) {
                segundaRutaMinima = rutaActual;
                break;
            }

            for (int i = 0; i < rutaActual.size() - 1; i++) {
                Ciudad nodoOrigen = rutaActual.get(i);
                Ciudad nodoDestino = rutaActual.get(i + 1);

                eliminarEnlace(obtenerNodo(nodoOrigen), obtenerNodo(nodoDestino));
                List<Ciudad> nuevaRuta = encontrarRutaMinima(origen, destino);
                agregarEnlace(nodoOrigen, nodoDestino, calcularCosto(obtenerNodo(nodoOrigen), obtenerNodo(nodoDestino)));

                if (nuevaRuta != null && !visitadas.contains(nuevaRuta.toString())) {
                    rutas.add(nuevaRuta);
                    visitadas.add(nuevaRuta.toString());
                }
            }
        }
        return segundaRutaMinima;
    }

    private double calcularCostoRuta(List<Ciudad> ruta) {
        double costo = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            NodoG nodoOrigen = obtenerNodo(ruta.get(i));
            NodoG nodoDestino = obtenerNodo(ruta.get(i + 1));
            costo += calcularCosto(nodoOrigen, nodoDestino);
        }
        return costo;
    }

    private void eliminarEnlace(NodoG origen, NodoG destino) {
        origen.getEnlaces().removeIf(enlace -> enlace.getDestino().equals(destino));
    }

    private double calcularCosto(NodoG origen, NodoG destino) {
        for (Enlace enlace : origen.getEnlaces()) {
            if (enlace.getDestino().equals(destino)) {
                return enlace.getCosto();
            }
        }
        return Double.MAX_VALUE;
    }

    private NodoG obtenerNodo(Ciudad ciudad) {
        for (NodoG nodo : nodos) {
            if (nodo.getCiudad().equals(ciudad)) {
                return nodo;
            }
        }
        return null;
    }
}
