package edu.fiuba.algo3.modelo.algoRomaEstado;
import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.mapa.Mapa;
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

        juegoSinIniciar = new JuegoSinIniciar(algoRoma);
    }

    @Test
    public void seLlamaAAgregarGladiadorEnListaCuandoSeAgregaUnGladiador() throws MaximoGladiadoresException {
        // Arrange
        String nombre = "Espartaco";
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        // Act
        juegoSinIniciar.agregarGladiador(gladiador);
        // Assert
        Mockito.verify(algoRoma, Mockito.times(1)).agregarGladiadorALaLista(gladiador);
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

    @Test
    public void seLanzaJuegoNoIniciadoExceptionCuandoSeAgregaUnTriunfo() throws FinDelJuegoException {
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        // Arrange
        assertThrows(JuegoNoIniciadoException.class, () -> juegoSinIniciar.agregarTriunfo(gladiador) );
    }
}
