package edu.fiuba.algo3.modelo.algoRomaEstado;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.excepciones.JuegoEnCursoException;
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
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        //Mockito.when(mapaService.cargarMapa()).thenReturn(Mockito.mock(Mapa.class));

        juegoEnCurso = new JuegoEnCurso(algoRoma, Mockito.mock(Logger.class), gladiadores);
    }

    @Test
    public void seLanzaJuegoEnCursoExceptionUCuandoSeAgregaUnGladiador() throws FinDelJuegoException {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        // Assert
        assertThrows(JuegoEnCursoException.class, () -> juegoEnCurso.agregarGladiador(gladiador) );
    }

    @Test
    public void seLlamaACambiarDeEstadoCuandoSeNotificaUnTriunfo() throws FinDelJuegoException {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);

        // Act
        juegoEnCurso.notificarTriunfo(gladiador);
        // Assert
        Mockito.verify(algoRoma, Mockito.times(1)).setEstadoJuego(Mockito.any(EstadoJuego.class));
    }
    




}
