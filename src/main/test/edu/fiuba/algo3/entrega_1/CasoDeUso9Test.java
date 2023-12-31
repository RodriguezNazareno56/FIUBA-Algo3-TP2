package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import edu.fiuba.algo3.modelo.gladiador.exepciones.MovimientoException;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
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
    private int cantidadDeCeldas =  0;

    @BeforeEach
    public void setUp() throws NombreInvalidoException {
        // Construyo un camino con 9 celdas sin consecuencias y una celda final con consecuencia Triunfo
        this.celdas = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            celdas.add(new Celda(new Coordenada(i,i), new ArrayList<>()));
            cantidadDeCeldas++;
        }
        // Celda final con consecuencia Triunfo
        List<IConsecuencia> consecuencias = new ArrayList<>();
        IConsecuencia triunfo = new Triunfo();
        consecuencias.add(triunfo);
        celdas.add(new Celda(new Coordenada(9,9), consecuencias));
        cantidadDeCeldas++;
        Camino camino = new Camino(celdas);

        // Construyo un Gladiador
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        this.gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));

        // Construyo un mapa con el camino y el gladiador
        this.mapa = new Mapa(10, 10, camino);
        this.mapa.setGladiador(gladiador);
    }

    @Test
    public void verificarQueSiLlegaALaMetaSinLaLlaveEnElEquipamientoRetrocedeALaMitadDeLasCasillas() throws MovimientoException, FinDelJuegoException {
        // Act
        mapa.avanzarNPosicionesGladiador(gladiador, cantidadDeCeldas);

        // Assert
        // Al llegar al final sin la llave vuelve a mitad de las casillas. cantidadDeCeldas-1 por ser que el array empieza en 0
        ICelda mitadDeCaminoCelda = this.celdas.get((cantidadDeCeldas - 1) / 2);
        assertEquals(mitadDeCaminoCelda, mapa.getPosicionDeGladiador(gladiador));
    }
}
