/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Modelo.MenuData;
import Modelo.MenuItemData;
import Modelo.SistemaPlanetario;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author nanohp
 */
public class VistaMenuGrafico implements VistaMenuI, Observer {

    private Controlador controlador;
    private MenuData menuData;
    private JFrame f;
    private JMenuBar barraMenu;
    private JMenu menuPersonalizado;
    private Map<Character, MenuItemData> menuItems;

    public VistaMenuGrafico(MenuData menuData) {
        this.menuData = menuData;
        //menuItems = menuData.getMenuItems();
        barraMenu = new JMenuBar();
        menuPersonalizado = new JMenu(menuData.getNombreMenu());
    }

    @Override
    public void mostrarMenu(Object destino) {
        JMenuItemPersonalizado jMItemPersonalizado = null;

        for (MenuItemData mItem : menuData.getMenuItems().values()) {
            if (mItem.isVisible()) {
                jMItemPersonalizado = new JMenuItemPersonalizado(mItem);
                menuPersonalizado.add(jMItemPersonalizado);
                jMItemPersonalizado.addActionListener(controlador);
                //jMItemPersonalizado.setActionCommand(mItem.getEvento());
            }
        }
        barraMenu.add(menuPersonalizado);

        //System.err.println(destino.getClass().getName());
        if (destino.getClass().getName().equals("javax.swing.JFrame")) {
            ((JFrame) destino).setJMenuBar(barraMenu);
        }
        else assert false:"VistaMenuGrafico.mostrarMenu() -> Destino invalido";
    }

    public void setObservable(Observable observable) {
        observable.addObserver(this);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void update(Observable o, Object o1) {
        System.out.println("xxx:" + o + ", o2:" + o1);
        JMenuItemPersonalizado JMItemPersonal = null;
        if (o instanceof SistemaPlanetario) {
            for (MenuItemData mItem : menuData.getMenuItems().values()) {
                if (!mItem.isVisible()) {
                    mItem.isVisible(true);
                    JMItemPersonal = new JMenuItemPersonalizado(mItem);
                    menuPersonalizado.add(JMItemPersonal);
                    JMItemPersonal.addActionListener(controlador);
                }
            }
        }
    }
}
