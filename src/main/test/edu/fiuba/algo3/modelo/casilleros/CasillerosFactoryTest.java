package edu.fiuba.algo3.modelo.casilleros;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasillerosFactoryTest {

    @Test
    public void construirCasillerosRetornaUnCasilleroInicialDoblementeEnlazadoDelTamanioCorrecto() {
        // Arrange
        CasillerosFactory casillerosFactory = new CasillerosFactory();
        ICasillero casillero = casillerosFactory.construirCasilleros(10);

        // Assert
        // Compruebo que puedo recorrer la los casilleros en ambas direcciones

        // Los primeros 9 casilleros tienen casillero proximo
        for (int i = 1; i < 10; i++) {
            try {
                casillero = casillero.proximo();
            } catch (CasilleroInexistenteException e) {
                assert false;
            }
        }
        // El casillero final no tiene proximo
        Assertions.assertThrows(CasilleroInexistenteException.class, casillero::proximo);

        // Los ultimo 9 casilleros tienen casillero anterior
        for (int i = 10; i > 1; i--) {
            try {
                casillero = casillero.anterior();
            } catch (CasilleroInexistenteException e) {
                assert false;
            }
        }
        // El casillero inicial no tiene proximo anterior
        Assertions.assertThrows(CasilleroInexistenteException.class, casillero::anterior);
    }
}