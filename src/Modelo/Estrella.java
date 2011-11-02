package Modelo;

/**
 *
 * @author nanohp
 */
public class Estrella extends ObjetoAstronomicoEsferico {

    private double temperatura;

    public Estrella(String nombre, double masa, double diametro, float vRotacion, double temperatura) {
        super(nombre, masa, diametro, vRotacion);
        this.temperatura = temperatura;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}
