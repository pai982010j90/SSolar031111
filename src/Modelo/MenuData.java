package Modelo;

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
public class MenuData {

    private String nombreMenu;
    private Map<Character, MenuItemData> menuItems;
    private SistemaPlanetario sPlanetario;

    public MenuData(String nombreMenu) {
        this.nombreMenu = nombreMenu;
        menuItems = new TreeMap<Character, MenuItemData>();
    }

    public void add(MenuItemData menuItem) {
        menuItems.put(new Character(menuItem.getOpcion()), menuItem);
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public Map<Character, MenuItemData> getMenuItems() {
        return menuItems;
    }
}