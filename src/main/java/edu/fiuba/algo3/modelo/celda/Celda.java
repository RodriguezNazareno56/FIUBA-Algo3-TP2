package edu.fiuba.algo3.modelo.celda;

import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.TriunfoException;

import java.util.ArrayList;
import java.util.List;

public class Celda implements ICelda {

    private Coordenada coordenada;
    private List<Consecuencia> consecuencias;

    public Celda(Coordenada coordenada, List<Consecuencia> consecuencias) {
        this.coordenada = coordenada;
        this.consecuencias = consecuencias;
    }

    @Override
    public String toString() {
        return "Celda{" +
                "coordenada=" + coordenada +
                ", consecuencias=" + consecuencias +
                '}';
    }

    @Override
    public void afectarGladiadorConConsecuencia(Gladiador gladiador) throws TriunfoException {
        for (Consecuencia consecuencia : consecuencias) {
            consecuencia.afectarGladiador(gladiador);
        }
    }
}
