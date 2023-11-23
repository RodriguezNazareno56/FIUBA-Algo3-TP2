package edu.fiuba.algo3.consecuencias;

import edu.fiuba.algo3.gladiador.Gladiador;
import edu.fiuba.algo3.gladiador.TriunfoException;

public class Triunfo implements Consecuencia {
    @Override
    public void afectarGladiador(Gladiador gladiador) throws TriunfoException {
        gladiador.triunfar();
    }
}
