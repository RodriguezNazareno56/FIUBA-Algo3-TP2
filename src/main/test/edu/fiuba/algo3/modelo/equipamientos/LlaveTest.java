package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.gladiador.Energia;
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
        int danioEsperado = FieraSalvaje.ATAQUE_CONTRA_EQUIPADO_LLAVE;

        Energia energiaMock = Mockito.mock(Energia.class);
        Mockito.when(energiaMock.getValor()).thenReturn(danioEsperado);

        Mockito.when(fieraSalvajeMock.atacarContraEquipado(llave))
                .thenReturn(energiaMock);

        // Act
        Energia danio = llave.disiparAtaque(fieraSalvajeMock);

        // Assert
        assertEquals(danioEsperado, danio.getValor());
        Mockito.verify(fieraSalvajeMock, times(1)).atacarContraEquipado(llave);
    }
}