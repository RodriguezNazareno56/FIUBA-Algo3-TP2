package edu.fiuba.algo3.consecuencias;

import edu.fiuba.algo3.casilleros.Casillero;
import edu.fiuba.algo3.equipamientos.*;
import edu.fiuba.algo3.gladiador.Energia;
import edu.fiuba.algo3.gladiador.Gladiador;
import edu.fiuba.algo3.gladiador.senority.Novato;
import edu.fiuba.algo3.gladiador.senority.Senority;
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
        SinEquipamiento sinEquipamiento = Mockito.mock(SinEquipamiento.class);
        Mockito.when(sinEquipamiento.disiparAtaque(fieraSalvaje))
                .thenReturn(fieraSalvaje.atacarContraEquipado(sinEquipamiento));

        // Act
        Energia danio = fieraSalvaje.atacarATravesDelEquipamiento(sinEquipamiento);

        // Assert
        assertEquals(danio.getValor(), 20);
        Mockito.verify(sinEquipamiento, times(1)).disiparAtaque(fieraSalvaje);
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

    // Pruebas sin MOCK

    @Test
    public void unaFieraAtacaAUnGladiadorSinEquipamientoYLeResta20DeEnergia() {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);
        int energiaEsperada = 0; //se le restan 20 puntos

        //Act
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unaFieraAtacaAUnGladiadorConCascoYLeResta15DeEnergia() {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Casco();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);
        int energiaEsperada = 5;  //se le restan 15 puntos

        //Act
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unaFieraAtacaAUnGladiadorConArmaduraYLeResta10DeEnergia() {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Armadura();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);
        int energiaEsperada = 10; //se le restan 10 puntos

        //Act
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unaFieraAtacaAUnGladiadorEscudoYEspadaYLeResta2DeEnergia() {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new EscudoYEspada();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);
        int energiaEsperada = 18; // se le restan 2 puntos

        //Act
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unaFieraAtacaAUnGladiadorConLlaveYNoLeRestaEnergia() {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Llave();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);
        int energiaEsperada = 20; // la energia queda igual

        //Act
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }
}