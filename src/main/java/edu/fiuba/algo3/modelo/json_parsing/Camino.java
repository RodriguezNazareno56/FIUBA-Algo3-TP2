package edu.fiuba.algo3.modelo.json_parsing;

import java.util.Arrays;
import java.util.List;

public class Camino {
    private List<Celda> celdas;

    public Camino() {
    }

    public List<Celda> getCeldas() {
        return celdas;
    }

    public void setCeldas(List<Celda> celdas) {
        this.celdas = celdas;
    }

    @Override
    public String toString() {
        return "Camino{" +
                "celdas=" + Arrays.toString(getCeldas().toArray()) +
                '}';
    }
}
