package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.consecuencias.Enemigo;
import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.gladiador.Energia;

public class EscudoYEspada extends Equipamiento {
    @Override
    public Equipamiento incrementar() {
        return new Llave();
    }

    @Override
    public Energia disiparAtaque(Enemigo enemigo) {
        return enemigo.atacarContraEquipado(this);
    }

    @Override
    public String toString() {
        return "EscudoYEspada";
    }
}
