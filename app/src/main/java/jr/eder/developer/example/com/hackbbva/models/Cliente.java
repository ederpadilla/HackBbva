package jr.eder.developer.example.com.hackbbva.models;

/**
 * Created by ederpadilla on 30/10/16.
 */

public class Cliente {
    private int estado;
    String id;

    public Cliente(int estado, String id) {
        this.estado = estado;
        this.id = id;
    }

    public Cliente() {
    }

    public Cliente(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "estado=" + estado +
                ", id='" + id + '\'' +
                '}';
    }
}
