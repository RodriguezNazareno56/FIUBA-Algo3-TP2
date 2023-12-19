package edu.fiuba.algo3.modelo.algoRoma_estado;
import edu.fiuba.algo3.modelo.AlgoRomaEstado;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.slf4j.Logger;

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
            logger.info("Se alcanzo el numero maximo de rondas");
            throw new FinDelJuegoException("Se alcanzo el numero maximo de rondas");
        }
        throw new FinDelJuegoException("Un Gladiador ya gano el juego");
    }


}
