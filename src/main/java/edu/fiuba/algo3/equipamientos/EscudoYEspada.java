package edu.fiuba.algo3.equipamientos;

import edu.fiuba.algo3.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.gladiador.Energia;

public class EscudoYEspada extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new Llave();
    }

    @Override
    public Energia disiparAtaque(FieraSalvaje fieraSalvaje) {
        return fieraSalvaje.atacarContraEquipado(this);
    }
}
