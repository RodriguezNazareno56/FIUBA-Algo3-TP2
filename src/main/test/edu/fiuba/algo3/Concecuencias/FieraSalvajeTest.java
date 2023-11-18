package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Equipamientos.*;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

public class FieraSalvajeTest {

    private FieraSalvaje fieraSalvaje;

    @BeforeEach
    public void setUp() {
        fieraSalvaje = new FieraSalvaje();
    }

    @Test
    public void afectarGladiador() {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);

        // Act
        fieraSalvaje.afectarGladiador(gladiador);

        // Assert
        Mockito.verify(gladiador, times(1)).recibirAtaque(fieraSalvaje);
    }

    @Test
    public void atacarATravesDeNadaCausaUnDanioDe20PuntosDeEnergia() {
        // Arrange
        Equipamiento nada = Mockito.mock(Nada.class);
        Mockito.when(nada.disiparAtaque(fieraSalvaje))
                .thenReturn(fieraSalvaje.atacarContraEquipadoConCasco());

        // Act
        Energia danio = fieraSalvaje.atacarATravesDelEquipamiento(nada);

        // Assert
        assertEquals(danio.getValor(), 15);
        Mockito.verify(nada, times(1)).disiparAtaque(fieraSalvaje);
    }

    @Test
    public void atacarATravesDeUnCascoCausaUnDanioDe15PuntosDeEnergia() {
        // Arrange
        Equipamiento casco = Mockito.mock(Casco.class);
        Mockito.when(casco.disiparAtaque(fieraSalvaje))
                .thenReturn(fieraSalvaje.atacarContraEquipadoConCasco());

        // Act
        Energia danio = fieraSalvaje.atacarATravesDelEquipamiento(casco);

        // Assert
        assertEquals(danio.getValor(), 15);
        Mockito.verify(casco, times(1)).disiparAtaque(fieraSalvaje);
    }

    @Test
    public void atacarATravesDeUnaArmaduraCausaUnDanioDe10PuntosDeEnergia() {
        // Arrange
        Equipamiento armadura = Mockito.mock(Armadura.class);
        Mockito.when(armadura.disiparAtaque(fieraSalvaje))
                .thenReturn(fieraSalvaje.atacarContraEquipadoConArmadura());

        // Act
        Energia danio = fieraSalvaje.atacarATravesDelEquipamiento(armadura);

        // Assert
        assertEquals(danio.getValor(), 10);
        Mockito.verify(armadura, times(1)).disiparAtaque(fieraSalvaje);
    }

    @Test
    public void atacarATravesDeUnEscudoYEspadaCausaUnDanioDe2PuntosDeEnergia() {
        // Arrange
        Equipamiento escudoYEspada = Mockito.mock(EscudoYEspada.class);
        Mockito.when(escudoYEspada.disiparAtaque(fieraSalvaje))
                .thenReturn(fieraSalvaje.atacarContraEquipadoConEscudoYEspada());

        // Act
        Energia danio = fieraSalvaje.atacarATravesDelEquipamiento(escudoYEspada);

        // Assert
        assertEquals(danio.getValor(), 2);
        Mockito.verify(escudoYEspada, times(1)).disiparAtaque(fieraSalvaje);
    }

    @Test
    public void atacarATravesDeUnaLlaveCausaUnDanioDe0PuntosDeEnergia() {
        // Arrange
        Equipamiento llave = Mockito.mock(Llave.class);
        Mockito.when(llave.disiparAtaque(fieraSalvaje))
                .thenReturn(fieraSalvaje.atacarContraEquipadoConLLave());

        // Act
        Energia danio = fieraSalvaje.atacarATravesDelEquipamiento(llave);

        // Assert
        assertEquals(danio.getValor(), 0);
        Mockito.verify(llave, times(1)).disiparAtaque(fieraSalvaje);
    }
}