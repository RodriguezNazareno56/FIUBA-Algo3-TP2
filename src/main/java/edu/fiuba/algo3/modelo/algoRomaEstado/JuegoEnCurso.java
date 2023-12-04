package edu.fiuba.algo3.modelo.algoRomaEstado;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class JuegoEnCurso extends EstadoJuego{


        public JuegoEnCurso(AlgoRoma algoRoma) {
            super(algoRoma);
        }

        @Override
        public void agregarGladiador(String nombreGladiador) throws JuegoEnCursoException {
                throw new JuegoEnCursoException("No se pueden agregar gladiadores en un juego en curso");

        }
        @Override
        public void jugarTurno() throws Exception {

                if(algoRoma.getRondasJugadas() >= algoRoma.getMaximaCantidadRondas()){
                        JuegoTerminado juegoTerminado = new JuegoTerminado(algoRoma);
                        algoRoma.setEstadoJuego( juegoTerminado );
                        juegoTerminado.jugarTurno();
                }
                else{
                        algoRoma.jugarTurnoSegunEstado(this);
                }
        }

        @Override
        public void agregarTriunfo(Gladiador gladiador) {
                algoRoma.setEstadoJuego( new JuegoTerminado(algoRoma));
        }

}
