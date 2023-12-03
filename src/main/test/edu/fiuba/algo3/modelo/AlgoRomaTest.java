package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.slf4j.Logger;

public class AlgoRomaTest {

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
    public void seJuegan20RondasEntoncesLaCantidadDeRondasEs20EnAlgoRoma() throws Exception {
        // Arrange
        algoRoma.inicializarJuego();
        int cantidadRondasEsperadas = 20 ;

        // Considerando que hay 2 jugadores, se deben jugar 40 turnos para completar 19 rondas jugadas.
        // La siguiente es la 20
        for( int i=0 ; i < 41 ; i++ ) {
            algoRoma.jugarTurno();
        }
        // Assert
        assertEquals( cantidadRondasEsperadas, algoRoma.getCantidadRondas()  );

    }

    @Test
    public void seJueganMasDe30RondasSeLanzaExceptionFinDelJuego() throws Exception {
        // Arrange
        algoRoma.inicializarJuego();

        // Considerando que hay 2 jugadores, se deben jugar 60 turnos
        for( int i=0 ; i < 60 ; i++ ) {
            algoRoma.jugarTurno();
        }
        // Assert
        assertThrows(FinDelJuegoException.class, algoRoma::jugarTurno);
    }

    @Test
    public void seAgreganMasDe6JugadoresSeLanzaMaximoGladiadoresException(){
        // Considerando que en el setUp ya se han agregado 2. Agrego 4 mas
        for( int i=1 ; i <= 4 ; i++ ) {
            algoRoma.agregarGladiador("Espartaco");
        }
        // Assert
        assertThrows(MaximoGladiadoresException.class,
                ()->{
                    algoRoma.agregarGladiador("Espartaco");
                });
    }

    @Test
    public void agregarGladiadoresEnUnJuegoIniciadoLanzaJuegoEnCursoException() throws JsonFormatoInvalidoException {
        // Arrange
        algoRoma.inicializarJuego();

        // Assert
        assertThrows(JuegoEnCursoException.class,
                ()->{
                    algoRoma.agregarGladiador("Aurelio");
                });
    }

    // TODO: en principio no hay razon para este test
//    @Test
//    public void jugarTurnoSinInicializarLanzaJuegoNoIniciadoException(){
//        // Assert
//        assertThrows(JuegoNoIniciadoException.class,
//                algoRoma::jugarTurno);
//    }



    @Test
    public void jugarMasDe30RondasLanzaFinDelJuegoException() throws Exception {
        // Arrange
        algoRoma.inicializarJuego();

        for( int i=1 ; i <= 60 ; i++ ) {
            algoRoma.jugarTurno();

        }

        // Assert
        assertThrows(FinDelJuegoException.class,
                algoRoma::jugarTurno);
    }

}
