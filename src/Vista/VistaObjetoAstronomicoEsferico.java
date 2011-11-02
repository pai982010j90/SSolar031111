/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Estrella;
import Modelo.ObjetoAstronomicoEsferico;
import Modelo.Planeta;

/**
 *
 * @author nanohp
 */
public class VistaObjetoAstronomicoEsferico {

    /**
     * 
     */
    private ObjetoAstronomicoEsferico oAstronomicoEsferico;

    public VistaObjetoAstronomicoEsferico(ObjetoAstronomicoEsferico oAEsferico) {
        this.oAstronomicoEsferico = oAEsferico;
    }

    public void mostrar() {
        String tipoObjeto = oAstronomicoEsferico.getClass().getName();
        
        System.out.print("** ("+tipoObjeto+") Nombre: '" + oAstronomicoEsferico.getNombre()+"'");
        System.out.print("- Diametro: " + oAstronomicoEsferico.getDiametro()+" km.");
        System.out.print("- Masa: " + oAstronomicoEsferico.getMasa());
        System.out.print("- V Rotacion: " + oAstronomicoEsferico.getVelocidadRotacion()+" dias");

        if (tipoObjeto.equals("Modelo.Estrella")) {
            System.out.print(", Temp: " + ((Estrella) oAstronomicoEsferico).getTemperatura()+"º");
        }
        if (tipoObjeto.equals("Modelo.Planeta")) {
            System.out.print(", Dist Sol: " + ((Planeta) oAstronomicoEsferico).getDistanciaSol()+" km.");
        }
        System.out.println();
    }
}
