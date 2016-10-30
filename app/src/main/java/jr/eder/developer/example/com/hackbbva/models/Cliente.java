package jr.eder.developer.example.com.hackbbva.models;

/**
 * Created by ederpadilla on 30/10/16.
 */

public class Cliente {

    private int estado;
    private String id;
    private float enojo;
    private float desprecio;
    private float neutral;
    private float felicidad;

    public Cliente(int estado, String id) {
        this.estado = estado;
        this.id = id;
    }

    public Cliente(int estado, String id, float enojo, float desprecio, float neutral, float felicidad) {
        this.estado = estado;
        this.id = id;
        this.enojo = enojo;
        this.desprecio = desprecio;
        this.neutral = neutral;
        this.felicidad = felicidad;
    }

    public Cliente() {
    }

    public float getEnojo() {
        return enojo;
    }

    public void setEnojo(float enojo) {
        this.enojo = enojo;
    }

    public float getDesprecio() {
        return desprecio;
    }

    public void setDesprecio(float desprecio) {
        this.desprecio = desprecio;
    }

    public float getNeutral() {
        return neutral;
    }

    public void setNeutral(float neutral) {
        this.neutral = neutral;
    }

    public float getFelicidad() {
        return felicidad;
    }

    public void setFelicidad(float felicidad) {
        this.felicidad = felicidad;
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
                ", enojo=" + enojo +
                ", desprecio=" + desprecio +
                ", neutral=" + neutral +
                ", felicidad=" + felicidad +
                '}';
    }
}
