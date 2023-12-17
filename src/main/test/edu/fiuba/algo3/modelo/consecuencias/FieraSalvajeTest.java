package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import edu.fiuba.algo3.modelo.equipamientos.*;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static edu.fiuba.algo3.modelo.constantes.FieraSalvajeConstantes.*;

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
        SinEquipamiento sinEquipamiento = Mockito.mock(SinEquipamiento.class);
        Mockito.when(sinEquipamiento.disiparAtaque(fieraSalvaje))
                .thenReturn(fieraSalvaje.atacarContraEquipado(sinEquipamiento));

        // Act
        Energia danio = fieraSalvaje.atacarATravesDelEquipamiento(sinEquipamiento);

        // Assert
        assertEquals(ATAQUE_CONTRA_EQUIPADO_SIN_EQUIPAMIENTO, danio.getValor());
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
        assertEquals(ATAQUE_CONTRA_EQUIPADO_CASCO, danio.getValor());
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
        assertEquals(ATAQUE_CONTRA_EQUIPADO_ARMADURA, danio.getValor());
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
        assertEquals(ATAQUE_CONTRA_EQUIPADO_ESCUDO_Y_ESPADA, danio.getValor());
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
        assertEquals(ATAQUE_CONTRA_EQUIPADO_LLAVE, danio.getValor());
        Mockito.verify(llave, times(1)).disiparAtaque(fieraSalvaje);
    }

    // Pruebas sin MOCK

    @Test
    public void unaFieraAtacaAUnGladiadorSinEquipamientoYLeResta20DeEnergia() throws NombreInvalidoException {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
        Energia energiaEsperada = new Energia(energia.getValor() - ATAQUE_CONTRA_EQUIPADO_SIN_EQUIPAMIENTO); //se le restan 20 puntos

        //Act
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unaFieraAtacaAUnGladiadorConCascoYLeResta15DeEnergia() throws NombreInvalidoException {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Casco();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
        Energia energiaEsperada = new Energia(energia.getValor() - ATAQUE_CONTRA_EQUIPADO_CASCO);  //se le restan 15 puntos

        //Act
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unaFieraAtacaAUnGladiadorConArmaduraYLeResta10DeEnergia() throws NombreInvalidoException {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Armadura();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
        Energia energiaEsperada = new Energia(energia.getValor() - ATAQUE_CONTRA_EQUIPADO_ARMADURA); //se le restan 10 puntos

        //Act
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unaFieraAtacaAUnGladiadorEscudoYEspadaYLeResta2DeEnergia() throws NombreInvalidoException {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new EscudoYEspada();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
        Energia energiaEsperada = new Energia(energia.getValor() - ATAQUE_CONTRA_EQUIPADO_ESCUDO_Y_ESPADA); // se le restan 2 puntos

        //Act
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unaFieraAtacaAUnGladiadorConLlaveYNoLeRestaEnergia() throws NombreInvalidoException {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Llave();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
        Energia energiaEsperada = new Energia(energia.getValor() - ATAQUE_CONTRA_EQUIPADO_LLAVE); // la energia queda igual

        //Act
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }
}