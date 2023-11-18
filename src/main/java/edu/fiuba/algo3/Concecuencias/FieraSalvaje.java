package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Gladiador.Gladiador;

public class FieraSalvaje implements Consecuencia {
    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.recibirAtaque(this);
    }

    public int atacarContraSinEquipamiento() {
        return 20;
    }

    public int atacarContraEquipadoConCasco() {
        return 15;
    }

    public int atacarContraEquipadoConArmadura() {
        return 10;
    }

    public int atacarContraEquipadoConEscudoYEspada() {
        return 2;
    }

    public int atacarContraEquipadoConLLave() {
        return 0;
    }
}
