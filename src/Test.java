
import Controlador.Controlador;
import Modelo.Menu;
import Modelo.MenuItem;
import Modelo.SistemaPlanetario;
import Utils.Inicializador;
import Vista.VistaMenu;
import Vista.VistaTexto;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nanohp
 */
public class Test {
    public static void main(String[] args){
        
        SistemaPlanetario sistemaSolar = new SistemaPlanetario();
        //SistemaPlanetario sistemaSolar = Inicializador.inicializaSistemaPlanetario();
        VistaTexto vistaTexto = new VistaTexto(Inicializador.inicializaMenu(sistemaSolar));
        
        Controlador controlador = new Controlador(vistaTexto, sistemaSolar);
        vistaTexto.setControlador(controlador);
        
        vistaTexto.arranca();
        
    }
            
}
