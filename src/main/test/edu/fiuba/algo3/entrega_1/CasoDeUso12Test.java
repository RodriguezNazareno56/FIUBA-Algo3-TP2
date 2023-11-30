package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso12Test {

    AlgoRoma algoRoma;

    @BeforeEach
    public void setUp() throws Exception {
        MapaService mapaService = Mockito.mock(MapaService.class);
        Mockito.when(mapaService.cargarMapa()).thenReturn(Mockito.mock(Mapa.class));

        Dado dado = Mockito.mock(Dado.class);

        this.algoRoma = new AlgoRoma(mapaService, dado, Mockito.mock(Logger.class));

        algoRoma.agregarGladiador("Espartaco");
        algoRoma.agregarGladiador("Augusto");
    }

    @Test
    public void verificarQueSiPasan30TurnosYNadieLlegoALaMetaSeTerminaElJuego() throws Exception {
        // Arrange
        algoRoma.inicializarJuego();

        // Considerando que hay 2 jugadores, se deben jugar 60 turnos
        for( int i=0 ; i < 60 ; i++ ) {
            algoRoma.jugarTurno();
        }
        // Assert
        assertThrows(FinDelJuegoException.class, algoRoma::jugarTurno);
    }
}
