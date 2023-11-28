package edu.fiuba.algo3.modelo.camino;

import edu.fiuba.algo3.modelo.celda.ICelda;

import java.util.List;

public class Camino {
    private List<ICelda> celdas;

    public Camino(List<ICelda> celdas) {
        this.celdas = celdas;
    }

    public ICelda getCeldaSalida() {
        return this.celdas.get(0);
    }

    public ICelda proximoEnNPosiciones(ICelda celdaActual, int posicionesCantidad) {
        // Calcula la posición de la celda resultante
        int posicionResultado = celdas.indexOf(celdaActual) + posicionesCantidad;

        // Verifica si la posición calculada está dentro de los límites de la lista
        if (posicionResultado >= 0 && posicionResultado < celdas.size()) {
            return celdas.get(posicionResultado);
        } else {
            // Si la posicion calculada execede la lista de celdas entonces retorno la ultima celda
            return celdas.get(celdas.size() - 1);
        }
    }

    public ICelda anteriorEnNPosiciones(ICelda celdaActual, int posicionesCantidad) {
        // Calcula la posición de la celda resultante
        int posicionResultado = celdas.indexOf(celdaActual) - posicionesCantidad;

        // Verifica si la posición calculada está dentro de los límites de la lista
        if (posicionResultado >= 0) {
            return celdas.get(posicionResultado);
        } else {
            // Si la posicion calculada es menor a 0 entonces retorno la primer celda
            return celdas.get(0);
        }
    }

    public ICelda getMitadDeCamino() {
        return celdas.get(celdas.size()/2);
    }

    @Override
    public String toString() {
        return "Camino{" +
                "celdas=" + celdas +
                '}';
    }

    // TODO: con motivo de testear
    public List<ICelda> getCeldas() {
        return this.celdas;
    }
}
