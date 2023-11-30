package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class CascoTest {

    private FieraSalvaje fieraSalvajeMock;

    @BeforeEach
    public void setUp() {
        fieraSalvajeMock = Mockito.mock(FieraSalvaje.class);
    }

    @Test
    public void incrementarCascoRetornaUnEquipamientoArmadura() {
        // Arrange
        Casco casco = new Casco();

        // Act
        Equipamiento equipoIncrementado = casco.incrementar();

        // Assert.
        // El quipo incrementado al disipar un ataque invoca fieraSalvaje.atacarContraEquipado(Armadura armadura);
        equipoIncrementado.disiparAtaque(fieraSalvajeMock);
        verify(fieraSalvajeMock, times(1))
                .atacarContraEquipado(ArgumentMatchers.isA(Armadura.class));
    }

    @Test
    public void disiparAtaqueDeUnaFieraRetornaUnaEnergiaConValor15ComoDanio() {
        // Arrange
        Casco casco = new Casco();
        int danioEsperado = FieraSalvaje.ATAQUE_CONTRA_EQUIPADO_CASCO;

        Energia energiaMock = Mockito.mock(Energia.class);
        Mockito.when(energiaMock.getValor()).thenReturn(danioEsperado);

        Mockito.when(fieraSalvajeMock.atacarContraEquipado(casco))
                .thenReturn(energiaMock);

        // Act
        Energia danio = casco.disiparAtaque(fieraSalvajeMock);

        // Assert
        assertEquals(danioEsperado, danio.getValor());
        Mockito.verify(fieraSalvajeMock, times(1)).atacarContraEquipado(casco);
    }
}