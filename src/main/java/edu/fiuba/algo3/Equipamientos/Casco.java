package edu.fiuba.algo3.Equipamientos;

import edu.fiuba.algo3.Concecuencias.FieraSalvaje;

public class Casco extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new Armadura();
    }

    @Override
    public int disiparAtaque(FieraSalvaje fieraSalvaje) {
        return fieraSalvaje.atacarContraEquipadoConCasco();
    }
}
