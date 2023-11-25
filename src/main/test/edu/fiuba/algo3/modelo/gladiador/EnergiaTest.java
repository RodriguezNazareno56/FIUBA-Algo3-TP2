package edu.fiuba.algo3.modelo.gladiador;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnergiaTest {

    @Test
    public void verificarQueAumentaLaCantidadDeEnergia(){

        //Arrange
        Energia energia = new Energia(10);
        Energia energiaAumentada = new Energia(7);
        int resultadoEsperadoAumentoDeEnergia = 17;

        //Act
        energia.aumentarEnergia(energiaAumentada);

        //Assert
        assertEquals(resultadoEsperadoAumentoDeEnergia, energia.getValor());

    }

    @Test
    public void verficarQuedisminuyeCantidadDeEnergia(){

        //Arrange
        Energia energia = new Energia(10);
        Energia energiaAumentada = new Energia(7);
        int resultadoEsperadoAumentoDeEnergia = 3;

        //Act
        energia.disminuirEnergia(energiaAumentada);

        //Assert
        assertEquals(resultadoEsperadoAumentoDeEnergia, energia.getValor());

    }

    @Test
    public void verficarQueSeInicializaELValorDeLaEnergia(){

        //Arrange
        Energia energia = new Energia(10);
        int valorInicialEsperadoDeLaEnergia = 10;

        //Act
        int energiaInicial = energia.getValor();

        //Assert
        assertEquals(valorInicialEsperadoDeLaEnergia, energiaInicial);
    }

    @Test
    void testEqualsDosObjetosEnergiaSonIgualesCuandoPoseenElMismoValor() {
        // Arrange
        Energia energiaUno = new Energia(10);
        Energia energiaDos = new Energia(10);

        // Assert
        assertEquals(energiaUno, energiaDos);
    }

    @Test
    void testEqualsDosObjetosEnergiaNoSonIgualesCuandoPoseenDistintosValor() {
        // Arrange
        Energia energiaUno = new Energia(10);
        Energia energiaDos = new Energia(20);

        // Assert
        assertNotEquals(energiaUno, energiaDos);
    }

    @Test
    void isAgotadaRetornaTrueSiElValorEs0() {
        // Arrange
        Energia energia = new Energia(0);

        // Assert
        assertTrue(energia.isAgotada());
    }

    @Test
    void isAgotadaRetornaFalseSiElValorEsMayorDe0() {
        // Arrange
        Energia energia = new Energia(10);

        // Assert
        assertFalse(energia.isAgotada());
    }

    @Test
    void isAgotadaRetornaTrueTrasSerDisminuidaA0() {
        // Arrange
        Energia energia = new Energia(10);

        // Act
        energia.disminuirEnergia(new Energia(10));

        // Assert
        assertTrue(energia.isAgotada());
    }
}
