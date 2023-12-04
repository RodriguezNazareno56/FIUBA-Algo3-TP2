package edu.fiuba.algo3.modelo.algoRomaEstado;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.constantes.AlgoRomaConstantes;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class JuegoEnCurso extends EstadoJuego{


        public JuegoEnCurso(AlgoRoma algoRoma) {
            super(algoRoma);
        }

        @Override
        public void agregarGladiador(String nombreGladiador) throws JuegoEnCursoException {
                algoRoma.agregarGladiador(nombreGladiador, this);
        }
        @Override
        public void jugarTurno() throws Exception {

                if(algoRoma.getCantidadRondas() > AlgoRomaConstantes.MAXIMA_CANTIDAD_DE_RONDAS){
                        JuegoTerminado juegoTerminado = new JuegoTerminado(algoRoma);
                        algoRoma.setEstadoJuego( juegoTerminado );
                        juegoTerminado.jugarTurno();
                        return;
                }

                algoRoma.jugarTurnoSegunEstado(this);


        }

        @Override
        public void agregarTriunfo(Gladiador gladiador) {
                algoRoma.setEstadoJuego( new JuegoTerminado(algoRoma));
        }

}
