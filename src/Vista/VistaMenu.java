package Vista;

import Controlador.TipoEvento;
import Modelo.MenuItem;
import Modelo.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nanohp
 */
public class VistaMenu {

    private Menu menu;
    private Map<Character, MenuItem> menuItems;

    public VistaMenu(Menu menu) {
        this.menu = menu;
        menuItems = menu.getMenuItems();
    }

    public void mostrarMenu() {
        System.out.println("M E N U");
        for (MenuItem mItem : menuItems.values()) {
            System.out.println(mItem);
        }
    }

    public void mostrarMenuOpciones() {
        System.out.print("(");
        for (Character opcion : menuItems.keySet()) {
            System.out.print(opcion);
        }
        System.out.print(")");
    }

    public TipoEvento selectorEvento() {
        String opcion = null;


        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        do {
            System.out.print("Seleccione opción: ");
            try {
                opcion = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (menuItems.containsKey(new Character(opcion.charAt(0))) == false);

        return menuItems.get(new Character(opcion.charAt(0))).getEvento();
    }
}
