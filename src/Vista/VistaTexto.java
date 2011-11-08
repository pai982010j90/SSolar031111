package Vista;

import Controlador.Controlador;
import Controlador.TipoEvento;
import Modelo.Estrella;
import Modelo.MenuData;
import Modelo.ObjetoAstronomicoEsferico;
import Modelo.Planeta;
import Modelo.SistemaPlanetario;
import java.awt.event.ActionEvent;
import java.util.Observable;

/**
 *
 * @author nanohp
 */
public class VistaTexto implements Vista {

    private VistaMenuTexto vistaMenu;
    private Controlador controlador;

    public VistaTexto(MenuData menuData) {
        this.vistaMenu = new VistaMenuTexto(menuData);
    }

    @Override
    public void arranca() {
        TipoEvento evento;
        do {
            vistaMenu.mostrarMenu(System.out);
            vistaMenu.mostrarMenuOpciones(System.out);
            evento = vistaMenu.selectorEvento();
            if (evento.equals(TipoEvento.SALIR)) {
                break;
            }

            //PROVISIONAL
            controlador.actionPerformed(new ActionEvent(evento, 1, "Salir"));

        } while (true);
    }

    // Getters / Setters
    @Override
    public Controlador getControlador() {
        return controlador;
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void setModelo(Observable observable) {
        vistaMenu.setObservable(observable);
    }

    @Override
    public void mostrarSistemaPlanetario(SistemaPlanetario sPlanetario) {
        VistaSistemaPlanetario vSPlanetario = new VistaSistemaPlanetario(sPlanetario);
        vSPlanetario.mostrar();
    }

    @Override
    public void mostrarSistemaPlanetarioResumen(SistemaPlanetario sPlanetario) {
        VistaSistemaPlanetario vSPlanetario = new VistaSistemaPlanetario(sPlanetario);
        vSPlanetario.mostrarResumen();
    }

    @Override
    public void mostrarOAEsferico(ObjetoAstronomicoEsferico oAEsferico) {
        VistaObjetoAstronomicoEsferico vSPlanetario = new VistaObjetoAstronomicoEsferico(oAEsferico);
        vSPlanetario.mostrar();
    }

    @Override
    public String getValor(String etiqueta) {
        DialogoPedirCampo pideEtiqueta = new DialogoPedirCampo(etiqueta);
        return pideEtiqueta.ejecuta();
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public ObjetoAstronomicoEsferico getOAE() {

        DialogoPedirCampo dialogoPC = new DialogoPedirCampo();
        ObjetoAstronomicoEsferico oae = null;
        try {
            String nombre = dialogoPC.ejecuta("Nombre");
            double masa = Double.parseDouble(dialogoPC.ejecuta("Masa"));
            double diametro = Double.parseDouble(dialogoPC.ejecuta("Diametro"));
            float vRotacion = Float.parseFloat(dialogoPC.ejecuta("Velocidad rotación"));
            String opcion = null;
            boolean cerrado;
            do {
                opcion = dialogoPC.ejecuta("(E)strella / (P)laneta");
                double aux;
                switch (opcion.charAt(0)) {
                    case 'P':
                    case 'p':
                        aux = Double.parseDouble(dialogoPC.ejecuta("Dist estrella"));
                        oae = new Planeta(nombre, masa, diametro, vRotacion, aux);
                        cerrado = false;
                        break;
                    case 'E':
                    case 'e':
                        aux = Double.parseDouble(dialogoPC.ejecuta("Temp"));
                        oae = new Estrella(nombre, masa, diametro, vRotacion, aux);
                        cerrado = false;
                        break;
                    default:
                        mostrarMensaje("Tipo OAE desconocido");
                        cerrado = true;
                }
            } while (cerrado);


        } catch (NumberFormatException nFE) {
            mostrarMensaje("Fallo en la lectura de datos");
        }
        return oae;
    }
}
