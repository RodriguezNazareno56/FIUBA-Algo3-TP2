package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;

public class FieraSalvaje implements Consecuencia {
    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.recibirAtaque(this);
    }

    /**
     * Daño que causa una fiera salvaje al atacar cuando el atacado no posee equipamiento
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraSinEquipamiento() {
        return new Energia(20);
    }

    /**
     * Daño que causa una fiera salvaje al atacar cuando el atacado posee un casco
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipadoConCasco() {
        return new Energia(15);
    }

    /**
     * Daño que causa una fiera salvaje al atacar cuando el atacado posee una Armadura
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipadoConArmadura() {
        return new Energia(10);
    }

    /**
     * Daño que causa una fiera salvaje al atacar cuando el atacado posee un EscudoYEspada
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipadoConEscudoYEspada() {
        return new Energia(2);
    }

    /**
     * Daño que causa una fiera salvaje al atacar cuando el atacado posee una LLave
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipadoConLLave() {
        return new Energia(0);
    }
}
