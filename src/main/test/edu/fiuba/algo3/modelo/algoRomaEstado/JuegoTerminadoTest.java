package edu.fiuba.algo3.modelo.algoRomaEstado;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.ArrayList;

public class JuegoTerminadoTest {

    AlgoRoma algoRoma;
    JuegoTerminado juegoTerminado;



    @BeforeEach
    public void setUp() throws Exception {
        algoRoma = Mockito.mock(AlgoRoma.class);
        //Mockito.when(mapaService.cargarMapa()).thenReturn(Mockito.mock(Mapa.class));

        juegoTerminado = new JuegoTerminado(algoRoma, Mockito.mock(Logger.class));
    }

    @Test
    public void seLanzaUnaExcepcionCuandoSeAgregaUnGladiador() throws FinDelJuegoException {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        // Assert
        assertThrows(FinDelJuegoException.class, () -> juegoTerminado.agregarGladiador(gladiador) );
    }

    @Test
    public void seLanzaUnaExcepcionCuandoSeJuegaUnTurnoYAlgoRomaNoAlcanzoElLimiteDeRondas() throws FinDelJuegoException {
        Mockito.when(algoRoma.getRondasJugadas()).thenReturn(1);
        Mockito.when(algoRoma.getMaximaCantidadRondas()).thenReturn(15);
        // Arrange
        // Assert
        assertThrows(FinDelJuegoException.class, () -> juegoTerminado.jugarTurno() );
    }


}
