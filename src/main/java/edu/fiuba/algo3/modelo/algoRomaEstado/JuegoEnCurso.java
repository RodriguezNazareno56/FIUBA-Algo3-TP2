package edu.fiuba.algo3.modelo.algoRomaEstado;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.AlgoRomaEstado;
import edu.fiuba.algo3.modelo.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.slf4j.Logger;

import java.util.ArrayList;

public class JuegoEnCurso extends EstadoJuego{


        public JuegoEnCurso(AlgoRomaEstado algoRoma, Logger logger) {
            super(algoRoma, logger);
        }



        public void agregarGladiador(ArrayList<Gladiador> gladiadores, Gladiador gladiador) throws JuegoEnCursoException {
                throw new JuegoEnCursoException("No se pueden agregar gladiadores en un juego en curso");
        }
        @Override
        public void jugarTurno() throws Exception {

                if(algoRoma.getRondasJugadas() >= algoRoma.getMaximaCantidadRondas()){
                        JuegoTerminado juegoTerminado = new JuegoTerminado(algoRoma, this.logger);
                        algoRoma.setEstadoJuego( juegoTerminado );
                        juegoTerminado.jugarTurno();
                }
                else{
                        algoRoma.jugarTurnoSegunEstado(this);
                }
        }

        @Override
        public void agregarTriunfo(Gladiador gladiador) {
                //con solo un gladiador triunfando se termina el juego
                algoRoma.setEstadoJuego( new JuegoTerminado(algoRoma, this.logger) );
        }

}
