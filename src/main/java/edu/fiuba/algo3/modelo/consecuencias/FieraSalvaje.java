package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.constantes.FieraSalvajeConstantes;
import edu.fiuba.algo3.modelo.equipamientos.*;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class FieraSalvaje extends Consecuencia implements Enemigo, FieraSalvajeConstantes {
    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.recibirAtaque(this);
    }

    @Override
    public Energia atacarATravesDelEquipamiento(Equipamiento equipamiento) {
        return equipamiento.disiparAtaque(this);
    }

    @Override
    public Energia atacarContraEquipado(SinEquipamiento sinEquipamiento) {
        return new Energia(ATAQUE_CONTRA_EQUIPADO_SIN_EQUIPAMIENTO);
    }

    @Override
    public Energia atacarContraEquipado(Casco casco) {
        return new Energia(ATAQUE_CONTRA_EQUIPADO_CASCO);
    }

    @Override
    public Energia atacarContraEquipado(Armadura armadura) {
        return new Energia(ATAQUE_CONTRA_EQUIPADO_ARMADURA);
    }

    @Override
    public Energia atacarContraEquipado(EscudoYEspada escudoYEspada) {
        return new Energia(ATAQUE_CONTRA_EQUIPADO_ESCUDO_Y_ESPADA);
    }

    @Override
    public Energia atacarContraEquipado(Llave llave) {
        return new Energia(ATAQUE_CONTRA_EQUIPADO_LLAVE);
    }

    @Override
    public String toString() {
        return "Ataque de fiera salvaje";
    }
}
