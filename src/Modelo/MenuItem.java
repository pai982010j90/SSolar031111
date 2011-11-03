package Modelo;

import Controlador.TipoEvento;

/**
 *
 * @author nanohp
 */
public class MenuItem {

    private char opcion;
    private String etiqueta;
    //private String evento;
    private TipoEvento evento;
    

    public String getEtiqueta() {
        return etiqueta;
    }

    public MenuItem(char opcion, String etiqueta) {
        this.opcion = opcion;
        this.etiqueta = etiqueta;
    }
    
    public MenuItem(char opcion, String etiqueta, TipoEvento evento) {
        this(opcion, etiqueta);
        this.evento = evento;
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



    @Override
    public String toString() {
        return opcion + ": " + etiqueta;
    }
}
