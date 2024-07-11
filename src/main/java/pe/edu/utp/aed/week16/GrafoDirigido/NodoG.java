package pe.edu.utp.aed.week16.GrafoDirigido;

import java.util.LinkedList;

public class NodoG {
    private Ciudad ciudad;
    LinkedList<Enlace> enlaces;

    public NodoG(Ciudad ciudad) {
        this.ciudad = ciudad;
        this.enlaces = new LinkedList<>();
    }

    public LinkedList<Enlace> getEnlaces() {
        return enlaces;
    }

    public void setEnlaces(LinkedList<Enlace> enlaces) {
        this.enlaces = enlaces;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
