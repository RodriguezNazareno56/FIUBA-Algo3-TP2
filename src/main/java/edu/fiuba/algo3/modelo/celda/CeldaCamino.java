package edu.fiuba.algo3.modelo.celda;

import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;

import java.util.List;

public class CeldaCamino extends Celda {

    public CeldaCamino(int x, int y, List<Consecuencia> consecuencias) {
        this.x = x;
        this.y = y;
        this.consecuencias = consecuencias;
    }
}
