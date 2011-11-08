package Vista;

import Controlador.Controlador;
import Controlador.TipoEvento;
import Modelo.MenuItemData;
import Modelo.MenuData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nanohp
 */
public class VistaMenuTexto implements VistaMenuI, Observer {

    private MenuData menu;

    private Map<Character, MenuItemData> menuItems;

    public VistaMenuTexto(MenuData menu) {
        this.menu = menu;
        menuItems = menu.getMenuItems();
    }

    @Override
    public void mostrarMenu(Object destino) {
        
        PrintStream pS = (PrintStream) destino;
        pS.println("\nM E N U");
        for (MenuItemData mItem : menuItems.values()) {
            if (mItem.isVisible()) {
                pS.println(mItem);
            }
        }
    }

    public void mostrarMenuOpciones(Object destino) {
        PrintStream pS = (PrintStream) destino;
        pS.print("(");
        for (Character opcion : menuItems.keySet()) {
            if (menuItems.get(opcion).isVisible()) {
                pS.print(opcion);
            }
        }
        pS.print(")");
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
                Logger.getLogger(MenuData.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (menuItems.containsKey(cOpcion) == false || !(menuItems.get(cOpcion).isVisible()));

        return menuItems.get(new Character(opcion.charAt(0))).getEvento();
    }

    @Override
    public void update(Observable o, Object o1) {
        for (MenuItemData mItem : menuItems.values()) {
            if (!mItem.isVisible()) {
                mItem.isVisible(true);
            }
        }
    }

    @Override
    public void setObservable(Observable observable) {
        // Fijo el propio menu como observer
        observable.addObserver(this);
    }

    @Override
    public void setControlador(Controlador controlador) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
