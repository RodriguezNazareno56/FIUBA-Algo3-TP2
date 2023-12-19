package edu.fiuba.algo3.modelo.algoRoma_estado;

import edu.fiuba.algo3.controladores.observers.ObservadorGladiador;
import edu.fiuba.algo3.modelo.AlgoRomaEstado;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.excepciones.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.slf4j.Logger;

import java.util.ArrayList;

public class JuegoEnCurso extends EstadoJuego implements ObservadorGladiador {


        public JuegoEnCurso(AlgoRomaEstado algoRoma, Logger logger, ArrayList<Gladiador> gladiadores) {
            super(algoRoma, logger);
            for(Gladiador gladiador: gladiadores){
                gladiador.subscribir(this);
            }
        }

        public void agregarGladiador(Gladiador gladiador) throws JuegoEnCursoException {
                throw new JuegoEnCursoException("No se pueden agregar gladiadores en un juego en curso");
        }
        @Override
        public void jugarTurno() throws Exception {

                algoRoma.jugarTurnoSegunEstado(this);

                if(algoRoma.getRondasJugadas() >= algoRoma.getMaximaCantidadRondas()){
                        logger.info("Se alcanzo el numero maximo de rondas");
                        algoRoma.setEstadoJuego( new JuegoTerminado(algoRoma, this.logger) );
                }
        }


        @Override
        public void notificarTriunfo(Gladiador gladiador) throws FinDelJuegoException {
                algoRoma.setEstadoJuego( new JuegoTerminado(algoRoma, this.logger) );
        }
}
