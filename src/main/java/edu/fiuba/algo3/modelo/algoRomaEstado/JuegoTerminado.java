package edu.fiuba.algo3.modelo.algoRomaEstado;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class JuegoTerminado extends EstadoJuego{

    public JuegoTerminado(AlgoRoma algoRoma) {
        super(algoRoma);
    }

    @Override
    public void agregarGladiador(String nombreGladiador) throws FinDelJuegoException {
        algoRoma.agregarGladiador(nombreGladiador, this);
    }

    @Override
    public void jugarTurno() throws FinDelJuegoException {
        algoRoma.jugarTurnoSegunEstado(this);
    }

    @Override
    public void agregarTriunfo(Gladiador gladiador) {
    }


}
