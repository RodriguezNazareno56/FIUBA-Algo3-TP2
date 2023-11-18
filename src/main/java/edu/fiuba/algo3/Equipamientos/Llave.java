package edu.fiuba.algo3.Equipamientos;

public class Llave extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return this;
    }

    @Override
    public int disiparAtaque() {
        return 0;
    }
}
