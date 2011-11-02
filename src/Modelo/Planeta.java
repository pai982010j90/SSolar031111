package Modelo;

public class Planeta extends ObjetoAstronomicoEsferico {

    private double distanciaSol;

    public Planeta(String nombre, double masa, double diametro, double vRotacion, double distanciaSol) {
        super(nombre, masa, diametro, vRotacion);
        this.distanciaSol = distanciaSol;
    }

    public double getDistanciaSol() {
        return distanciaSol;
    }

    public void setDistanciaSol(double distanciaSol) {
        this.distanciaSol = distanciaSol;
    }
}
