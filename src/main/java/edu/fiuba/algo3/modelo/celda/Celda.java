package edu.fiuba.algo3.modelo.celda;

import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;

import java.util.List;

public class Celda implements ICelda {
    protected int x;
    protected int y;
    protected List<Consecuencia> consecuencias;

    @Override
    public String toString() {
        return "Instancia de Celda{" +
                "x=" + x +
                ", y=" + y +
                ", consecuencias=" + consecuencias.toString() +
                '}';
    }
}
