package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.exepciones.TriunfoNoPosibleException;

public class Triunfo implements Consecuencia {
    @Override
    public void afectarGladiador(Gladiador gladiador) throws TriunfoNoPosibleException, FinDelJuegoException {
        gladiador.triunfar();
    }

    @Override
    public String toString() {
        return "Lograr triunfo";
    }
}
