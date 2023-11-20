package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Casillero;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Equipamientos.Casco;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.MovimientoExeption;
import edu.fiuba.algo3.Gladiador.senority.Novato;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso8 {

    private Gladiador gladiador;

    @BeforeEach
    void setUp() {
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Casco();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void verificarQueSiPasan8TurnosElSeniorityDelGladiadorPasaDeNovatoASemiSeniorYVeSuEnergiaIncrementadaAlProximoTurno() throws MovimientoExeption {
        // TODO: ver si podemos sacar ese .getEnergia()
        // Arrange
        for (int i = 1; i <= 8; i++) {
            gladiador.avanzar();
        }

        // Act
        gladiador.avanzar();

        // Assert
        assertEquals(gladiador.getEnergia(), 25);
    }
}
