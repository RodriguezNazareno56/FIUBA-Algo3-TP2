package edu.fiuba.algo3.modelo.camino;

import edu.fiuba.algo3.modelo.celda.ICelda;

import java.util.List;
import java.util.Objects;

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
        // index de celdas en camino: 0 - celdas.size()-1
        // mitad de camino: (celdas.size()-1)/2
        return celdas.get((celdas.size()-1)/2);
    }

    @Override
    public String toString() {
        return "Camino{" +
                "celdas=" + celdas +
                '}';
    }

    public List<ICelda> getCeldas() {
        return this.celdas;
    }

    // Dos Caminos son iguales cuando tienen las mismas celdas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camino camino = (Camino) o;
        return Objects.equals(celdas, camino.celdas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(celdas);
    }
}
