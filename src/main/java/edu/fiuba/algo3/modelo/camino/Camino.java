package edu.fiuba.algo3.modelo.camino;

import edu.fiuba.algo3.modelo.celda.ICelda;

import java.util.List;

public class Camino {
    private List<ICelda> celdas;

    public Camino(List<ICelda> celdas) {
        this.celdas = celdas;
    }

    public List<ICelda> getCeldas() {
        return celdas;
    }

    public ICelda getCasilleroSalida() {
        return this.celdas.get(0);
    }

    public ICelda proximoEnNPosiciones(ICelda celdaActual, int posicionesCantidad) {
        // Encuentra la posición de la celda dada en la lista
        int posicionCelda = celdas.indexOf(celdaActual);

        // Calcula la posición de la celda resultante
        int posicionResultado = posicionCelda + posicionesCantidad;

        // Verifica si la posición calculada está dentro de los límites de la lista
//        if (posicionResultado >= 0 && posicionResultado < celdas.size()) {
        if (posicionResultado >= 0 && posicionResultado < celdas.size()) {
                // Devuelve la celda en la posición calculada
                return celdas.get(posicionResultado);
            } else {
                // Si la posición calculada está fuera de la lista, devuelve el último elemento
                return celdas.get(celdas.size() - 1);
            }
        }

    public ICelda anteriorEnNPosiciones(ICelda celdaActual, int posicionesCantidad) {
        // Encuentra la posición de la celda dada en la lista
        int posicionCelda = celdas.indexOf(celdaActual);

        // Calcula la posición de la celda resultante
        int posicionResultado = posicionCelda - posicionesCantidad;

        // Verifica si la posición calculada está dentro de los límites de la lista
        if (posicionResultado >= 0) {
            // Devuelve la celda en la posición calculada
            return celdas.get(posicionResultado);
        } else {
            // Si la posición calculada está fuera de la lista, devuelve el primer elemento
            return celdas.get(0);
        }
    }

    public ICelda getMitadDeCamino() {
        return celdas.get(celdas.size()/2);
    }
}
