package edu.fiuba.algo3.modelo.celda;

import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.TriunfoException;

import java.util.ArrayList;
import java.util.List;

public class Celda implements ICelda {
    protected int x;
    protected int y;
    protected List<Consecuencia> consecuencias;

    public Celda() {
        consecuencias = new ArrayList<>();
    }

    public Celda(int x) {
        this.x = x;
    }

    public Celda(List<Consecuencia> consecuencias) {
        this.consecuencias = consecuencias;
        this.x = 10;
    }

    @Override
    public String toString() {
        return "Instancia de Celda{" +
                "x=" + x +
                ", y=" + y +
                ", consecuencias=" + consecuencias.toString() +
                '}';
    }

    @Override
    public void afectarGladiadorConConsecuencia(Gladiador gladiador) throws TriunfoException {
        for (Consecuencia consecuencia : consecuencias) {
            consecuencia.afectarGladiador(gladiador);
        }
    }
}
