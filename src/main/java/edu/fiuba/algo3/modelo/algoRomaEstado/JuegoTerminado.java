package edu.fiuba.algo3.modelo.algoRomaEstado;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.AlgoRomaEstado;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.slf4j.Logger;

import java.util.ArrayList;

public class JuegoTerminado extends EstadoJuego{

    public JuegoTerminado(AlgoRomaEstado algoRoma, Logger logger) {
        super(algoRoma, logger);
    }



    public void agregarGladiador(Gladiador gladiador) throws FinDelJuegoException {
        throw new FinDelJuegoException(" No se pueden agregar gladiadores en un juego terminado");
    }
    @Override
    public void jugarTurno() throws FinDelJuegoException {
        if( algoRoma.getRondasJugadas() >= algoRoma.getMaximaCantidadRondas()){
            throw new FinDelJuegoException("Se alcanzo el numero maximo de rondas");
        }
        throw new FinDelJuegoException("Un Gladiador ya gano el juego");
    }


}
