package edu.fiuba.algo3.Equipamientos;

import edu.fiuba.algo3.Concecuencias.FieraSalvaje;
import edu.fiuba.algo3.Gladiador.Energia;

public class Armadura extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new EscudoYEspada();
    }

    @Override
    public Energia disiparAtaque(FieraSalvaje fieraSalvaje) {
        return fieraSalvaje.atacarContraEquipado(this);
    }
}
