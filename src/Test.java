
import Controlador.Controlador;
import Modelo.MenuData;
import Modelo.MenuItemData;
import Modelo.SistemaPlanetario;
import Utils.Inicializador;
import Vista.Vista;
import Vista.VistaGrafica;
import Vista.VistaMenuGrafico;
import Vista.VistaMenuTexto;
import Vista.VistaTexto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nanohp
 */
public class Test {

    public static void main(String[] args) {

        // Inicialización del modelo
        SistemaPlanetario sPlanetario = new SistemaPlanetario();

        // Inicialización de la vista
        Vista vista = (seleccionTipoVista() == 'T')
                ? new VistaTexto(Inicializador.inicializaMenu())
                : new VistaGrafica(Inicializador.inicializaMenu());



        // Inicialización del controlador
        Controlador controlador = new Controlador(vista, sPlanetario);

        // Enlazamos la vista con el controlador
        vista.setControlador(controlador);
        // Como la vista implementa el mecanismo 'Observer' necesita conocer al modelo para registrarse como oberver en este
        vista.setModelo(sPlanetario);

        // Ponemos en marcha la vista
        vista.arranca();

    }

    private static char seleccionTipoVista() {
        String opcionStr = null;
        char opcion;

        System.err.println("Seleccion tipo vista: (T)exto / (G)rafico");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            do {
                opcionStr = br.readLine();
            } while (!opcionStr.equalsIgnoreCase("T") && !opcionStr.equalsIgnoreCase("G"));
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }


        return opcionStr.charAt(0);

    }
}
