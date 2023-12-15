package edu.fiuba.algo3.modelo.algoRomaEstado;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.slf4j.Logger;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.constantes.AlgoRomaConstantes.MAXIMA_CANTIDAD_DE_GLADIADORES;
import static edu.fiuba.algo3.modelo.constantes.AlgoRomaConstantes.MINIMA_CANTIDAD_DE_GLADIADORES;


public class JuegoSinIniciar extends EstadoJuego{

    public JuegoSinIniciar(AlgoRoma algoRoma, Logger logger) {
        super(algoRoma, logger);
    }



    public void agregarGladiador(ArrayList<Gladiador> gladiadores, Gladiador gladiador) throws MaximoGladiadoresException {
        if( gladiadores.size() >= algoRoma.getMaximaCantidadGladiadores()){
            throw new MaximoGladiadoresException("No se pueden agregar mas gladiadores");
        }
        gladiadores.add(gladiador);
        logger.info(gladiador + " se unio al juego");
    }

    @Override
    public void jugarTurno() throws Exception {
        if( algoRoma.cantidadDeGladiadores() < algoRoma.getMinimaCantidadGladiadores()){
            throw new MinimoGladiadoresException("No se puede inicializar un juego con menos de dos gladiadores");
        }
        this.logger.info("Juego inicilizado");
        algoRoma.jugarTurnoSegunEstado(this);
        algoRoma.setEstadoJuego( new JuegoEnCurso(algoRoma, this.logger) );
    }

    @Override
    public void agregarTriunfo(Gladiador gladiador) throws JuegoNoIniciadoException {
        throw new JuegoNoIniciadoException(" No se pueden agregar triunfos en un juego no iniciado");
    }




}
