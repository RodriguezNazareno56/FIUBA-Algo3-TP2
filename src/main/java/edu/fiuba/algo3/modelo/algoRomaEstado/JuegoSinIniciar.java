package edu.fiuba.algo3.modelo.algoRomaEstado;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class JuegoSinIniciar extends EstadoJuego{

    public JuegoSinIniciar(AlgoRoma algoRoma) {
        super(algoRoma);
    }

    @Override
    public void agregarGladiador(String nombreGladiador) {
        algoRoma.agregarGladiador(nombreGladiador, this);
    }
    @Override
    public void jugarTurno() throws Exception {

        algoRoma.jugarTurnoSegunEstado(this);
        algoRoma.setEstadoJuego( new JuegoEnCurso(algoRoma) );
    }

    @Override
    public void agregarTriunfo(Gladiador gladiador) {
        // Es posible tener un triunfo cuando el juego no esta iniciado?, debería lanzar un error?
        algoRoma.setEstadoJuego( new JuegoTerminado(algoRoma));
    }



}
