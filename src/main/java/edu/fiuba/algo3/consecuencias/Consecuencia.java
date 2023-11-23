package edu.fiuba.algo3.consecuencias;

import edu.fiuba.algo3.gladiador.Gladiador;
import edu.fiuba.algo3.gladiador.TriunfoException;

public interface Consecuencia {

    void afectarGladiador(Gladiador gladiador) throws TriunfoException;
}
