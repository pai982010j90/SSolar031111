/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileNotFoundException;

/**
 *
 * @author nanohp
 */
public interface Persistencia {
    public void objetoAFicheroTexto(String nombreFichero);
    public void serializar(String nombreFichero);
    public void deserializar(String nombreFichero) throws FileNotFoundException;
}
