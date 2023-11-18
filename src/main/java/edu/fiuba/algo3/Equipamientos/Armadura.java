package edu.fiuba.algo3.Equipamientos;

public class Armadura extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new EscudoYEspada();
    }

    @Override
    public int disiparAtaque() {
        return 10;
    }
}
