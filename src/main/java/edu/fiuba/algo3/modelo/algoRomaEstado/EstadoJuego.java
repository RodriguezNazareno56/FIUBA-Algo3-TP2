package edu.fiuba.algo3.modelo.algoRomaEstado;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.MaximoGladiadoresException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public abstract class EstadoJuego {

    protected AlgoRoma algoRoma;

    public EstadoJuego(AlgoRoma algoRoma) {
        this.algoRoma = algoRoma;
    }

    public abstract void jugarTurno() throws Exception;

    public abstract void agregarGladiador(String nombreGladiador) throws FinDelJuegoException, MaximoGladiadoresException, JuegoEnCursoException;

    public abstract void agregarTriunfo(Gladiador gladiador) throws FinDelJuegoException;
}
