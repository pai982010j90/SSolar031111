package Modelo;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author nanohp
 */
public class ObjetoAstronomicoEsferico {

    protected String nombre;
    protected double masa;
    protected double diametro;
    protected float velocidadRotacion;

    public ObjetoAstronomicoEsferico(String nombre, double masa, double diametro, float velocidadRotacion) {
        this.nombre = WordUtils.capitalize(nombre);
        this.masa = masa;
        this.diametro = diametro;
        this.velocidadRotacion = velocidadRotacion;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public void setVelocidadRotacion(float velocidadRotacion) {
        this.velocidadRotacion = velocidadRotacion;
    }

    public double getDiametro() {
        return diametro;
    }

    public double getMasa() {
        return masa;
    }

    public String getNombre() {
        return nombre;
    }

    public float getVelocidadRotacion() {
        return velocidadRotacion;
    }
}
