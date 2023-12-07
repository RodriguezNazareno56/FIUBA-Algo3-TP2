package edu.fiuba.algo3.modelo.algoRomaEstado;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import static edu.fiuba.algo3.modelo.constantes.AlgoRomaConstantes.MAXIMA_CANTIDAD_DE_GLADIADORES;


public class JuegoSinIniciar extends EstadoJuego{

    public JuegoSinIniciar(AlgoRoma algoRoma) {
        super(algoRoma);
    }

    @Override
    public void agregarGladiador(Gladiador gladiador) throws MaximoGladiadoresException {
        algoRoma.agregarGladiadorALaLista(gladiador);
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
