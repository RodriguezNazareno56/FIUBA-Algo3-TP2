package edu.fiuba.algo3.modelo.casilleros;

import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;
import edu.fiuba.algo3.modelo.consecuencias.SinConsecuencia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.TriunfoException;

public class Casillero implements ICasillero {

    private int posicion;
    protected Consecuencia consecuencia = new SinConsecuencia();

    protected ICasillero proximo;
    protected ICasillero anterior;

    public int getPosicion() {
        return posicion;
    }

    public ICasillero anterior( ) throws CasilleroInexistenteException {
        return this.anterior;
    }

    public ICasillero proximo( ) throws CasilleroInexistenteException {
        return this.proximo;
    }

    public Casillero(int posicion) {
        this.posicion = posicion;
    }

    protected Casillero(int posicion, ICasillero anterior) {
        this.posicion = posicion;
        this.anterior = anterior;
    }

    public ICasillero proximoEnNPosiciones(int cantidadDePosiciones) { // TODO: Buscarle un mejor nombre(?
        if (cantidadDePosiciones == 0) {
            return this;
        }
        cantidadDePosiciones--;
        return this.proximo.proximoEnNPosiciones(cantidadDePosiciones);
    }

    public ICasillero anteriorEnNPosiciones(int cantidadDePosiciones) { // TODO: Buscarle un mejor nombre(?
        if (cantidadDePosiciones == 0) {
            return this;
        }
        cantidadDePosiciones--;
        return this.anterior.anteriorEnNPosiciones(cantidadDePosiciones);
    }

    public void setProximo(ICasillero casilleroProximo) {
        this.proximo = casilleroProximo;
    }

    @Override
    public void afectarGladiadorConConsecuencia(Gladiador gladiador) throws TriunfoException, MovimientoException {
        // TODO: falta implementar que se setee la concecuencia
        this.consecuencia.afectarGladiador(gladiador);
    }
}
