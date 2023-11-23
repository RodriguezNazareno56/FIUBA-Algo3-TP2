package edu.fiuba.algo3.equipamientos;

import edu.fiuba.algo3.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.gladiador.Energia;

public class Casco extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new Armadura();
    }

    @Override
    public Energia disiparAtaque(FieraSalvaje fieraSalvaje) {
        return fieraSalvaje.atacarContraEquipado(this);
    }
}
