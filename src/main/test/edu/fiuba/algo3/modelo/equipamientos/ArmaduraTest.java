package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.constantes.FieraSalvajeConstantes;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ArmaduraTest {

    private FieraSalvaje fieraSalvajeMock;

    @BeforeEach
    public void setUp() {
        fieraSalvajeMock = Mockito.mock(FieraSalvaje.class);
    }

    @Test
    public void incrementarArmaduraRetornaUnEquipamientoEscudoYEspada() {
        // Arrange
        Armadura armadura = new Armadura();

        // Act
        Equipamiento equipoIncrementado = armadura.incrementar();

        // Assert.
        // El quipo incrementado al disipar un ataque invoca fieraSalvaje.atacarContraEquipado(EscudoYEspada escudoYEspada);
        equipoIncrementado.disiparAtaque(fieraSalvajeMock);
        verify(fieraSalvajeMock, times(1))
                .atacarContraEquipado(ArgumentMatchers.isA(EscudoYEspada.class));
    }

    @Test
    public void disiparAtaqueDeUnaFieraRetornaUnaEnergiaConValor10ComoDanio() {
        // Arrange
        Armadura armadura = new Armadura();
        int danioEsperado = FieraSalvajeConstantes.ATAQUE_CONTRA_EQUIPADO_ARMADURA;

        Energia energiaMock = Mockito.mock(Energia.class);
        Mockito.when(energiaMock.getValor()).thenReturn(danioEsperado);

        Mockito.when(fieraSalvajeMock.atacarContraEquipado(armadura))
                .thenReturn(energiaMock);

        // Act
        Energia danio = armadura.disiparAtaque(fieraSalvajeMock);

        // Assert
        assertEquals(danioEsperado, danio.getValor());
        Mockito.verify(fieraSalvajeMock, times(1)).atacarContraEquipado(armadura);
    }

}