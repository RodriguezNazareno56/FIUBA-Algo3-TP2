package edu.fiuba.algo3.entrega_1;

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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso9Test {

    private Gladiador gladiador;
    private Mapa mapa;
    private List<ICelda> celdas;

    @BeforeEach
    public void setUp() {
        this.celdas = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            celdas.add(new Celda(new Coordenada(i,i), new ArrayList<>()));
        }
        List<Consecuencia> consecuencias = new ArrayList<>();
        Consecuencia triunfo = new Triunfo();
        consecuencias.add(triunfo);
        celdas.add(new Celda(new Coordenada(9,9), consecuencias));
        Camino camino = new Camino(celdas);

        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        this.gladiador = new Gladiador(energia, equipamiento, senority);

        this.mapa = new Mapa(10, 10, camino);
        this.mapa.setGladiador(gladiador);
    }

    @Test
    public void verificarQueSiLlegaALaMetaSinLaLlaveEnElEquipamientoRetrocedeALaMitadDeLasCasillas() {
        // Act
        mapa.avanzarNPosicionesGladiador(gladiador,10);

        // Assert
        // Al llegar al final sin la llave vuelve a mitad de las casillas
        assertEquals(this.celdas.get(5), mapa.getPosicionDeGladiador(gladiador));
    }
}
