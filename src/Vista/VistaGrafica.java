/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Modelo.MenuData;
import Modelo.MenuItemData;
import Modelo.ObjetoAstronomicoEsferico;
import Modelo.SistemaPlanetario;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author nanohp
 */
public class VistaGrafica implements Vista {

    private VistaMenuGrafico vistaMenu;
    private Controlador controlador;
    private Observable modelo;
    private JFrame f;
    private JMenuBar barraMenu;
    private JMenu menu1;

    public VistaGrafica(MenuData menu) {
        this.vistaMenu = new VistaMenuGrafico(menu);

        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setModelo(Observable observable) {
        this.modelo = observable;
    }

    public VistaMenuI getVistaMenu() {
        return vistaMenu;
    }

    public void setVistaMenu(VistaMenuI vistaMenu) {
        this.vistaMenu = (VistaMenuGrafico) vistaMenu;
    }

    @Override
    public void arranca() {
        vistaMenu.setControlador(controlador);
        vistaMenu.setObservable(modelo);

        vistaMenu.mostrarMenu(f);
        f.setSize(400, 200);
        f.setVisible(true);
    }

    @Override
    public Controlador getControlador() {
        return controlador;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public ObjetoAstronomicoEsferico getOAE() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getValor(String etiqueta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mostrarOAEsferico(ObjetoAstronomicoEsferico oAEsferico) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mostrarSistemaPlanetario(SistemaPlanetario sPlanetario) {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Nombre: " + sPlanetario.getNombre());
        for (ObjetoAstronomicoEsferico oae : sPlanetario.getObjetosEsfericos().values()) {
            root.add(new DefaultMutableTreeNode(oae.getNombre()));
        }
        JTree st = new JTree(root);
        f.add(st);
        f.setVisible(true);
    }

    @Override
    public void mostrarSistemaPlanetarioResumen(SistemaPlanetario sPlanetario) {
        JTextField jTF = new JTextField(sPlanetario.getNombre());
        f.add(jTF);
        //f.pack();

        f.setVisible(true);
    }
}
