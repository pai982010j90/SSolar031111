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
public class Menu {

    private Map<Character, MenuItem> menuItems;

    public Menu() {
        menuItems = new TreeMap<Character, MenuItem>();
    }

    public void add(MenuItem menuItem) {
        menuItems.put(new Character(menuItem.getOpcion()), menuItem);
    }

    public Map<Character, MenuItem> getMenuItems() {
        return menuItems;
    }
}