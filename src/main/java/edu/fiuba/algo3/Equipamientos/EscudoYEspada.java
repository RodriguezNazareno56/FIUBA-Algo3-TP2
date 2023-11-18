package edu.fiuba.algo3.Equipamientos;

public class EscudoYEspada extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new Llave();
    }

    @Override
    public int disiparAtaque() {
        return 2;
    }
}
