package edu.fiuba.algo3.Equipamientos;

public class Casco extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new Armadura();
    }

    @Override
    public int disiparAtaque() {
        return 15;
    }
}
