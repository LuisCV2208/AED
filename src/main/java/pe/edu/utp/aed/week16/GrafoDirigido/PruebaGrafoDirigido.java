package pe.edu.utp.aed.week16.GrafoDirigido;

import java.util.HashMap;
import java.util.List;

//NUEVO
public class PruebaGrafoDirigido {
    public static void main(String[] args) {
        String[] nombresCiudades = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};

        HashMap<String, Ciudad> dicCiudades = new HashMap<>();

        for (String nombre : nombresCiudades) {
            dicCiudades.put(nombre, new Ciudad(nombre));
        }

        GrafoDirigido grafo = new GrafoDirigido(dicCiudades.values());
        grafo.agregarEnlace(dicCiudades.get("A"), dicCiudades.get("D"), 13);
        grafo.agregarEnlace(dicCiudades.get("A"), dicCiudades.get("G"), 2);
        grafo.agregarEnlace(dicCiudades.get("B"), dicCiudades.get("A"), 1);
        grafo.agregarEnlace(dicCiudades.get("C"), dicCiudades.get("B"), 2);
        grafo.agregarEnlace(dicCiudades.get("C"), dicCiudades.get("E"), 30);
        grafo.agregarEnlace(dicCiudades.get("C"), dicCiudades.get("A"), 25);
        grafo.agregarEnlace(dicCiudades.get("E"), dicCiudades.get("B"), 5);
        grafo.agregarEnlace(dicCiudades.get("E"), dicCiudades.get("H"), 14);
        grafo.agregarEnlace(dicCiudades.get("E"), dicCiudades.get("F"), 4);
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

        List<List<Ciudad>> rutas = grafo.encontrarRutas(dicCiudades.get("A"), dicCiudades.get("K"));
        System.out.println("TODAS LAS RUTAS");
        for (List<Ciudad> ruta : rutas) {
            for (Ciudad ciudad : ruta) {
                System.out.print(ciudad.getNombre() + " ");
            }
            System.out.println();
        }

        List<Ciudad> rutaMenorCosto = grafo.rutaMenorCosto(dicCiudades.get("A"), dicCiudades.get("K"));
        System.out.println("Ruta de menor costo es :");
        for (Ciudad ciudad : rutaMenorCosto) {
            System.out.print(ciudad.getNombre() + " ");
        }
    }
}




