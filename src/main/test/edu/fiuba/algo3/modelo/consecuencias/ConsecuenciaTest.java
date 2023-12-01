package edu.fiuba.algo3.modelo.consecuencias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsecuenciaTest {

    @Test
    public void testEqualsDosConsecuenciasSonIgualesCuandoSonDelMismoTipo() {
        FieraSalvaje fieraSalvaje1 = new FieraSalvaje();
        FieraSalvaje fieraSalvaje2 = new FieraSalvaje();

        assertEquals(fieraSalvaje1, fieraSalvaje2);
    }

    @Test
    public void testEqualsDosConsecuenciasNoSonIgualesCuandoNoSonDelMismoTipo() {
        FieraSalvaje fieraSalvaje = new FieraSalvaje();
        Comida comida = new Comida();

        assertNotEquals(fieraSalvaje, comida);
    }
}