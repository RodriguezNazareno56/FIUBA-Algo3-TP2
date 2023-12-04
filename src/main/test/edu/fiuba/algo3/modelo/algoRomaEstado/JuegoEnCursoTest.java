package edu.fiuba.algo3.modelo.algoRomaEstado;
import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoEnCurso;


import org.mockito.Mockito;
import org.slf4j.Logger;
public class JuegoEnCursoTest {

        private AlgoRoma algoRoma;
        private JuegoEnCurso juegoEnCurso;

        @BeforeEach
        public void setUp() throws Exception {
            algoRoma = Mockito.mock(AlgoRoma.class);
            //Mockito.when(mapaService.cargarMapa()).thenReturn(Mockito.mock(Mapa.class));

            juegoEnCurso = new JuegoEnCurso(algoRoma);
        }

        @Test
        public void seLanzaJuegoEnCursoExceptionUCuandoSeAgregaUnGladiador() throws FinDelJuegoException {
            // Arrange
            assertThrows(JuegoEnCursoException.class, () -> juegoEnCurso.agregarGladiador("Augusto") );
        }

        @Test void seLlamaAJugarTurnoSegunEstadoEnAlgoRomaCuandoSeJuegaTurno() throws Exception {
            // Arrange
            String nombre = "Espartaco";
            Mockito.when(algoRoma.getRondasJugadas()).thenReturn(1);
            Mockito.when(algoRoma.getMaximaCantidadRondas()).thenReturn(30);
            // Act
            juegoEnCurso.jugarTurno();
            // Assert
            Mockito.verify(algoRoma, Mockito.times(1)).jugarTurnoSegunEstado(Mockito.any(JuegoEnCurso.class));
        }

    @Test
    void jugarTurnoConRondasJugadasIgualesAMaximaRondasLlamaACambiarElEstadoAJuegoTerminado() throws Exception {
        // Arrange
        Mockito.when(algoRoma.getRondasJugadas()).thenReturn(30);
        Mockito.when(algoRoma.getMaximaCantidadRondas()).thenReturn(30);

        // Act
        juegoEnCurso.jugarTurno();

        // Assert
        Mockito.verify(algoRoma, Mockito.times(1)).setEstadoJuego(Mockito.any(JuegoTerminado.class));
    }

    @Test
    public void seLLamaACambiarEstadoAJuegoTerminadoEnAlgoRomaCuandoSeAgregaUnTriunfo() throws FinDelJuegoException {
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        Mockito.when(algoRoma.getRondasJugadas()).thenReturn(10);
        Mockito.when(algoRoma.getMaximaCantidadRondas()).thenReturn(30);
        //Act
        juegoEnCurso.agregarTriunfo(gladiador);
        // Arrange
        Mockito.verify(algoRoma, Mockito.times(1)).setEstadoJuego(Mockito.any(JuegoTerminado.class));

    }
}
