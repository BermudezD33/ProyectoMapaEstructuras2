package estructuras.mapa;

import java.util.Arrays;
import java.util.List;

public class TablaHash {

    private NodoHash tablaHash[] = new NodoHash[1000];

    public TablaHash() {
        for (int i = 0; i < 1000; i++) {
            tablaHash[i] = null;
        }
    }

    void addValor(int indice, NodoHash ptr) {
        if (tablaHash[indice] == null) {
            tablaHash[indice] = ptr;
        } else {
            NodoHash aux = tablaHash[indice];
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(ptr);
        }
    }

    NodoHash getNumero(int indice, String nombre) {
        NodoHash aux = tablaHash[indice];
        while (aux != null && !aux.getNombreLocalizacion().equals(nombre))
            aux = aux.getSig();
        return aux;
    }

    NodoHash getNumeroConId(int id) {
        NodoHash aux = null;
        for (int i = 1; i < tablaHash.length; i++) {
            if (tablaHash[i] != null) {
                if(tablaHash[i].getId() == id) {
                    return aux = tablaHash[i];
                }
            }
        }

        return aux;
    }

    List<NodoHash> getNodos() {
        return Arrays.asList(tablaHash);
    }

    /////////////////////////HASHING///////////////////////////////
    int hashing(String nombre) {
        System.out.println("Nombre: " + nombre);
        int num = 0;
        byte[] bytes = nombre.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            num += b;

        }
        return (int) (num % (1000));
    }


}

