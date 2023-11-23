package edu.fiuba.algo3.consecuencias;

import edu.fiuba.algo3.gladiador.Energia;
import edu.fiuba.algo3.gladiador.Gladiador;

public class Comida implements Consecuencia {
    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.comer(new Energia(15));
    }
}
