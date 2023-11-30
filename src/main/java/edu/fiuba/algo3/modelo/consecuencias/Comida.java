package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Comida implements Consecuencia {
    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.comer(new Energia(15));
    }

    @Override
    public String toString() {
        return "Comida";
    }
}
