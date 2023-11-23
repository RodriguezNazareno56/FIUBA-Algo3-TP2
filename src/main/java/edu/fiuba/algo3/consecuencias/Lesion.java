package edu.fiuba.algo3.consecuencias;

import edu.fiuba.algo3.gladiador.Gladiador;

public class Lesion implements Consecuencia {

    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.enojar();
    }
}
