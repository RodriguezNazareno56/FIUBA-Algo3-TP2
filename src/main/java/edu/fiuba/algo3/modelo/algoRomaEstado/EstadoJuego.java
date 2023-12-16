package edu.fiuba.algo3.modelo.algoRomaEstado;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.slf4j.Logger;

import java.util.ArrayList;

public abstract class EstadoJuego {

    protected AlgoRomaEstado algoRoma;

    protected Logger logger;

    public EstadoJuego(AlgoRomaEstado algoRoma, Logger logger) {
        this.algoRoma = algoRoma;
        this.logger = logger;
    }

    public abstract void jugarTurno() throws Exception;


    public abstract void agregarGladiador(ArrayList<Gladiador> gladiadores, Gladiador gladiador) throws FinDelJuegoException, MaximoGladiadoresException, JuegoEnCursoException;
}
