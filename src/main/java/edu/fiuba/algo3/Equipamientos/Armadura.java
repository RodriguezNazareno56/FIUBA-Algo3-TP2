package edu.fiuba.algo3.Equipamientos;

import edu.fiuba.algo3.Concecuencias.FieraSalvaje;

public class Armadura extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new EscudoYEspada();
    }

    @Override
    public int disiparAtaque(FieraSalvaje fieraSalvaje) {
        return fieraSalvaje.atacarContraEquipadoConArmadura();
    }
}
