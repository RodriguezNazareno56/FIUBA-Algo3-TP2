package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Gladiador.Gladiador;

public class IncrementoDeEquipamiento implements Consecuencia {
    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.incrementarEquipamiento();
    }
}
