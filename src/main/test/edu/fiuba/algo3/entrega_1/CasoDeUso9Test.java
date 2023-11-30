package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.MovimientoPausadoExeption;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;
import edu.fiuba.algo3.modelo.consecuencias.Triunfo;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso9Test {

    private Gladiador gladiador;
    private Mapa mapa;
    private List<ICelda> celdas;
    private int cantidadDeCasillero =  0;

    @BeforeEach
    public void setUp() {
        // Construyo un camino con 9 celdas sin consecuencias y una celda final con consecuencia Triunfo
        this.celdas = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            celdas.add(new Celda(new Coordenada(i,i), new ArrayList<>()));
            cantidadDeCasillero++;
        }
        // Celda final con consecuencia Triunfo
        List<Consecuencia> consecuencias = new ArrayList<>();
        Consecuencia triunfo = new Triunfo();
        consecuencias.add(triunfo);
        celdas.add(new Celda(new Coordenada(9,9), consecuencias));
        cantidadDeCasillero++;
        Camino camino = new Camino(celdas);

        // Construyo un Gladiador
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        this.gladiador = new Gladiador(energia, equipamiento, senority, Mockito.mock(Logger.class));

        // Construyo un mapa con el camino y el gladiador
        this.mapa = new Mapa(10, 10, camino);
        this.mapa.setGladiador(gladiador);
    }

    @Test
    public void verificarQueSiLlegaALaMetaSinLaLlaveEnElEquipamientoRetrocedeALaMitadDeLasCasillas() throws MovimientoPausadoExeption, MovimientoException {
        // Act
        mapa.avanzarNPosicionesGladiador(gladiador,cantidadDeCasillero);

        // Assert
        // Al llegar al final sin la llave vuelve a mitad de las casillas. cantidadDeCasillero-1 por ser que el array empieza en 0
        // TODO: se podria ver mejor este asserEquals
        assertEquals(this.celdas.get((cantidadDeCasillero-1)/2), mapa.getPosicionDeGladiador(gladiador));
    }
}
