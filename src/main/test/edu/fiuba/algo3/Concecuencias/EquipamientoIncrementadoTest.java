package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Gladiador.Gladiador;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

class EquipamientoIncrementadoTest {

    @Test
    void afectarGladiadorHaceQueGladiadorIncrementeSuEquipamiento() {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();

        // Act
        equipamientoIncrementado.afectarGladiador(gladiador);

        // Assert
        Mockito.verify(gladiador, times(1)).incrementarEquipamiento();
    }
}