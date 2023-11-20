package edu.fiuba.algo3;

public class Casillero {

    int posicion;

    Casillero proximo = null;
    Casillero anterior = null;

    public Casillero(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicion() {
        return posicion;
    }

    public Casillero anterior( ){
        return this.anterior;
    }

    public Casillero proximo( ){
        return this.proximo;
    }

}
