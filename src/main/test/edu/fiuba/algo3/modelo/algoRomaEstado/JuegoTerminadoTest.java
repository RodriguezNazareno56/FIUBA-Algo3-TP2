package edu.fiuba.algo3.modelo.algoRomaEstado;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class JuegoTerminadoTest {

    AlgoRoma algoRoma;
    JuegoTerminado juegoTerminado;



    @BeforeEach
    public void setUp() throws Exception {
        algoRoma = Mockito.mock(AlgoRoma.class);
        //Mockito.when(mapaService.cargarMapa()).thenReturn(Mockito.mock(Mapa.class));

        juegoTerminado = new JuegoTerminado(algoRoma);
    }

    @Test
    public void seLanzaUnaExcepcionCuandoSeAgregaUnGladiador() throws FinDelJuegoException {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        // Assert
        assertThrows(FinDelJuegoException.class, () -> juegoTerminado.agregarGladiador(gladiador) );
    }

    @Test
    public void seLlamaAJugarTurnoSegunEstadoCuandoSeJuegaUnTurno() throws FinDelJuegoException {

        juegoTerminado.jugarTurno();
        // assert
        Mockito.verify(algoRoma, Mockito.times(1)).jugarTurnoSegunEstado(Mockito.any(JuegoTerminado.class));

    }

    @Test
    public void seLanzaUnaFinDeJuegoExcepctionCuandoSeAgregaUnTriunfo() throws FinDelJuegoException {
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        // Arrange
        assertThrows(FinDelJuegoException.class, () -> juegoTerminado.agregarTriunfo(gladiador) );
    }
}
