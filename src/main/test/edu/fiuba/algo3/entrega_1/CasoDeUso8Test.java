package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.gladiador.TriunfoNoPosibleException;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.equipamientos.Casco;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.MovimientoPausadoExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso8Test {

    private Gladiador gladiador;

    @BeforeEach
    public void setUp() {
        Senority senority = new Senority();
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Casco();
        this.gladiador = new Gladiador(energia, equipamiento, senority, Mockito.mock(Logger.class));
    }

    @Test
    public void verificarQueSiPasan8TurnosElSeniorityDelGladiadorPasaDeNovatoASemiSeniorYVeSuEnergiaIncrementadaAlProximoTurno() throws MovimientoException, MovimientoPausadoExeption, TriunfoNoPosibleException {
        // TODO: ver si podemos sacar ese .getEnergia()
        // Arrange
        for (int i = 1; i <= 8; i++) {
            gladiador.avanzar();
        }
        // se espera que un gladiador que inicia con 20 puntos de energia, al avanzar ya siendo SemiSenior, incrementa
        //  en 5 puntos su energia.
        Energia energiaEsperada = new Energia(25);

        // Act
        gladiador.avanzar();

        // Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }
}
