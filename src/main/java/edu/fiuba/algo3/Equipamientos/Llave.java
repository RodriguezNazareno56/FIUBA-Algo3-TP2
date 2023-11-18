package edu.fiuba.algo3.Equipamientos;

import edu.fiuba.algo3.Concecuencias.FieraSalvaje;

public class Llave extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return this;
    }

    @Override
    public int disiparAtaque(FieraSalvaje fieraSalvaje) {
        return fieraSalvaje.atacarContraEquipadoConLLave();
    }
}
