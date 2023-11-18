package edu.fiuba.algo3.Equipamientos;

import edu.fiuba.algo3.Concecuencias.FieraSalvaje;
import edu.fiuba.algo3.Gladiador.Energia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class NadaTest {

    private FieraSalvaje fieraSalvajeMock;

    @BeforeEach
    public void setUp() {
        fieraSalvajeMock = Mockito.mock(FieraSalvaje.class);
    }

    @Test
    public void incrementarNadaRetornaUnEquipamientoCasco() {
        // Arrange
        Nada nada = new Nada();

        // Act
        Equipamiento equipoIncrementado = nada.incrementar();

        // Assert.
        // El quipo incrementado al disipar un ataque invoca fieraSalvaje.atacarContraEquipado(Nada nada);
        equipoIncrementado.disiparAtaque(fieraSalvajeMock);
        verify(fieraSalvajeMock, times(1))
                .atacarContraEquipado(ArgumentMatchers.isA(Casco.class));
    }

    @Test
    public void disiparAtaqueDeUnaFieraRetornaUnaEnergiaConValor0ComoDanio() {
        // Arrange
        Nada nada = new Nada();
        int danioEsperado = 20;

        Energia energiaMock = Mockito.mock(Energia.class);
        Mockito.when(energiaMock.getValor()).thenReturn(danioEsperado);

        Mockito.when(fieraSalvajeMock.atacarContraEquipado(nada))
                .thenReturn(energiaMock);

        // Act
        Energia danio = nada.disiparAtaque(fieraSalvajeMock);

        // Assert
        assertEquals(danio.getValor(), danioEsperado);
        Mockito.verify(fieraSalvajeMock, times(1)).atacarContraEquipado(nada);
    }
}