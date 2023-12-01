package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class EquipamientoIncrementado extends Consecuencia {
    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.incrementarEquipamiento();
    }

    @Override
    public String toString() {
        return "Equipamiento Incrementado";
    }
}
