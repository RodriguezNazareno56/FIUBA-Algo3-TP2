package edu.fiuba.algo3.casilleros;

public interface CasilleroInterface {
    Casillero proximoEnNPosiciones(int cantidadDePosiciones);

    int getPosicion();

    CasilleroInterface anterior() throws Exception;

    CasilleroInterface proximo() throws Exception;;

    void setProximo(CasilleroInterface casilleroProximo);
}
