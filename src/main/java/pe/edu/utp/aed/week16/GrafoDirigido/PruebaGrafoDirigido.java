package pe.edu.utp.aed.week16.GrafoDirigido;

import java.util.HashMap;

public class PruebaGrafoDirigido {
    public static void main(String[] args) {
        String[] nombresCiudades = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};

        HashMap<String, Ciudad> dicCiudades = new HashMap<>();

        for (String nombre : nombresCiudades) {
            dicCiudades.put(nombre, new Ciudad(nombre));
        }

        GrafoDirigido grafo = new GrafoDirigido(dicCiudades.values());
        grafo.agregarEnlace(dicCiudades.get("A"), dicCiudades.get("B"), 4);
        grafo.agregarEnlace(dicCiudades.get("A"), dicCiudades.get("C"), 3);
        grafo.agregarEnlace(dicCiudades.get("A"), dicCiudades.get("D"), 2);
        grafo.agregarEnlace(dicCiudades.get("B"), dicCiudades.get("E"), 3);
        grafo.agregarEnlace(dicCiudades.get("C"), dicCiudades.get("E"), 2);
        grafo.agregarEnlace(dicCiudades.get("C"), dicCiudades.get("F"), 1);
        grafo.agregarEnlace(dicCiudades.get("D"), dicCiudades.get("F"), 5);
        grafo.agregarEnlace(dicCiudades.get("E"), dicCiudades.get("H"), 5);
        grafo.agregarEnlace(dicCiudades.get("E"), dicCiudades.get("G"), 2);
        grafo.agregarEnlace(dicCiudades.get("F"), dicCiudades.get("G"), 2);
        grafo.agregarEnlace(dicCiudades.get("I"), dicCiudades.get("F"), 2);
        grafo.agregarEnlace(dicCiudades.get("G"), dicCiudades.get("H"), 4);
        grafo.agregarEnlace(dicCiudades.get("G"), dicCiudades.get("J"), 3);
        grafo.agregarEnlace(dicCiudades.get("H"), dicCiudades.get("K"), 6);
        grafo.agregarEnlace(dicCiudades.get("J"), dicCiudades.get("K"), 6);
        grafo.agregarEnlace(dicCiudades.get("L"), dicCiudades.get("D"), 20);
        grafo.agregarEnlace(dicCiudades.get("J"), dicCiudades.get("I"), 4);

        // grafo.recorridoGrafo(dicCiudades.get("A"), dicCiudades.get("K"));
        System.out.println(grafo.obtenerReporteCostosMinimos(dicCiudades.get("J")));
    }
}
