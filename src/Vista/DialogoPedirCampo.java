/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nanohp
 */
public class DialogoPedirCampo {

    public String etiqueta;

    public DialogoPedirCampo(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String ejecuta() {
        String valor = null;
        System.out.print(etiqueta + ": ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            try {
                valor = br.readLine();
            } finally {
                //br.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(DialogoPedirCampo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return valor;
    }
}
