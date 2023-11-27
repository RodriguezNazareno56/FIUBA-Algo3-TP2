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
}
