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

    //TODO: Discutible sino tendria que mockiar Energia tambien

    @Test
    public void atacarATravesDeNadaCausaUnDanioDe20PuntosDeEnergia() {
        // Arrange
        Nada nada = Mockito.mock(Nada.class);
        Mockito.when(nada.disiparAtaque(fieraSalvaje))
                .thenReturn(fieraSalvaje.atacarContraEquipado(nada));

        // Act
        Energia danio = fieraSalvaje.atacarATravesDelEquipamiento(nada);

        // Assert
        assertEquals(danio.getValor(), 20);
        Mockito.verify(nada, times(1)).disiparAtaque(fieraSalvaje);
    }

    @Test
    public void atacarATravesDeUnCascoCausaUnDanioDe15PuntosDeEnergia() {
        // Arrange
        Casco casco = Mockito.mock(Casco.class);
        Mockito.when(casco.disiparAtaque(fieraSalvaje))
                .thenReturn(fieraSalvaje.atacarContraEquipado(casco));

        // Act
        Energia danio = fieraSalvaje.atacarATravesDelEquipamiento(casco);

        // Assert
        assertEquals(danio.getValor(), 15);
        Mockito.verify(casco, times(1)).disiparAtaque(fieraSalvaje);
    }

    @Test
    public void atacarATravesDeUnaArmaduraCausaUnDanioDe10PuntosDeEnergia() {
        // Arrange
        Armadura armadura = Mockito.mock(Armadura.class);
        Mockito.when(armadura.disiparAtaque(fieraSalvaje))
                .thenReturn(fieraSalvaje.atacarContraEquipado(armadura));

        // Act
        Energia danio = fieraSalvaje.atacarATravesDelEquipamiento(armadura);

        // Assert
        assertEquals(danio.getValor(), 10);
        Mockito.verify(armadura, times(1)).disiparAtaque(fieraSalvaje);
    }

    @Test
    public void atacarATravesDeUnEscudoYEspadaCausaUnDanioDe2PuntosDeEnergia() {
        // Arrange
        EscudoYEspada escudoYEspada = Mockito.mock(EscudoYEspada.class);
        Mockito.when(escudoYEspada.disiparAtaque(fieraSalvaje))
                .thenReturn(fieraSalvaje.atacarContraEquipado(escudoYEspada));

        // Act
        Energia danio = fieraSalvaje.atacarATravesDelEquipamiento(escudoYEspada);

        // Assert
        assertEquals(danio.getValor(), 2);
        Mockito.verify(escudoYEspada, times(1)).disiparAtaque(fieraSalvaje);
    }

    @Test
    public void atacarATravesDeUnaLlaveCausaUnDanioDe0PuntosDeEnergia() {
        // Arrange
        Llave llave = Mockito.mock(Llave.class);
        Mockito.when(llave.disiparAtaque(fieraSalvaje))
                .thenReturn(fieraSalvaje.atacarContraEquipado(llave));

        // Act
        Energia danio = fieraSalvaje.atacarATravesDelEquipamiento(llave);

        // Assert
        assertEquals(danio.getValor(), 0);
        Mockito.verify(llave, times(1)).disiparAtaque(fieraSalvaje);
    }
}