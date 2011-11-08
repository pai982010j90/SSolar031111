/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.MenuItemData;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;

/**
 *
 * @author nanohp
 */
public class JMenuItemPersonalizado extends JMenuItem {

    private MenuItemData mItem;

    public JMenuItemPersonalizado(MenuItemData mItem) {
        super(mItem.getEtiqueta());
        this.mItem = mItem;
    }

    public MenuItemData getmItem() {
        return mItem;
    }

    public JMenuItemPersonalizado(String text, int mnemonic) {
        super(text, mnemonic);
    }

    public JMenuItemPersonalizado(String text, Icon icon) {
        super(text, icon);
    }

    public JMenuItemPersonalizado(Action a) {
        super(a);
    }

    public JMenuItemPersonalizado(String text) {
        super(text);
    }

    public JMenuItemPersonalizado(Icon icon) {
        super(icon);
    }

    public JMenuItemPersonalizado() {
    }
}
