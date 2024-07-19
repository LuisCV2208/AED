package pe.edu.utp.aed.week16.GrafoNoDirigido;

public class PruebaRecorridoGrafo {
    public static void main(String[] args) {

        String[] nodos = {"A", "B", "C", "D", "E"};

        GrafoNoDirigidoLista grafo = new GrafoNoDirigidoLista(nodos);
        grafo.agregarEnlace("A", "B");
        grafo.agregarEnlace("A", "C");
        grafo.agregarEnlace("B", "C");
        grafo.agregarEnlace("B", "D");
        grafo.agregarEnlace("B", "E");
        grafo.agregarEnlace("D", "E");

        grafo.recorridoPorAmplitud("A", "E");
        //grafo.recorridoEnProfundidad("A",);
    }
}
