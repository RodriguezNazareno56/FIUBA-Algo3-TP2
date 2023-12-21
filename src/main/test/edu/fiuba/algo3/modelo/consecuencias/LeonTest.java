package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.equipamientos.*;
import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static edu.fiuba.algo3.modelo.constantes.LeonConstantes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

public class LeonTest {

    private Leon leon;

    @BeforeEach
    public void setUp() {
        leon = new Leon();
    }

    @Test
    public void afectarGladiador() {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);

        // Act
        leon.afectarGladiador(gladiador);

        // Assert
        Mockito.verify(gladiador, times(1)).recibirAtaque(leon);
    }

    @Test
    public void atacarATravesDeNadaCausaUnDanioDe20PuntosDeEnergia() {
        // Arrange
        SinEquipamiento sinEquipamiento = Mockito.mock(SinEquipamiento.class);
        Mockito.when(sinEquipamiento.disiparAtaque(leon))
                .thenReturn(leon.atacarContraEquipado(sinEquipamiento));

        // Act
        Energia danio = leon.atacarATravesDelEquipamiento(sinEquipamiento);

        // Assert
        assertEquals(ATAQUE_CONTRA_EQUIPADO_SIN_EQUIPAMIENTO, danio.getValor());
        Mockito.verify(sinEquipamiento, times(1)).disiparAtaque(leon);
    }

    @Test
    public void atacarATravesDeUnCascoCausaUnDanioDe15PuntosDeEnergia() {
        // Arrange
        Casco casco = Mockito.mock(Casco.class);
        Mockito.when(casco.disiparAtaque(leon))
                .thenReturn(leon.atacarContraEquipado(casco));

        // Act
        Energia danio = leon.atacarATravesDelEquipamiento(casco);

        // Assert
        assertEquals(ATAQUE_CONTRA_EQUIPADO_CASCO, danio.getValor());
        Mockito.verify(casco, times(1)).disiparAtaque(leon);
    }

    @Test
    public void atacarATravesDeUnaArmaduraCausaUnDanioDe10PuntosDeEnergia() {
        // Arrange
        Armadura armadura = Mockito.mock(Armadura.class);
        Mockito.when(armadura.disiparAtaque(leon))
                .thenReturn(leon.atacarContraEquipado(armadura));

        // Act
        Energia danio = leon.atacarATravesDelEquipamiento(armadura);

        // Assert
        assertEquals(ATAQUE_CONTRA_EQUIPADO_ARMADURA, danio.getValor());
        Mockito.verify(armadura, times(1)).disiparAtaque(leon);
    }

    @Test
    public void atacarATravesDeUnEscudoYEspadaCausaUnDanioDe2PuntosDeEnergia() {
        // Arrange
        EscudoYEspada escudoYEspada = Mockito.mock(EscudoYEspada.class);
        Mockito.when(escudoYEspada.disiparAtaque(leon))
                .thenReturn(leon.atacarContraEquipado(escudoYEspada));

        // Act
        Energia danio = leon.atacarATravesDelEquipamiento(escudoYEspada);

        // Assert
        assertEquals(ATAQUE_CONTRA_EQUIPADO_ESCUDO_Y_ESPADA, danio.getValor());
        Mockito.verify(escudoYEspada, times(1)).disiparAtaque(leon);
    }

    @Test
    public void atacarATravesDeUnaLlaveCausaUnDanioDe0PuntosDeEnergia() {
        // Arrange
        Llave llave = Mockito.mock(Llave.class);
        Mockito.when(llave.disiparAtaque(leon))
                .thenReturn(leon.atacarContraEquipado(llave));

        // Act
        Energia danio = leon.atacarATravesDelEquipamiento(llave);

        // Assert
        assertEquals(ATAQUE_CONTRA_EQUIPADO_LLAVE, danio.getValor());
        Mockito.verify(llave, times(1)).disiparAtaque(leon);
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
        leon.afectarGladiador(gladiador);

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
        leon.afectarGladiador(gladiador);

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
        leon.afectarGladiador(gladiador);

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
        leon.afectarGladiador(gladiador);

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
        leon.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

}
