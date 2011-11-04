package Vista;

import Controlador.Controlador;
import Controlador.TipoEvento;
import Modelo.Estrella;
import Modelo.Menu;
import Modelo.MenuItem;
import Modelo.ObjetoAstronomicoEsferico;
import Modelo.Planeta;
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
