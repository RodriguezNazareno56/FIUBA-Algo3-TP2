package edu.fiuba.algo3.Equipamientos;

import edu.fiuba.algo3.Concecuencias.FieraSalvaje;
import edu.fiuba.algo3.Gladiador.Energia;

public class EscudoYEspada extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new Llave();
    }

    @Override
    public Energia disiparAtaque(FieraSalvaje fieraSalvaje) {
        return fieraSalvaje.atacarContraEquipadoConEscudoYEspada();
    }
}
