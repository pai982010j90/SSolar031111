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
    MODELO_A_FICHERO_TEXTO("Pasar el modelo actual a fichero de texto"),
    MOSTRAR_SISTEMA_PLANETARIO_RESUMEN("Mostrar sistema planetario (resumen)"),
    SERIALIZAR_MODELO("Grabar modelo a fichero binario"),
    DESERIALIZAR_MODELO("Rescatar modelo desde fichero binario"),
    INICIALIZAR_MODELO_PRUEBA("Carga de datos de prueba desde memoria"),
    NUEVO_OAE("Dar de alta un nuevo Objeto Astronomico Esferico"),
    NUEVO_SP("Dar de alta un nuevo Sistema Planetario"),
    BORRAR_OAE("Dar de baja un OAE");
    
    private String tipoEvento;

    private TipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }
}