package edu.fiuba.algo3.modelo.camino;

import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CaminoTest {

    private Camino camino;
    private ICelda celdaSalida;
    private ICelda celdaCamino;
    private ICelda celdaLlegada;

    @BeforeEach
    public void setUp() {
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
    public void getCasilleroSalida() {
        assertEquals(this.celdaSalida, this.camino.getCeldaSalida());
    }

    @Test
    public void proximoEn1Posicion() {
        // En un camino con 3 celdas, si avanzo 1 posiciones desde la celdaSalida termino en la celdaCamino
        ICelda celdaResultado = this.camino.proximoEnNPosiciones(this.celdaSalida, 1);
        assertEquals(this.celdaCamino, celdaResultado);
    }

    @Test
    public void proximoEn2Posiciones() {
        // En un camino con 3 celdas, si avanzo 2 posiciones desde la celdaSalida termino en la celdaLlegada
        ICelda celdaResultado = this.camino.proximoEnNPosiciones(this.celdaSalida, 2);
        assertEquals(this.celdaLlegada, celdaResultado);
    }

    @Test
    public void anteriorEn1Posicion() {
        // En un camino con 3 celdas, el anterior en 1 posicion desde la celdaLlegada es la celdaCamino
        ICelda celdaResultado = this.camino.anteriorEnNPosiciones(this.celdaLlegada, 1);
        assertEquals(this.celdaCamino, celdaResultado);
    }

    @Test
    public void anteriorEn2Posiciones() {
        // En un camino con 3 celdas, el anterior en 2 posiciones desde la celdaLlegada es la celdaSalida
        ICelda celdaResultado = this.camino.anteriorEnNPosiciones(this.celdaLlegada, 2);
        assertEquals(this.celdaSalida, celdaResultado);
    }

    @Test
    public void getMitadDeCamino() {
        // La mitad del camino es la CeldaCamino
        ICelda celdaResultado = this.camino.getMitadDeCamino();
        assertEquals(this.celdaCamino, celdaResultado);
    }

    @Test
    public void testEqualsDosCaminoSonIgualesCuandoTieneLasMismasCeldas() {
        Coordenada coordenadaCelda1 = new Coordenada(1, 2);
        List<IConsecuencia> consecuenciasCelda1 = new ArrayList<>();
        consecuenciasCelda1.add(new FieraSalvaje());
        ICelda celda1 = new Celda(coordenadaCelda1, consecuenciasCelda1);
        List<ICelda> celdas1= new ArrayList<>();
        celdas1.add(celda1);
        Camino camino1 = new Camino(celdas1);

        Coordenada coordenadaCelda2 = new Coordenada(1, 2);
        List<IConsecuencia> consecuenciasCelda2 = new ArrayList<>();
        consecuenciasCelda2.add(new FieraSalvaje());
        ICelda celda2 = new Celda(coordenadaCelda2, consecuenciasCelda2);
        List<ICelda> celdas2= new ArrayList<>();
        celdas2.add(celda2);
        Camino camino2 = new Camino(celdas2);

        assertEquals(camino1, camino2);
    }
}