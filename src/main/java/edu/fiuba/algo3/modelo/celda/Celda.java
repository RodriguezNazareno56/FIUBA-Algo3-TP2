package edu.fiuba.algo3.modelo.celda;

import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.exepciones.TriunfoNoPosibleException;

import java.util.List;
import java.util.StringJoiner;

public class Celda implements ICelda {

    private Coordenada coordenada;
    private List<Consecuencia> consecuencias;

    public Celda(Coordenada coordenada, List<Consecuencia> consecuencias) {
        this.coordenada = coordenada;
        this.consecuencias = consecuencias;
    }

    @Override
    public String toString() {
        StringJoiner consecuenciasString = new StringJoiner(", ");
        for (Consecuencia consecuencia : consecuencias) {
            consecuenciasString.add(consecuencia.toString());
        }

        return "Celda en " + coordenada +
                " con consecuencias: " + consecuenciasString ;
    }

    @Override
    public void afectarGladiadorConConsecuencia(Gladiador gladiador) throws TriunfoNoPosibleException {
        for (Consecuencia consecuencia : consecuencias) {
            consecuencia.afectarGladiador(gladiador);
        }
    }

    @Override
    public Coordenada getCoordenada() {
        return this.coordenada;
    }
}