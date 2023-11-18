package edu.fiuba.algo3.Equipamientos;

public class Nada extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new Casco();
    }

    @Override
    public int disiparAtaque() {
        return 20;
    }
}
