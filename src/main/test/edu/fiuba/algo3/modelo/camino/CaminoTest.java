package edu.fiuba.algo3.modelo.camino;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.celda.ICelda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CaminoTest {

    private Camino camino;
    private ICelda celdaSalida;
    private ICelda celdaCamino;
    private ICelda celdaLlegada;

    @BeforeEach
    void setUp() {
        List<ICelda> celdas = new ArrayList<>();
        this.celdaSalida = Mockito.mock(Celda.class);
        celdas.add(celdaSalida);
        this.celdaCamino = Mockito.mock(Celda.class);
        celdas.add(celdaCamino);
        this.celdaLlegada = Mockito.mock(Celda.class);
        celdas.add(celdaLlegada);

        this.camino = new Camino(celdas);
    }

    @Test
    void getCasilleroSalida() {
        assertEquals(this.celdaSalida, this.camino.getCasilleroSalida());
    }

    @Test
    void proximoEn1Posicion() {
        // En un camino con 3 celdas, si avanzo 1 posiciones desde la celdaSalida termino en la celdaCamino
        ICelda celdaResultado = this.camino.proximoEnNPosiciones(this.celdaSalida, 1);
        assertEquals(this.celdaCamino, celdaResultado);
    }

    @Test
    void proximoEn2Posiciones() {
        // En un camino con 3 celdas, si avanzo 2 posiciones desde la celdaSalida termino en la celdaLlegada
        ICelda celdaResultado = this.camino.proximoEnNPosiciones(this.celdaSalida, 2);
        assertEquals(this.celdaLlegada, celdaResultado);
    }

    @Test
    void anteriorEn1Posicion() {
        // En un camino con 3 celdas, el anterior en 1 posicion desde la celdaLlegada es la celdaCamino
        ICelda celdaResultado = this.camino.anteriorEnNPosiciones(this.celdaLlegada, 1);
        assertEquals(this.celdaCamino, celdaResultado);
    }

    @Test
    void anteriorEn2Posiciones() {
        // En un camino con 3 celdas, el anterior en 2 posiciones desde la celdaLlegada es la celdaSalida
        ICelda celdaResultado = this.camino.anteriorEnNPosiciones(this.celdaLlegada, 2);
        assertEquals(this.celdaSalida, celdaResultado);
    }

    @Test
    void getMitadDeCamino() {
        // La mitad del camino es la CeldaCamino
        ICelda celdaResultado = this.camino.getMitadDeCamino();
        assertEquals(this.celdaCamino, celdaResultado);
    }
}