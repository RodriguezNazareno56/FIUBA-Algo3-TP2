package edu.fiuba.algo3.casilleros;

import edu.fiuba.algo3.Concecuencias.Triunfo;

public class CasilleroFinal extends Casillero implements ICasillero {


    public CasilleroFinal(int posicion, ICasillero anterior) {
        super(posicion, anterior);
        super.proximo = this;
        super.consecuencia = new Triunfo();
    }

    @Override
    public ICasillero proximo() throws CasilleroInexistenteException {
        throw new CasilleroInexistenteException("No hay casillero proximo al final");
    }

    @Override
    public void setProximo(ICasillero casilleroProximo) {
        this.proximo = this;
    }
}