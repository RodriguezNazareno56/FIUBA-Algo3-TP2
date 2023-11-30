package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Lesion implements Consecuencia {

    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.enojar();
    }

    @Override
    public String toString() {
        return "Sufre una Lesion";
    }
}
