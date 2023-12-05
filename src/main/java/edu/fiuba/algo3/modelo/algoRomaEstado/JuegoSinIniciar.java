package edu.fiuba.algo3.modelo.algoRomaEstado;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.JuegoNoIniciadoException;
import edu.fiuba.algo3.modelo.MaximoGladiadoresException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import static edu.fiuba.algo3.modelo.constantes.AlgoRomaConstantes.MAXIMA_CANTIDAD_DE_GLADIADORES;


public class JuegoSinIniciar extends EstadoJuego{

    public JuegoSinIniciar(AlgoRoma algoRoma) {
        super(algoRoma);
    }

    @Override
    public void agregarGladiador(String nombreGladiador) throws MaximoGladiadoresException {
        algoRoma.agregarGladiadorALaLista(nombreGladiador);
    }
    @Override
    public void jugarTurno() throws Exception {

        algoRoma.jugarTurnoSegunEstado(this);
        algoRoma.setEstadoJuego( new JuegoEnCurso(algoRoma) );
    }

    @Override
    public void agregarTriunfo(Gladiador gladiador) throws JuegoNoIniciadoException {
        throw new JuegoNoIniciadoException(" No se pueden agregar triunfos en un juego no iniciado");
    }




}
