package edu.fiuba.algo3.modelo.celda;

import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;

import java.util.List;

public class CeldaSalida implements ICelda {
    // Esto deberia de ser otra entidad (coordenadas por ejemplo)
    private int x;
    private int y;
    private List<Consecuencia> consecuencias;

    public CeldaSalida(int x, int y, List<Consecuencia> consecuencias) {
        this.x = x;
        this.y = y;
        this.consecuencias = consecuencias;
    }
}
