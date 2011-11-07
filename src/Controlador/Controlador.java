package Controlador;

import Controlador.TipoEvento;
import Modelo.ObjetoAstronomicoEsferico;
import Modelo.SistemaPlanetario;
import Utils.Inicializador;
import Vista.VistaTexto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author nanohp
 */
public class Controlador {

    private VistaTexto vista;
    private SistemaPlanetario sPlanetario;

    public Controlador(VistaTexto vista, SistemaPlanetario sistemaPlanetario) {
        this.vista = vista;
        this.sPlanetario = sistemaPlanetario;
    }

    public void procesadorEvento(TipoEvento evento) {
        System.err.println("Evento:" + evento);
        String cadAux;

        switch (evento) {
            case MOSTRAR_SISTEMA_PLANETARIO:
                //System.out.println("Mostrando Sistema Planetario");
                vista.mostrarSistemaPlanetario(sPlanetario);
                break;

            case MOSTRAR_SISTEMA_PLANETARIO_RESUMEN:
                //System.out.println("Mostrando Sistema Planetario");
                vista.mostrarSistemaPlanetarioResumen(sPlanetario);
                break;
            case MOSTRAR_OBJETO_ASTRONOMICO_ESFERICO:
                //System.out.println("Mostrando cualquier tipo de objeto Esferico");
                String nombreObjeto = WordUtils.capitalizeFully(vista.getValor("Nombre del objeto"));
                ObjetoAstronomicoEsferico oAEsferico = sPlanetario.getObjetosEsfericos().get(nombreObjeto);
                if (oAEsferico != null) {
                    vista.mostrarOAEsferico(oAEsferico);
                } else {
                    vista.mostrarMensaje("'" + nombreObjeto + "' no encontrado en el sistema planetario '" + sPlanetario.getNombre() + "'");
                    //System.out.println("'" + nombreObjeto + "' no encontrado en el sistema planetario '" + sPlanetario.getNombre() + "'");
                }
                //(oAEsferico != null)?vista.mostrarOAEsferico(oAEsferico):vista.mostrarMensaje("'" + nombreObjeto + "' no encontrado en el sistema planetario '" + sPlanetario.getNombre() + "'");
                break;

            case BORRAR_OAE:
                cadAux = WordUtils.capitalizeFully(vista.getValor("Borrar OAE: Nombre del objeto"));

                if (sPlanetario.containsOAE(cadAux)) {
                    String opcion = WordUtils.capitalizeFully(vista.getValor(cadAux + ": Realmente desea borrarlo (S/N)"));
                    if (opcion.charAt(0) == 'S') {
                        
                        if(sPlanetario.borrarOAE(cadAux) != null)
                            vista.mostrarMensaje(cadAux+": Borrado correctamente");
                        else assert false:"Caso no controlado";
                    }
                } else {
                    vista.mostrarMensaje("'" + cadAux + "' no encontrado en el sistema planetario '" + sPlanetario.getNombre() + "'");
                }
                break;
            case MODELO_A_FICHERO_TEXTO:
                cadAux = vista.getValor("Nombre del fichero");
                sPlanetario.objetoAFicheroTexto(cadAux);
                break;
            case SERIALIZAR_MODELO:
                cadAux = vista.getValor("Nombre del fichero");
                sPlanetario.serializar(cadAux);
                break;
            case INICIALIZAR_MODELO_PRUEBA:
                sPlanetario.inicializa(Inicializador.inicializaSistemaPlanetario());
                break;

            case DESERIALIZAR_MODELO:
                cadAux = vista.getValor("Nombre del fichero");

                try {
                    sPlanetario.deserializar(cadAux);
                } catch (FileNotFoundException fnfEx) {
                    vista.mostrarMensaje("Fichero '" + cadAux + "' no encontrado");
                }

                break;
            case NUEVO_OAE:
                ObjetoAstronomicoEsferico oae = null;
                oae = vista.getOAE();
                sPlanetario.addObjetoEsferico(oae);
                break;
            case NUEVO_SP:
                cadAux = vista.getValor("Nombre del Sistema Planetario");
                sPlanetario.inicializa(cadAux);
                break;
            default:
                System.err.println("Controlador.procesadorEvento(): '" + evento + "' no controlado");
        }
    }
}
