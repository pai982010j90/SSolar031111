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

    public VistaTexto(VistaMenu vistaMenu) {
        this.vistaMenu = vistaMenu;
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

    public void mostrarSistemaPlanetarioResumen(SistemaPlanetario sPlanetario) {
        VistaSistemaPlanetario vSPlanetario = new VistaSistemaPlanetario(sPlanetario);
        vSPlanetario.mostrarResumen();
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
