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

public class SinEquipamientoTest {

    private FieraSalvaje fieraSalvajeMock;

    @BeforeEach
    public void setUp() {
        fieraSalvajeMock = Mockito.mock(FieraSalvaje.class);
    }

    @Test
    public void incrementarNadaRetornaUnEquipamientoCasco() {
        // Arrange
        SinEquipamiento sinEquipamiento = new SinEquipamiento();

        // Act
        Equipamiento equipoIncrementado = sinEquipamiento.incrementar();

        // Assert.
        // El quipo incrementado al disipar un ataque invoca fieraSalvaje.atacarContraEquipado(Nada nada);
        equipoIncrementado.disiparAtaque(fieraSalvajeMock);
        verify(fieraSalvajeMock, times(1))
                .atacarContraEquipado(ArgumentMatchers.isA(Casco.class));
    }

    @Test
    public void disiparAtaqueDeUnaFieraRetornaUnaEnergiaConValor0ComoDanio() {
        // Arrange
        SinEquipamiento sinEquipamiento = new SinEquipamiento();
        int danioEsperado = 20;

        Energia energiaMock = Mockito.mock(Energia.class);
        Mockito.when(energiaMock.getValor()).thenReturn(danioEsperado);

        Mockito.when(fieraSalvajeMock.atacarContraEquipado(sinEquipamiento))
                .thenReturn(energiaMock);

        // Act
        Energia danio = sinEquipamiento.disiparAtaque(fieraSalvajeMock);

        // Assert
        assertEquals(danioEsperado, danio.getValor());
        Mockito.verify(fieraSalvajeMock, times(1)).atacarContraEquipado(sinEquipamiento);
    }
}