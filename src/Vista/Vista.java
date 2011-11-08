/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Modelo.ObjetoAstronomicoEsferico;
import Modelo.SistemaPlanetario;
import java.util.Observable;

/**
 *
 * @author nanohp
 */
public interface Vista{

    void arranca();

    Controlador getControlador();

    ObjetoAstronomicoEsferico getOAE();

    String getValor(String etiqueta);

    void mostrarMensaje(String mensaje);

    void mostrarOAEsferico(ObjetoAstronomicoEsferico oAEsferico);

    void mostrarSistemaPlanetario(SistemaPlanetario sPlanetario);

    void mostrarSistemaPlanetarioResumen(SistemaPlanetario sPlanetario);

    void setControlador(Controlador controlador);
    void setModelo(Observable observable);
    
}
