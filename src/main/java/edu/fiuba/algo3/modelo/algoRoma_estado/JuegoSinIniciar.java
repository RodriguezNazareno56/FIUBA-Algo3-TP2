package edu.fiuba.algo3.modelo.algoRoma_estado;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.MaximoGladiadoresException;
import edu.fiuba.algo3.modelo.excepciones.MinimoGladiadoresException;
import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.slf4j.Logger;

import java.util.ArrayList;


public class JuegoSinIniciar extends EstadoJuego{

    private ArrayList<Gladiador> gladiadores;

    public JuegoSinIniciar(AlgoRoma algoRoma, Logger logger) {
        super(algoRoma, logger);
        this.gladiadores = new ArrayList<>();
    }



    public void agregarGladiador(Gladiador gladiador) throws MaximoGladiadoresException, NombreInvalidoException {
        if( algoRoma.getCantidadDeGladiadores() >= algoRoma.getMaximaCantidadGladiadores()){
            throw new MaximoGladiadoresException("No se pueden agregar mas gladiadores");
        }

        ArrayList<String> gladiadoresEnElJuego = algoRoma.getNombresGladiadoresSegunOrdenEnRonda();
        if( gladiadoresEnElJuego.contains(gladiador.getNombre()) ){
            throw new NombreInvalidoException("No se pueden agregar dos gladiadores con el mismo nombre");
        }

        algoRoma.agregarNuevoGladiador(gladiador);
        this.gladiadores.add(gladiador);
        logger.info(gladiador + " se unio al juego");
    }

    @Override
    public void jugarTurno() throws Exception {
        if( algoRoma.getCantidadDeGladiadores() < algoRoma.getMinimaCantidadGladiadores()){
            throw new MinimoGladiadoresException("No se puede iniciar un juego con menos de dos gladiadores");
        }
        this.logger.info("Juego inicilizado");
        algoRoma.jugarTurnoSegunEstado(this);
        algoRoma.setEstadoJuego( new JuegoEnCurso(algoRoma, this.logger, gladiadores) );
    }






}
