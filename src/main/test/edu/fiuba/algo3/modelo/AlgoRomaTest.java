package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.modelo.dado.Dado;
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


    }

    @Test
    public void seJuegan20RondasEntoncesLaCantidadDeRondasEs20EnAlgoRoma() throws Exception {
        // Arrange
        algoRoma.agregarGladiador("Espartaco");
        algoRoma.agregarGladiador("Augusto");

        int cantidadRondasEsperadas = 20 ;

        // Considerando que hay 2 jugadores, se deben jugar 40 turnos para completar 19 rondas jugadas.
        // La siguiente es la 20
        for( int i=0 ; i < 41 ; i++ ) {
            algoRoma.jugarTurno();
        }
        // Assert
        assertEquals( cantidadRondasEsperadas, algoRoma.getRondasJugadas()  );

    }

    @Test
    public void seJueganMasDe30RondasSeLanzaExceptionFinDelJuego() throws Exception {
        // Arrange
        algoRoma.agregarGladiador("Espartaco");
        algoRoma.agregarGladiador("Augusto");
        // Considerando que hay 2 jugadores, se deben jugar 60 turnos
        for( int i=0 ; i < 60 ; i++ ) {
            algoRoma.jugarTurno();
        }
        // Assert
        assertThrows(FinDelJuegoException.class, algoRoma::jugarTurno);
    }


    @Test
    public void seAgreganMasDe6JugadoresSeLanzaMaximoGladiadoresException() throws Exception {
        // Arrange
        for( int i=1 ; i <= 6 ; i++ ) {
            algoRoma.agregarGladiador("Espartaco");
        }
        // Assert
        assertThrows(MaximoGladiadoresException.class,
                ()->{
                    algoRoma.agregarGladiador("Espartaco");
                });
    }

    @Test
    public void agregarGladiadoresEnUnJuegoQueSeHaJugadoUnTurnoLanzaJuegoEnCursoException() throws Exception {

        // Arrange
        algoRoma.agregarGladiador("Espartaco");
        algoRoma.agregarGladiador("Augusto");

        algoRoma.jugarTurno();
        // Assert
        assertThrows(JuegoEnCursoException.class,
                ()->{
                    algoRoma.agregarGladiador("Aurelio");
                });
    }

    @Test
    public void jugarTurnoConMenosDeDosGladiadoresLanzaMinimoGladiadoresException() throws Exception {
        // Arrange
        algoRoma.agregarGladiador("Espartaco");


        // Assert
        assertThrows(MinimoGladiadoresException.class,
                ()->{
                    algoRoma.jugarTurno();
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
        algoRoma.agregarGladiador("Espartaco");
        algoRoma.agregarGladiador("Augusto");
        for( int i=1 ; i <= 60 ; i++ ) {
            algoRoma.jugarTurno();

        }

        // Assert
        assertThrows(FinDelJuegoException.class,
                algoRoma::jugarTurno);
    }

    @Test
    public void noSePuedeAgregarUnJugadorConUnNombreDeMenosDe4Caracteres() throws Exception {
        // Assert
        assertThrows(NombreInvalidoException.class, () -> {
            algoRoma.agregarGladiador("Pol");
        });
    }
}
