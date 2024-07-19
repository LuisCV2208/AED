package pe.edu.utp.aed.week16.GrafoDirigido;

import java.util.HashMap;
import java.util.List;

public class PruebaGrafoDirigido {
    public static void main(String[] args) {
        String[] nombresCiudades = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};

        HashMap<String, Ciudad> dicCiudades = new HashMap<>();

        for (String nombre : nombresCiudades) {
            dicCiudades.put(nombre, new Ciudad(nombre));
        }

        GrafoDirigido grafo = new GrafoDirigido(dicCiudades.values());
        grafo.agregarEnlace(dicCiudades.get("B"), dicCiudades.get("A"), 1);
        grafo.agregarEnlace(dicCiudades.get("C"), dicCiudades.get("A"), 25);
        grafo.agregarEnlace(dicCiudades.get("A"), dicCiudades.get("D"), 13);
        grafo.agregarEnlace(dicCiudades.get("A"), dicCiudades.get("G"), 2);
        grafo.agregarEnlace(dicCiudades.get("C"), dicCiudades.get("B"), 2);
        grafo.agregarEnlace(dicCiudades.get("C"), dicCiudades.get("E"), 30);
        grafo.agregarEnlace(dicCiudades.get("E"), dicCiudades.get("F"), 4);
        grafo.agregarEnlace(dicCiudades.get("E"), dicCiudades.get("B"), 5);
        grafo.agregarEnlace(dicCiudades.get("E"), dicCiudades.get("H"), 14);
        grafo.agregarEnlace(dicCiudades.get("F"), dicCiudades.get("C"), 11);
        grafo.agregarEnlace(dicCiudades.get("F"), dicCiudades.get("I"), 9);
        grafo.agregarEnlace(dicCiudades.get("G"), dicCiudades.get("D"), 12);
        grafo.agregarEnlace(dicCiudades.get("G"), dicCiudades.get("J"), 8);
        grafo.agregarEnlace(dicCiudades.get("G"), dicCiudades.get("F"), 17);
        grafo.agregarEnlace(dicCiudades.get("H"), dicCiudades.get("I"), 3);
        grafo.agregarEnlace(dicCiudades.get("H"), dicCiudades.get("K"), 6);
        grafo.agregarEnlace(dicCiudades.get("I"), dicCiudades.get("E"), 15);
        grafo.agregarEnlace(dicCiudades.get("J"), dicCiudades.get("I"), 8);
        grafo.agregarEnlace(dicCiudades.get("K"), dicCiudades.get("J"), 7);

        Ciudad origen = dicCiudades.get("A");
        Ciudad destino = dicCiudades.get("K");

        List<Ciudad> segundaRutaMinima = grafo.encontrarSegundaRutaMinima(origen, destino);
        if (segundaRutaMinima != null) {
            System.out.println("Segunda ruta mínima desde " + origen.getNombre() + " a " + destino.getNombre() + ":");
            for (Ciudad ciudad : segundaRutaMinima) {
                System.out.print(ciudad.getNombre() + " ");
            }
            System.out.println();
        } else {
            System.out.println("No existe segunda ruta mínima desde " + origen.getNombre() + " a " + destino.getNombre());
        }
    }
}




