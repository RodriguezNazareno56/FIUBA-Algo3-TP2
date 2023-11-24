package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.casilleros.Casillero;
import edu.fiuba.algo3.modelo.casilleros.ICasillero;
import edu.fiuba.algo3.modelo.equipamientos.Casco;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.gladiador.senority.Novato;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

public class GladiadorTest {

    private Gladiador gladiador;

    ICasillero casilleroMock;
    Energia energiaMock;
    Equipamiento equipamientoMock;
    Senority senorityMock;

    @BeforeEach
    public void setUp() {
        casilleroMock = Mockito.mock(Casillero.class);
        energiaMock = Mockito.mock(Energia.class);
        equipamientoMock = Mockito.mock(Casco.class);
        senorityMock = Mockito.mock(Novato.class);
        gladiador = new Gladiador(energiaMock, equipamientoMock, casilleroMock, senorityMock);
    }

    @Test
    public void retrocederDevuelveUnaExcepcionCuandoAlRetrocederPermaneceEnElMismoCasillero() {
        Mockito.when(casilleroMock.anteriorEnNPosiciones(anyInt()))
                .thenReturn(casilleroMock);

        // Assert
        Assertions.assertThrows(MovimientoException.class, () -> {
            this.gladiador.retroceder(1);
        });
        Mockito.verify(casilleroMock, times(1))
                .anteriorEnNPosiciones(anyInt());
    }
}