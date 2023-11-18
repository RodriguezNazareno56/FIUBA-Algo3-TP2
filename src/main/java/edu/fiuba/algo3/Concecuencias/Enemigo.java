package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Gladiador.Energia;

public interface Enemigo {

    /**
     * Daño que causa al atacar contra gladiador de acuerdo al tipo de equipamiento que el mismo posee.
     * @param equipamiento equipamiento que posee el gladiador.
     * @return Energia por el valor del daño.
     */
    public abstract Energia atacarATravesDelEquipamiento(Equipamiento equipamiento);

    /**
     * Daño que causa al atacar contra gladiador que no posee equipamiento
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraSinEquipamiento();

    /**
     * Daño que causa al atacar contra gladiador que posee un casco
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipadoConCasco();

    /**
     * Daño que causa al atacar contra gladiador que posee una Armadura
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipadoConArmadura();

    /**
     * Daño que causa al atacar contra gladiador que posee un EscudoYEspada
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipadoConEscudoYEspada();

    /**
     * Daño que causa al atacar contra gladiador que posee una LLave
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipadoConLLave();
}
