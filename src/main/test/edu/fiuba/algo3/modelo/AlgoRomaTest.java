package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void pedirDosVecesLosGladiadoresEnOrdenDeRondaDevuelveElMismoOrden() throws Exception {
        algoRoma.agregarGladiador("Espartaco");
        algoRoma.agregarGladiador("Augusto");
        algoRoma.agregarGladiador("Maximo");
        algoRoma.agregarGladiador("Poncio");

        assertEquals(algoRoma.getNombresGladiadoresSegunOrdenEnRonda(), algoRoma.getNombresGladiadoresSegunOrdenEnRonda());
    }

    @Test
    public void pedirLosGladiadoresEnOrdenDeIngresoDevuelveLosNombresDeLosGladiadoresEnOrden() throws Exception {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Espartaco");
        nombres.add("Augusto");
        nombres.add("Maximo");
        nombres.add("Poncio");

        algoRoma.agregarGladiador(nombres.get(0));
        algoRoma.agregarGladiador(nombres.get(1));
        algoRoma.agregarGladiador(nombres.get(2));
        algoRoma.agregarGladiador(nombres.get(3));

        //act
        ArrayList<String> nombreEnOrdenDeIngreso = algoRoma.getNombresGladiadoresSegunOrdenDeIngreso();

        //assert
        assertEquals(nombres, nombreEnOrdenDeIngreso);
    }

    @Test
    public void pedirLosGladiadoresEnOrdenDeRondaDevuelveLosGladiadoresEnSentidoLineal() throws Exception {
        //Arrange
        ArrayList<String> nombresEnOrdenDeIngreso = new ArrayList<>();
        nombresEnOrdenDeIngreso.add("Espartaco");
        nombresEnOrdenDeIngreso.add("Augusto");
        nombresEnOrdenDeIngreso.add("Maximo");
        nombresEnOrdenDeIngreso.add("Poncio");

        algoRoma.agregarGladiador(nombresEnOrdenDeIngreso.get(0));
        algoRoma.agregarGladiador(nombresEnOrdenDeIngreso.get(1));
        algoRoma.agregarGladiador(nombresEnOrdenDeIngreso.get(2));
        algoRoma.agregarGladiador(nombresEnOrdenDeIngreso.get(3));


        //Act
        ArrayList<String> nombresEnOrdenDeRonda = algoRoma.getNombresGladiadoresSegunOrdenEnRonda();

        String primerNombreEnLaRonda = nombresEnOrdenDeRonda.get(0);
        int indiceCorrespondienteAlIngreso = nombresEnOrdenDeIngreso.indexOf( primerNombreEnLaRonda );

        //Assert
        for (String nombreEnLaRonda : nombresEnOrdenDeRonda) {

            String nombreEnElIngreso = nombresEnOrdenDeIngreso.get( indiceCorrespondienteAlIngreso );

            assertEquals( nombreEnElIngreso, nombreEnLaRonda );

            indiceCorrespondienteAlIngreso++;
            if (indiceCorrespondienteAlIngreso == nombresEnOrdenDeIngreso.size()) {
                indiceCorrespondienteAlIngreso = 0;
            }
        }

    }

    @Test
    public void getNombresGladiadoresEnOrdenDeRondaDevuelveUnaListaVaciaSiNoAgregueGladiadores(){

        //Act
        List<String> nombresEnOrdenDeRonda = algoRoma.getNombresGladiadoresSegunOrdenEnRonda();

        //Assert
        //voy a comprobar que el mensaje isEmpty devuelve true

        assertTrue(nombresEnOrdenDeRonda.isEmpty());

    }

    @Test
    public void getRondasJugadasDevuelveCeroCuandoIniciaElJuego() {
        // Arrange
        int rondasJugadasEsperadas = 0;
        // Act
        int rondasJugadas = algoRoma.getRondasJugadas();
        // Assert
        assertEquals(rondasJugadasEsperadas, rondasJugadas);
    }

    @Test
    public void getRondasJugadasDevuelve1LuegoDeJugarUnaRondaYQueJuegueUnGladiador() throws Exception {
        // Arrange
        algoRoma.agregarGladiador("Espartaco");
        algoRoma.agregarGladiador("Augusto");
        // Act
        algoRoma.jugarTurno();
        algoRoma.jugarTurno();
        algoRoma.jugarTurno();

        int rondasJugadasEsperadas = 1;

        // Assert
        assertEquals(rondasJugadasEsperadas, algoRoma.getRondasJugadas());
    }

}
