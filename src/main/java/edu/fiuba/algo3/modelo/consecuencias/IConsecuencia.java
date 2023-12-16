package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.exepciones.TriunfoNoPosibleException;

public interface IConsecuencia {

    void afectarGladiador(Gladiador gladiador) throws TriunfoNoPosibleException, FinDelJuegoException;
}
