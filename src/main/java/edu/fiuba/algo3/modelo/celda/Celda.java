package edu.fiuba.algo3.modelo.celda;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.exepciones.TriunfoNoPosibleException;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Celda implements ICelda {

    private Coordenada coordenada;
    private List<IConsecuencia> consecuencias;

    public Celda(Coordenada coordenada, List<IConsecuencia> consecuencias) {
        this.coordenada = coordenada;
        this.consecuencias = consecuencias;
    }

    @Override
    public String toString() {
        StringJoiner consecuenciasString = new StringJoiner(", ");
        for (IConsecuencia consecuencia : consecuencias) {
            consecuenciasString.add(consecuencia.toString());
        }

        return "Celda en " + coordenada +
                " con consecuencias: " + consecuenciasString ;
    }

    @Override
    public void afectarGladiadorConConsecuencia(Gladiador gladiador) throws TriunfoNoPosibleException, FinDelJuegoException {
        for (IConsecuencia consecuencia : consecuencias) {
            consecuencia.afectarGladiador(gladiador);
        }
    }

    @Override
    public Coordenada getCoordenada() {
        return this.coordenada;
    }

    @Override
    public List<IConsecuencia> getConsecuencias() {
        return this.consecuencias;
    }

    // Dos celdas son iguales cuando tienen las mismas coordenadas y mismas consecuencias
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Celda celda = (Celda) o;
        return Objects.equals(coordenada, celda.coordenada) &&
                Objects.equals(consecuencias, celda.consecuencias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenada, consecuencias);
    }
}