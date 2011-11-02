package Modelo;

import Modelo.Planeta;
import java.io.Serializable;
import java.util.ArrayList;
//import java.util.HashSet; Se utiliza con HashSet
import java.util.HashMap;
import java.util.Map;

public class SistemaPlanetario {

    private String nombre;
    private Map<String, ObjetoAstronomicoEsferico> objetosEsfericos;

    public SistemaPlanetario(String nombre) {
        this.nombre = nombre;   
        objetosEsfericos = new HashMap<String, ObjetoAstronomicoEsferico>();
    }

    public void addObjetoEsferico(ObjetoAstronomicoEsferico oEsferico) {
        objetosEsfericos.put(oEsferico.getNombre(), oEsferico);
    }

    public Map<String, ObjetoAstronomicoEsferico> getObjetosEsfericos() {
        return objetosEsfericos;
    }

    public String getNombre() {
        return nombre;
    }
}
