package Modelo;

import Modelo.Planeta;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//import java.util.HashSet; Se utiliza con HashSet
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaPlanetario extends Observable implements Serializable, Persistencia {

    private String nombre;
    private Map<String, ObjetoAstronomicoEsferico> objetosEsfericos;

    public SistemaPlanetario() {
        objetosEsfericos = new HashMap<String, ObjetoAstronomicoEsferico>();
    }

    public void inicializa(String nombre) {
        this.nombre = nombre;
        setChanged();
        notifyObservers();
    }

    public void inicializa(SistemaPlanetario sPlanetarioAux) {
        nombre = sPlanetarioAux.getNombre();
        setObjetosEsfericos(sPlanetarioAux.getObjetosEsfericos());
        setChanged();
        notifyObservers();
    }

    public void addObjetoEsferico(ObjetoAstronomicoEsferico oEsferico) {
        objetosEsfericos.put(oEsferico.getNombre(), oEsferico);
        setChanged();
        notifyObservers();
    }

    public Map<String, ObjetoAstronomicoEsferico> getObjetosEsfericos() {
        return objetosEsfericos;
    }

    private void setObjetosEsfericos(Map<String, ObjetoAstronomicoEsferico> o) {
        objetosEsfericos = o;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void objetoAFicheroTexto(String nombreFichero) {
        try {
            FileWriter fw = new FileWriter(nombreFichero);
            fw.write("Nombre del sistema planetario:" + this.getNombre() + "\n");
            for (ObjetoAstronomicoEsferico o : this.getObjetosEsfericos().values()) {
                fw.write("Objeto:" + o.getNombre() + " es un " + o.getClass().getSimpleName() + "\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(SistemaPlanetario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void serializar(String nombreFichero) {
        try {
            FileOutputStream fos = new FileOutputStream(nombreFichero);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            //setChanged();
            //notifyObservers();
        } catch (IOException ex) {
            Logger.getLogger(SistemaPlanetario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deserializar(String nombreFichero) throws FileNotFoundException {
        //SistemaPlanetario sPlanetario = null;
        SistemaPlanetario sPlanetarioAux = null;

        try {
            FileInputStream fis = new FileInputStream(nombreFichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            sPlanetarioAux = (SistemaPlanetario) ois.readObject();
            setChanged();
            notifyObservers();
            ois.close();
            inicializa(sPlanetarioAux);
        } catch (ClassNotFoundException cNFException) {
            Logger.getLogger(SistemaPlanetario.class.getName()).log(Level.SEVERE, null, cNFException);
        } catch (FileNotFoundException fnfEx) {
            //Logger.getLogger(SistemaPlanetario.class.getName()).log(Level.SEVERE, null, fnfEx);
            throw fnfEx;
        } catch (IOException ex) {
            Logger.getLogger(SistemaPlanetario.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
