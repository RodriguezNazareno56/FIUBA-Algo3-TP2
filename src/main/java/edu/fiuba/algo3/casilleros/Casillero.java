package edu.fiuba.algo3.casilleros;

public class Casillero {

    private int posicion;

    private Casillero proximo = null; //TODO: Idealmente deberiamos quitar estos null
    private Casillero anterior = null;

    public int getPosicion() {
        return posicion;
    }

    public Casillero anterior( ){
        return this.anterior;
    }

    public Casillero proximo( ){
        return this.proximo;
    }
    public Casillero(int posicion) {
        this.posicion = posicion;
    }

    public Casillero(int posicion, Casillero anterior) {
        this.posicion = posicion;
        this.anterior = anterior;
    }

    public Casillero proximoEnNPosiciones(int cantidadDePosiciones) { // TODO: Buscarle un mejor nombre(?
        if (cantidadDePosiciones == 0) {
            return this;
        }
        cantidadDePosiciones--;
        return this.proximo.proximoEnNPosiciones(cantidadDePosiciones);
    }

    public void setProximo(Casillero casilleroProximo) {
        this.proximo = casilleroProximo;
    }
}
