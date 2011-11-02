/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author nanohp
 */
public enum TipoEvento {

    SALIR("Salir"),
    MOSTRAR_SISTEMA_PLANETARIO("Mostrar sistema planetario"),
    MOSTRAR_OBJETO_ASTRONOMICO_ESFERICO("Mostrar objeto astronómico esférico"),
    MODELO_A_FICHERO_TEXTO("Pasar el modelo actual a fichero de texto");
    
    private String tipoEvento;

    private TipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }
}