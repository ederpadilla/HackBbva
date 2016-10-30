package jr.eder.developer.example.com.hackbbva.models;

/**
 * Created by ederpadilla on 30/10/16.
 */

public class Sospechosos {
    private int estado;
    String id;

    public Sospechosos(int estado, String id) {
        this.estado = estado;
        this.id = id;
    }

    public Sospechosos() {
    }

    public Sospechosos(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Sospechosos{" +
                "estado=" + estado +
                ", id='" + id + '\'' +
                '}';
    }
}
