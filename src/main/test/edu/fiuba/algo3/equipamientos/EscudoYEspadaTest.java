package edu.fiuba.algo3.equipamientos;

import edu.fiuba.algo3.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.gladiador.Energia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class EscudoYEspadaTest {

    private FieraSalvaje fieraSalvajeMock;

    @BeforeEach
    public void setUp() {
        fieraSalvajeMock = Mockito.mock(FieraSalvaje.class);
    }

    @Test
    public void incrementarEscudoYEspadaRetornaUnEquipamientoLlave() {
        // Arrange
        EscudoYEspada escudoYEspada = new EscudoYEspada();

        // Act
        Equipamiento equipoIncrementado = escudoYEspada.incrementar();

        // Assert.
        // El quipo incrementado al disipar un ataque invoca fieraSalvaje.atacarContraEquipado(EscudoYEspada escudoYEspada);
        equipoIncrementado.disiparAtaque(fieraSalvajeMock);
        verify(fieraSalvajeMock, times(1))
                .atacarContraEquipado(ArgumentMatchers.isA(Llave.class));
    }

    @Test
    public void disiparAtaqueDeUnaFieraRetornaUnaEnergiaConValor2ComoDanio() {
        // Arrange
        EscudoYEspada escudoYEspada = new EscudoYEspada();
        int danioEsperado = 2;

        Energia energiaMock = Mockito.mock(Energia.class);
        Mockito.when(energiaMock.getValor()).thenReturn(danioEsperado);

        Mockito.when(fieraSalvajeMock.atacarContraEquipado(escudoYEspada))
                .thenReturn(energiaMock);

        // Act
        Energia danio = escudoYEspada.disiparAtaque(fieraSalvajeMock);

        // Assert
        assertEquals(danio.getValor(), danioEsperado);
        Mockito.verify(fieraSalvajeMock, times(1)).atacarContraEquipado(escudoYEspada);
    }
}