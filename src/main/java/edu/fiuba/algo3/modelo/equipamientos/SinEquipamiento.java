package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.gladiador.Energia;

public class SinEquipamiento extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new Casco();
    }

    @Override
    public Energia disiparAtaque(FieraSalvaje fieraSalvaje) {
        return fieraSalvaje.atacarContraEquipado(this);
    }
}
