package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.gladiador.TriunfoException;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.equipamientos.Casco;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.MovimientoPausadoExeption;
import edu.fiuba.algo3.modelo.casilleros.CasillerosFactory;
import edu.fiuba.algo3.modelo.casilleros.ICasillero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso8Test {

    private Gladiador gladiador;

    @BeforeEach
    public void setUp() {
        CasillerosFactory casillerosFactory = new CasillerosFactory();
        ICasillero casillero = casillerosFactory.construirCasilleros(10);
        Senority senority = new Senority();
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Casco();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void verificarQueSiPasan8TurnosElSeniorityDelGladiadorPasaDeNovatoASemiSeniorYVeSuEnergiaIncrementadaAlProximoTurno() throws MovimientoException, MovimientoPausadoExeption, TriunfoException {
        // TODO: ver si podemos sacar ese .getEnergia()
        // Arrange
        for (int i = 1; i <= 8; i++) {
            gladiador.avanzar(1);
        }

        // Act
        gladiador.avanzar(1);

        // Assert
        assertEquals(25, gladiador.getEnergia());
    }
}
