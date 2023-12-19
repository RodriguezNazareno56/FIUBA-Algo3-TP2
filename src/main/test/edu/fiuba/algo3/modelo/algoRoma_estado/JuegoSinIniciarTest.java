package edu.fiuba.algo3.modelo.algoRoma_estado;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.slf4j.Logger;

public class JuegoSinIniciarTest {

    AlgoRoma algoRoma;
    JuegoSinIniciar juegoSinIniciar;

    @BeforeEach
    public void setUp() throws Exception {
        algoRoma = Mockito.mock(AlgoRoma.class);

        juegoSinIniciar = new JuegoSinIniciar(algoRoma, Mockito.mock(Logger.class));
    }


    @Test
    public void seLlamaAJugarTurnoSegunEstadoConParametroDeTipoJuegoSinIniciarCuandoSeJuegaTurno() throws Exception {
        // Arrange
        // Act
        juegoSinIniciar.jugarTurno();
        // Assert
        Mockito.verify(algoRoma, Mockito.times(1)).jugarTurnoSegunEstado(Mockito.any(JuegoSinIniciar.class));
    }

    @Test
    public void seLLamaACambiarEstadoAJuegoEnCursoEnAlgoRomaCuandoSeJuegaTurno() throws Exception {
        // Arrange
        // Act
        juegoSinIniciar.jugarTurno();
        // Assert
        Mockito.verify(algoRoma, Mockito.times(1)).setEstadoJuego(Mockito.any(JuegoEnCurso.class));
    }
}
