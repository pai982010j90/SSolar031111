package Modelo;

import java.io.Serializable;

public class Planeta extends ObjetoAstronomicoEsferico implements Serializable{

    private double distanciaSol;

    public Planeta(String nombre, double masa, double diametro, float vRotacion, double distanciaSol) {
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
