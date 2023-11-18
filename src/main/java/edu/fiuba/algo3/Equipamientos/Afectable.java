package edu.fiuba.algo3.Equipamientos;

import edu.fiuba.algo3.Concecuencias.FieraSalvaje;
import edu.fiuba.algo3.Gladiador.Energia;

public interface Afectable {

    /**
     * Calcula el daño que causa una fieraSalvaje de acuerdo al tipo de equipamiento
     * @param fieraSalvaje
     * @return Energia por el valor del daño.
     */
    Energia disiparAtaque(FieraSalvaje fieraSalvaje);
}
