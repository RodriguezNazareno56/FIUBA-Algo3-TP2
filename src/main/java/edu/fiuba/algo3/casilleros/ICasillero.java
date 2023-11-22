package edu.fiuba.algo3.casilleros;

public interface ICasillero {

    int getPosicion();

    ICasillero anterior() throws CasilleroInexistenteException;

    ICasillero proximo() throws CasilleroInexistenteException;;

    ICasillero proximoEnNPosiciones(int cantidadDePosiciones);

    ICasillero anteriorEnNPosiciones(int cantidadDePosiciones);

    void setProximo(ICasillero casilleroProximo);
}
