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
        // Assert
        assertThrows(JuegoEnCursoException.class, () -> juegoEnCurso.agregarGladiador(gladiador) );
    }
    




}
