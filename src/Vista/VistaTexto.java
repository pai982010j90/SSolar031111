package Vista;

import Controlador.Controlador;
import Controlador.TipoEvento;
import Modelo.Menu;
import Modelo.MenuItem;
import Modelo.ObjetoAstronomicoEsferico;
import Modelo.SistemaPlanetario;

/**
 *
 * @author nanohp
 */
public class VistaTexto {

    private VistaMenu vistaMenu;
    private Controlador controlador;

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public VistaTexto() {
        Menu menu = new Menu();
        menu.add(new MenuItem('0', "Salir.", TipoEvento.SALIR));
        menu.add(new MenuItem('1', "Mostrar sistema planetario.", TipoEvento.MOSTRAR_SISTEMA_PLANETARIO));
        menu.add(new MenuItem('2', "Mostrar objeto astronómico esférico.", TipoEvento.MOSTRAR_OBJETO_ASTRONOMICO_ESFERICO));
        menu.add(new MenuItem('3', "Pasar el modelo actual a fichero de texto.", TipoEvento.MODELO_A_FICHERO_TEXTO));

        vistaMenu = new VistaMenu(menu);
    }

    public void arranca() {
        TipoEvento evento;
        do {
            vistaMenu.mostrarMenu();
            vistaMenu.mostrarMenuOpciones();
            evento = vistaMenu.selectorEvento();
            if (evento.equals(TipoEvento.SALIR)) {
                break;
            }
            controlador.procesadorEvento(evento);

        } while (true);
    }

    public void mostrarSistemaPlanetario(SistemaPlanetario sPlanetario) {
        VistaSistemaPlanetario vSPlanetario = new VistaSistemaPlanetario(sPlanetario);
        vSPlanetario.mostrar();
    }

    public void mostrarOAEsferico(ObjetoAstronomicoEsferico oAEsferico) {
        VistaObjetoAstronomicoEsferico vSPlanetario = new VistaObjetoAstronomicoEsferico(oAEsferico);
        vSPlanetario.mostrar();
    }

    public String getValor(String etiqueta) {
        DialogoPedirCampo pideEtiqueta = new DialogoPedirCampo(etiqueta);
        return pideEtiqueta.ejecuta();
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
