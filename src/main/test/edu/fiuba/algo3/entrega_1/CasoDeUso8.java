package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.gladiador.TriunfoException;
import edu.fiuba.algo3.gladiador.Energia;
import edu.fiuba.algo3.equipamientos.Casco;
import edu.fiuba.algo3.equipamientos.Equipamiento;
import edu.fiuba.algo3.gladiador.Gladiador;
import edu.fiuba.algo3.MovimientoException;
import edu.fiuba.algo3.gladiador.senority.Novato;
import edu.fiuba.algo3.gladiador.senority.Senority;
import edu.fiuba.algo3.MovimientoPausadoExeption;
import edu.fiuba.algo3.casilleros.CasillerosFactory;
import edu.fiuba.algo3.casilleros.ICasillero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso8 {

    private Gladiador gladiador;

    @BeforeEach
    void setUp() {
        CasillerosFactory casillerosFactory = new CasillerosFactory();
        ICasillero casillero = casillerosFactory.construirCasilleros(10);
        Senority senority = new Novato();
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
        assertEquals(gladiador.getEnergia(), 25);
    }
}
