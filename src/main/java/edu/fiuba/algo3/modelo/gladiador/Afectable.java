package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.gladiador.Energia;

public interface Afectable {

    /**
     * Calcula el daño que causa una fieraSalvaje de acuerdo al tipo de equipamiento
     * @param fieraSalvaje
     * @return Energia por el valor del daño.
     */
    Energia disiparAtaque(FieraSalvaje fieraSalvaje);
}
