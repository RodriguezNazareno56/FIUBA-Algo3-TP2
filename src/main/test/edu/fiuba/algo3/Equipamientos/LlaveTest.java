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

public class LlaveTest {

    private FieraSalvaje fieraSalvajeMock;

    @BeforeEach
    public void setUp() {
        fieraSalvajeMock = Mockito.mock(FieraSalvaje.class);
    }

    @Test
    public void incrementarLlaveRetornaUnEquipamientoLlave() {
        // Arrange
        Llave llave = new Llave();

        // Act
        Equipamiento equipoIncrementado = llave.incrementar();

        // Assert.
        // El quipo incrementado al disipar un ataque invoca fieraSalvaje.atacarContraEquipado(Llave llave);
        equipoIncrementado.disiparAtaque(fieraSalvajeMock);
        verify(fieraSalvajeMock, times(1))
                .atacarContraEquipado(ArgumentMatchers.isA(Llave.class));
    }

    @Test
    public void disiparAtaqueDeUnaFieraRetornaUnaEnergiaConValor0ComoDanio() {
        // Arrange
        Llave llave = new Llave();
        int danioEsperado = 0;

        Energia energiaMock = Mockito.mock(Energia.class);
        Mockito.when(energiaMock.getValor()).thenReturn(danioEsperado);

        Mockito.when(fieraSalvajeMock.atacarContraEquipado(llave))
                .thenReturn(energiaMock);

        // Act
        Energia danio = llave.disiparAtaque(fieraSalvajeMock);

        // Assert
        assertEquals(danio.getValor(), danioEsperado);
        Mockito.verify(fieraSalvajeMock, times(1)).atacarContraEquipado(llave);
    }
}