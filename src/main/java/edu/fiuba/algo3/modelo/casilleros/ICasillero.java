package edu.fiuba.algo3.modelo.casilleros;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.TriunfoException;

public interface ICasillero {

    int getPosicion();

    ICasillero anterior() throws CasilleroInexistenteException;

    ICasillero proximo() throws CasilleroInexistenteException;

    ICasillero proximoEnNPosiciones(int cantidadDePosiciones);

    ICasillero anteriorEnNPosiciones(int cantidadDePosiciones);

    void setProximo(ICasillero casilleroProximo);

    void afectarGladiadorConConsecuencia(Gladiador gladiador) throws TriunfoException;
}
