package jr.eder.developer.example.com.hackbbva.models;

/**
 * Created by ederpadilla on 30/10/16.
 *
 models.add(new ArcProgressStackView.Model("Molestia", 70, Color.parseColor(bgColors[0]), mStartColors[3]));
 models.add(new ArcProgressStackView.Model("Desprecio", 23, Color.parseColor(bgColors[1]), mStartColors[2]));
 models.add(new ArcProgressStackView.Model("Disgusto", 34, Color.parseColor(bgColors[2]), mStartColors[1]));
 models.add(new ArcProgressStackView.Model("Neutral", 23, Color.parseColor(bgColors[3]), mStartColors[0]));
 */

public class Sospechosos {
    private int estado;
    private String id;
    private float enojo;
    private float desprecio;
    private float disgusto;
    private float neutral;

    public Sospechosos(int estado, String id) {
        this.estado = estado;
        this.id = id;
    }

    public Sospechosos(int estado, String id, float enojo, float desprecio, float disgusto, float neutral) {
        this.estado = estado;
        this.id = id;
        this.enojo = enojo;
        this.desprecio = desprecio;
        this.disgusto = disgusto;
        this.neutral = neutral;
    }

    public Sospechosos() {
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

    public float getDisgusto() {
        return disgusto;
    }

    public void setDisgusto(float disgusto) {
        this.disgusto = disgusto;
    }

    public float getNeutral() {
        return neutral;
    }

    public void setNeutral(float neutral) {
        this.neutral = neutral;
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
                ", enojo=" + enojo +
                ", desprecio=" + desprecio +
                ", disgusto=" + disgusto +
                ", neutral=" + neutral +
                '}';
    }
}
