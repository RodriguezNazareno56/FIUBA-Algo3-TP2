package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.constantes.ComidaConstantes;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Comida extends Consecuencia implements ComidaConstantes {
    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.comer(new Energia(VALOR_DE_RECOMPOSICION));
    }

    @Override
    public String toString() {
        return "Comida";
    }
}
