package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.TriunfoException;

public interface Consecuencia {

    void afectarGladiador(Gladiador gladiador) throws TriunfoException;
}
