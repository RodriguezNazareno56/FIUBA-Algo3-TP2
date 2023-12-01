package edu.fiuba.algo3.modelo.celda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordenadaTest {

    @Test
    public void testEqualsDosCoordenadasSonIgualesCuandoTieneMismoValorXeY() {
        Coordenada coordenada1 = new Coordenada(1,7);
        Coordenada coordenada2 = new Coordenada(1,7);

        // Assert
        assertEquals(coordenada1, coordenada2);
    }

    @Test
    public void testEqualsDosCoordenadasNoSonIgualesCuandoNoTieneMismoValorXeY() {
        Coordenada coordenada1 = new Coordenada(1,7);
        Coordenada coordenada2 = new Coordenada(1,2);

        // Assert
        assertNotEquals(coordenada1, coordenada2);
    }
}