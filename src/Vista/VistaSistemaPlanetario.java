/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.ObjetoAstronomicoEsferico;
import Modelo.SistemaPlanetario;

/**
 *
 * @author nanohp
 */
public class VistaSistemaPlanetario {

    SistemaPlanetario sPlanetario;
    
    public VistaSistemaPlanetario(SistemaPlanetario sPlanetario) {
        this.sPlanetario = sPlanetario;
    }
    
    public void mostrar() {
        System.out.println("Sistema Planetario.");
        System.out.println("* Nombre:" + sPlanetario.getNombre());
        for (ObjetoAstronomicoEsferico oAEsferico : sPlanetario.getObjetosEsfericos().values()) {
            new VistaObjetoAstronomicoEsferico(oAEsferico).mostrar();
            System.out.println();
        }

    }
}
