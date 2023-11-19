package edu.fiuba.algo3.gladiador;


import edu.fiuba.algo3.Gladiador.Energia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnergiaTest {

    @Test
    void verificarQueAumentaLaCantidadDeEnergia(){

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
    void verficarQuedisminuyeCantidadDeEnergia(){

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
    void verficarQueSeInicializaELValorDeLaEnergia(){

        //Arrange
        Energia energia = new Energia(10);
        int valorInicialEsperadoDeLaEnergia = 10;

        //Act
        int energiaInicial = energia.getValor();

        //Assert
        assertEquals(valorInicialEsperadoDeLaEnergia, energiaInicial);
    }

}
