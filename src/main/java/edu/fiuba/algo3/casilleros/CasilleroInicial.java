package edu.fiuba.algo3.casilleros;

import edu.fiuba.algo3.Concecuencias.Triunfo;
import edu.fiuba.algo3.Gladiador.Gladiador;

public class CasilleroInicial extends Casillero implements ICasillero {

    public CasilleroInicial(int posicion) {
        super(posicion);
        super.anterior = this;
    }

    @Override
    public ICasillero anterior() throws CasilleroInexistenteException {
        throw new CasilleroInexistenteException("No hay casillero anterior al inicial");
    }

    @Override
    public void afectarGladiadorConConsecuencia(Gladiador gladiador) {
    }
}