/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Modelo.MenuData;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author nanohp
 */
public interface VistaMenuI extends Observer {

    public void mostrarMenu(Object destino);

    public void setObservable(Observable observable);
    public void setControlador(Controlador controlador);
}
