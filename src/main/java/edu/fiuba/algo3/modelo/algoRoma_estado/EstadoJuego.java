package edu.fiuba.algo3.modelo.algoRoma_estado;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.excepciones.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.excepciones.MaximoGladiadoresException;
import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.slf4j.Logger;

public abstract class EstadoJuego {

    protected AlgoRomaEstado algoRoma;

    protected Logger logger;

    public EstadoJuego(AlgoRomaEstado algoRoma, Logger logger) {
        this.algoRoma = algoRoma;
        this.logger = logger;
    }

    public abstract void jugarTurno() throws Exception;


    public abstract void agregarGladiador(Gladiador gladiador) throws FinDelJuegoException, MaximoGladiadoresException, JuegoEnCursoException, NombreInvalidoException;
}
