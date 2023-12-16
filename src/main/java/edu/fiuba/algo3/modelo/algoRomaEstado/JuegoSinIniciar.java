package edu.fiuba.algo3.modelo.algoRomaEstado;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.slf4j.Logger;

import java.util.ArrayList;


public class JuegoSinIniciar extends EstadoJuego{

    private ArrayList<Gladiador> gladiadores;

    public JuegoSinIniciar(AlgoRoma algoRoma, Logger logger) {
        super(algoRoma, logger);
        this.gladiadores = new ArrayList<>();
    }



    public void agregarGladiador(Gladiador gladiador) throws MaximoGladiadoresException {
        if( algoRoma.getCantidadDeGladiadores() >= algoRoma.getMaximaCantidadGladiadores()){
            throw new MaximoGladiadoresException("No se pueden agregar mas gladiadores");
        }

        algoRoma.agregarNuevoGladiador(gladiador);
        this.gladiadores.add(gladiador);
        logger.info(gladiador + " se unio al juego");
    }

    @Override
    public void jugarTurno() throws Exception {
        if( algoRoma.getCantidadDeGladiadores() < algoRoma.getMinimaCantidadGladiadores()){
            throw new MinimoGladiadoresException("No se puede inicializar un juego con menos de dos gladiadores");
        }
        this.logger.info("Juego inicilizado");
        algoRoma.jugarTurnoSegunEstado(this);
        algoRoma.setEstadoJuego( new JuegoEnCurso(algoRoma, this.logger, this.gladiadores) );
    }






}
