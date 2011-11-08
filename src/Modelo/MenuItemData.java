package Modelo;

import Controlador.TipoEvento;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author nanohp
 */
public class MenuItemData {

    private char opcion;
    private String etiqueta;
    //private String evento;
    private TipoEvento evento;
    private boolean isVisible = true;

    public MenuItemData(char opcion, String etiqueta) {
        this.opcion = opcion;
        this.etiqueta = etiqueta;
    }

    public MenuItemData(char opcion, String etiqueta, TipoEvento evento) {
        this(opcion, etiqueta);
        this.evento = evento;
    }

    public MenuItemData(char opcion, String etiqueta, TipoEvento evento, boolean isVisible) {
        this(opcion, etiqueta, evento);
        this.isVisible = isVisible;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public char getOpcion() {
        return opcion;
    }

    public TipoEvento getEvento() {
        return evento;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void isVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public String toString() {
        return opcion + ": " + etiqueta;
    }
}