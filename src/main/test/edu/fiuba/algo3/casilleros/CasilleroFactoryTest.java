package edu.fiuba.algo3.casilleros;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasilleroFactoryTest {

    @Test
    void construirCasillerosRetornaUnCasilleroInicialDoblementeEnlazadoDelTamanioCorrecto() {
        // Arrange
        CasilleroFactory casilleroFactory = new CasilleroFactory();
        ICasillero casillero = casilleroFactory.construirCasilleros(10);

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
        Throwable exception= Assertions.assertThrows(CasilleroInexistenteException.class,
                casillero::proximo);
        assertEquals("No hay casillero proximo al final", exception.getMessage());

        // Los ultimo 9 casilleros tienen casillero anterior
        for (int i = 10; i > 1; i--) {
            try {
                casillero = casillero.anterior();
            } catch (CasilleroInexistenteException e) {
                assert false;
            }
        }
        // El casillero inicial no tiene proximo anterior
        exception = Assertions.assertThrows(CasilleroInexistenteException.class,
                casillero::anterior);
        assertEquals("No hay casillero anterior al inicial", exception.getMessage());
    }
}