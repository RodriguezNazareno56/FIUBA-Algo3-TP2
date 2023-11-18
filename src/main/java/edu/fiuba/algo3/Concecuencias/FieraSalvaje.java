package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;

public class FieraSalvaje implements Consecuencia, Enemigo {
    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.recibirAtaque(this);
    }

    @Override
    public Energia atacarATravesDelEquipamiento(Equipamiento equipamiento) {
        return equipamiento.disiparAtaque(this);
    }

    @Override
    public Energia atacarContraSinEquipamiento() {
        return new Energia(20);
    }

    @Override
    public Energia atacarContraEquipadoConCasco() {
        return new Energia(15);
    }

    @Override
    public Energia atacarContraEquipadoConArmadura() {
        return new Energia(10);
    }

    @Override
    public Energia atacarContraEquipadoConEscudoYEspada() {
        return new Energia(2);
    }

    @Override
    public Energia atacarContraEquipadoConLLave() {
        return new Energia(0);
    }
}
