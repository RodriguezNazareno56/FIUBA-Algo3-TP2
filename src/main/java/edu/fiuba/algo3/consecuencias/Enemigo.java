package edu.fiuba.algo3.consecuencias;

import edu.fiuba.algo3.equipamientos.*;
import edu.fiuba.algo3.gladiador.Energia;

public interface Enemigo {

    /**
     * Daño que causa al atacar contra gladiador de acuerdo al tipo de equipamiento que el mismo posee.
     * @param equipamiento equipamiento que posee el gladiador.
     * @return Energia por el valor del daño.
     */
    public Energia atacarATravesDelEquipamiento(Equipamiento equipamiento);

    /**
     * Daño que causa al atacar contra gladiador que no posee equipamiento
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipado(SinEquipamiento sinEquipamiento);

    /**
     * Daño que causa al atacar contra gladiador que posee un casco
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipado(Casco casco);

    /**
     * Daño que causa al atacar contra gladiador que posee una Armadura
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipado(Armadura armadura);

    /**
     * Daño que causa al atacar contra gladiador que posee un EscudoYEspada
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipado(EscudoYEspada escudoYEspada);

    /**
     * Daño que causa al atacar contra gladiador que posee una LLave
     * @return Energia por el valor del daño.
     */
    public Energia atacarContraEquipado(Llave llave);
}
