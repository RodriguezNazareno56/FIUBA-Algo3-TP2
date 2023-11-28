package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.TriunfoException;

public interface Consecuencia {

    void afectarGladiador(Gladiador gladiador) throws TriunfoException;
}
