/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Controlador.TipoEvento;
import Modelo.Estrella;
import Modelo.MenuData;
import Modelo.MenuItemData;
import Modelo.Planeta;
import Modelo.SistemaPlanetario;
import Vista.VistaMenuTexto;

/**
 *
 * @author nanohp
 */
public class Inicializador {

    public static SistemaPlanetario inicializaSistemaPlanetario() {

        SistemaPlanetario sPlanetario = new SistemaPlanetario();
        sPlanetario.inicializa("Sistema Solar");

        sPlanetario.addObjetoEsferico(new Estrella("Sol", 1.9891E30, 1392000, 27, 6E3));

        Planeta mercurio = new Planeta("Mercurio", 3.302E23, 4878, 1, 57909175);
        sPlanetario.addObjetoEsferico(mercurio);
        sPlanetario.addObjetoEsferico(new Planeta("Venus", 4.8690E24, 12102, 1, 108208930));
        Planeta tierra = new Planeta("Tierra", 5.9742E24, 12756, 1, 149597870);
        sPlanetario.addObjetoEsferico(tierra);
        Planeta marte = new Planeta("Marte", 6.4191E23, 6794, 1, 227936640);
        sPlanetario.addObjetoEsferico(marte);
        Planeta jupiter = new Planeta("Jupiter", 1.8987E27, 142984, 1, 778412010);
        sPlanetario.addObjetoEsferico(jupiter);
        Planeta saturno = new Planeta("Saturno", 5.6851E26, 120534, 1, 1426725400);
        sPlanetario.addObjetoEsferico(saturno);
        Planeta urano = new Planeta("Urano", 8.6849E25, 51114, 1, 2.8709E6);
        sPlanetario.addObjetoEsferico(urano);
        Planeta neptuno = new Planeta("Neptuno", 1.0244E26, 49532, 1, 4.4982E6);
        sPlanetario.addObjetoEsferico(neptuno);

        return sPlanetario;
    }

    public static MenuData inicializaMenu() {
        MenuData menu = new MenuData("Principal");
        menu.add(new MenuItemData('X', "Salir.", TipoEvento.SALIR));
        menu.add(new MenuItemData('I', "Inicializar datos de prueba (desde el propio software).", TipoEvento.INICIALIZAR_MODELO_PRUEBA));
        menu.add(new MenuItemData('D', "Deserializar modelo desde fichero.", TipoEvento.DESERIALIZAR_MODELO));
        menu.add(new MenuItemData('S', "Serializar modelo a fichero.", TipoEvento.SERIALIZAR_MODELO, false));
        menu.add(new MenuItemData('T', "Pasar el modelo actual a fichero de texto.", TipoEvento.MODELO_A_FICHERO_TEXTO, false));
        menu.add(new MenuItemData('@', "Crear nuevo Sistema Planetario.", TipoEvento.NUEVO_SP));
        menu.add(new MenuItemData('1', "Mostrar sistema planetario.", TipoEvento.MOSTRAR_SISTEMA_PLANETARIO, false));
        menu.add(new MenuItemData('2', "Mostrar sistema planetario - resumen.", TipoEvento.MOSTRAR_SISTEMA_PLANETARIO_RESUMEN, false));
        menu.add(new MenuItemData('3', "Mostrar objeto astronómico esférico.", TipoEvento.MOSTRAR_OBJETO_ASTRONOMICO_ESFERICO, false));
        menu.add(new MenuItemData('4', "Crear nuevo OAE.", TipoEvento.NUEVO_OAE, false));
        menu.add(new MenuItemData('5', "Borrar OAE.", TipoEvento.BORRAR_OAE, false));

        return menu;
    }
}
