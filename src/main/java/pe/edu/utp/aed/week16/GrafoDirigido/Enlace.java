package pe.edu.utp.aed.week16.GrafoDirigido;

public class Enlace {
    private NodoG destino;
    private double costo;

    public NodoG getDestino() {
        return destino;
    }

    public void setDestino(NodoG destino) {
        this.destino = destino;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Enlace(NodoG destino, double costo) {
        this.destino = destino;
        this.costo = costo;
    }
}
