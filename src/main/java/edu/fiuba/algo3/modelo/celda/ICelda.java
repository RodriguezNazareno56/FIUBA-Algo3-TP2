package edu.fiuba.algo3.modelo.celda;

import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.exepciones.TriunfoNoPosibleException;

public interface ICelda {
    void afectarGladiadorConConsecuencia(Gladiador gladiador) throws TriunfoNoPosibleException, FinDelJuegoException;

    Coordenada getCoordenada();
}
