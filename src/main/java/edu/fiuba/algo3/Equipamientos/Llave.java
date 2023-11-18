package edu.fiuba.algo3.Equipamientos;

import edu.fiuba.algo3.Concecuencias.FieraSalvaje;
import edu.fiuba.algo3.Gladiador.Energia;

public class Llave extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return this;
    }

    @Override
    public Energia disiparAtaque(FieraSalvaje fieraSalvaje) {
        return fieraSalvaje.atacarContraEquipado(this);
    }
}
