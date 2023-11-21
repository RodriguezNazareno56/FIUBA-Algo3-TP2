package edu.fiuba.algo3;

import edu.fiuba.algo3.casilleros.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasilleroTest {

    @Test
    void proximoEnNPosiciones() throws Exception {
        // Arrange
        CasilleroFactory casilleroFactory = new CasilleroFactory();
        ICasillero casilleroInicial = casilleroFactory.construirCasilleros(10);

        // Act
        ICasillero casilleroProximoEn5Posiciones = casilleroInicial.proximoEnNPosiciones(5);

        // Assert
        // Partiendo del casilleroInicial (posicion 0) pido el proximo en 5 posiciones retorna casillero(posicion5)
        assertEquals(casilleroProximoEn5Posiciones.getPosicion(), 5);
    }

    @Test
    void anteriorEnNPosiciones() throws Exception {
        // Arrange
        CasilleroFactory casilleroFactory = new CasilleroFactory();
        ICasillero casilleroInicial = casilleroFactory.construirCasilleros(10);

        // Act
        ICasillero casilleroProximoEn5Posiciones = casilleroInicial.proximoEnNPosiciones(5);
        ICasillero casilleroAnteriorEn2Posiciones = casilleroProximoEn5Posiciones.anteriorEnNPosiciones(2);

        // Assert
        // Partiendo del casilleroInicial (posicion 0) pido el proximo en 5 (posicion5), pido el anterior en 2 obtengo
        // casillero (posicion 3)
        assertEquals(casilleroAnteriorEn2Posiciones.getPosicion(), 3);
    }

    @Test
    void obtenerAnteriorAlCasilleroInicial() {
        ICasillero casillero = new CasilleroInicial(0);
        Throwable exception= Assertions.assertThrows(Exception.class, () -> {
            casillero.anterior();
        });
        assertEquals("No hay casillero anterior al inicial", exception.getMessage());
    }

    @Test
    void obtenerProximoAlCasilleroFinal() {
        ICasillero casillero = new CasilleroFinal(1, new Casillero(0));
        Throwable exception= Assertions.assertThrows(Exception.class, () -> {
            casillero.proximo();
        });
        assertEquals("No hay casillero proximo al final", exception.getMessage());
    }

    @Test
    void proximoEn5PosicionesDeUnTableroDe4PosicionesTerminaEnElFinal() throws Exception { //TODO: Que es un tablero?
        // Arrange
        CasilleroFactory casilleroFactory = new CasilleroFactory();
        ICasillero casilleroInicial = casilleroFactory.construirCasilleros(4);

        // Act
        ICasillero casilleroProximoAlInicialEn5posiciones = casilleroInicial.proximoEnNPosiciones(5);

        // Assert
        // El proximo al inicial (posicion 0) en 5 posiciones debe ser (posicion 3) en un tablero de 4 posiciones
        // no se sale del tablero
        assertEquals(casilleroProximoAlInicialEn5posiciones.getPosicion(), 3);
    }

    @Test
    void anteriorEn5PosicionesDeUnTableroDe4PosicionesTerminaEnElInicio() throws Exception { //TODO: Que es un tablero?
        // Arrange
        CasilleroFactory casilleroFactory = new CasilleroFactory();
        ICasillero casilleroInicial = casilleroFactory.construirCasilleros(4);
        ICasillero casilleroFinal = casilleroInicial.proximoEnNPosiciones(4);
        assertEquals(casilleroFinal.getPosicion(), 3);

        // Act
        ICasillero casilleroAnteriorAlFinalEn5posiciones = casilleroInicial.anteriorEnNPosiciones(5);

        // Assert
        // El anterior al Final (posicion 3) en 5 posiciones debe ser (posicion 0) en un tablero de 4 posiciones
        // no se sale del tablero
        assertEquals(casilleroAnteriorAlFinalEn5posiciones.getPosicion(), 0);
    }
}