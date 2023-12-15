package edu.fiuba.algo3.modelo.algoRomaEstado;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;




import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.ArrayList;

public class JuegoEnCursoTest {

    AlgoRoma algoRoma;
    JuegoEnCurso juegoEnCurso;

    @BeforeEach
    public void setUp() throws Exception {
        algoRoma = Mockito.mock(AlgoRoma.class);
        //Mockito.when(mapaService.cargarMapa()).thenReturn(Mockito.mock(Mapa.class));

        juegoEnCurso = new JuegoEnCurso(algoRoma, Mockito.mock(Logger.class));
    }

    @Test
    public void seLanzaJuegoEnCursoExceptionUCuandoSeAgregaUnGladiador() throws FinDelJuegoException {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        // Assert
        assertThrows(JuegoEnCursoException.class, () -> juegoEnCurso.agregarGladiador(gladiadores, gladiador) );
    }
    

    @Test
    public void seLLamaACambiarEstadoAJuegoTerminadoEnAlgoRomaCuandoSeAgregaUnTriunfo() {
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        Mockito.when(algoRoma.getRondasJugadas()).thenReturn(10);
        Mockito.when(algoRoma.getMaximaCantidadRondas()).thenReturn(30);
        //Act
        juegoEnCurso.agregarTriunfo(gladiador);
        // Arrange
        Mockito.verify(algoRoma, Mockito.times(1)).setEstadoJuego(Mockito.any(JuegoTerminado.class));

    }


}
