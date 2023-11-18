package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;

public class Comida implements Consecuencia {
    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.comer(new Energia(10));
    }
}
