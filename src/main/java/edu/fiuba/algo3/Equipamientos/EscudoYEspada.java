package edu.fiuba.algo3.Equipamientos;

import edu.fiuba.algo3.Concecuencias.FieraSalvaje;

public class EscudoYEspada extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new Llave();
    }

    @Override
    public int disiparAtaque(FieraSalvaje fieraSalvaje) {
        return fieraSalvaje.atacarContraEquipadoConEscudoYEspada();
    }
}
