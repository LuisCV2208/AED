package pe.edu.utp.aed.week16.GrafoDirigido;

public class Ciudad implements Comparable<Ciudad> {
    private String nombre;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Ciudad o) {
        return this.nombre.compareTo(o.getNombre());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ciudad) {
            return this.nombre.equals(((Ciudad) obj).getNombre());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}


