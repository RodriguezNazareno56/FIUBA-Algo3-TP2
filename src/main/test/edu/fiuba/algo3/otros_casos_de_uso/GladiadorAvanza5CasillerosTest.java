package edu.fiuba.algo3.otros_casos_de_uso;

import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.celda.ICelda;
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

public class GladiadorAvanza5CasillerosTest {

    private Gladiador gladiador;
    private Mapa mapa;
    private List<ICelda> celdas;

    @BeforeEach
    public void setUp() {
        // Construyo un camino con 10 celdas
        this.celdas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            celdas.add(new Celda(new Coordenada(i,i), new ArrayList<>()));
        }
        Camino camino = new Camino(celdas);

        // Construyo un gladiador
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        this.gladiador = new Gladiador(energia, equipamiento, senority, Mockito.mock(Logger.class));

        // construyo un Mapa con el camino y el gladiador
        this.mapa = new Mapa(10, 10, camino);
        this.mapa.setGladiador(gladiador);
    }

    @Test
    public void gladiadorAvanzar5CasillerosAvanza5Casilleros() {
        // Act
        try {
            mapa.avanzarNPosicionesGladiador(this.gladiador, 5);
        } catch (Exception e) {
            assert false;
        }

        // Assert
        assertEquals(this.celdas.get(5), this.mapa.getPosicionDeGladiador(this.gladiador));
    }
}
