package edu.fiuba.algo3;

import edu.fiuba.algo3.casilleros.Casillero;
import edu.fiuba.algo3.casilleros.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasilleroTest {

    @Test
    void proximoEnNPosiciones() {
        // Arrange
        Tablero tablero = new Tablero();
        Casillero casilleroInicial = tablero.inicializarTablero(10);

        // Act
        Casillero casilleroProximoAlInicialEn5posiciones = casilleroInicial.proximoEnNPosiciones(5);
        Casillero casilleroProximoAlObtenidoEn3Posiciones = casilleroProximoAlInicialEn5posiciones
                .proximoEnNPosiciones(3);

        // Assert
        // El proximo al inicial (posicion 0) en 5 posiciones debe ser (posicion 5)
        assertEquals(casilleroProximoAlInicialEn5posiciones.getPosicion(), 5);
        // Al obtenedioAnteriormente (posicion 5) en 3 posiciones debe ser (posicion 8)
        assertEquals(casilleroProximoAlObtenidoEn3Posiciones.getPosicion(), 8);
    }
}