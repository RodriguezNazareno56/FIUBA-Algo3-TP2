package edu.fiuba.algo3.Equipamientos;

import edu.fiuba.algo3.Concecuencias.FieraSalvaje;

public class Nada extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new Casco();
    }

    @Override
    public int disiparAtaque(FieraSalvaje fieraSalvaje) {
        return fieraSalvaje.atacarContraSinEquipamiento();
    }
}
