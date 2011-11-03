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
        System.out.println("\nM E N U");
        for (MenuItem mItem : menuItems.values()) {
            if(mItem.isVisible())System.out.println(mItem);
        }
    }

    public void mostrarMenuOpciones() {
        System.out.print("(");
        for (Character opcion : menuItems.keySet()) {
            if(menuItems.get(opcion).isVisible())System.out.print(opcion);
        }
        System.out.print(")");
    }

    public TipoEvento selectorEvento() {
        String opcion = null;
        Character cOpcion = null;


        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        do {
            System.out.print("Seleccione opción: ");
            try {
                opcion = br.readLine();
                cOpcion = new Character(opcion.charAt(0));
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (menuItems.containsKey(cOpcion) == false || !(menuItems.get(cOpcion).isVisible()));

        return menuItems.get(new Character(opcion.charAt(0))).getEvento();
    }
}
