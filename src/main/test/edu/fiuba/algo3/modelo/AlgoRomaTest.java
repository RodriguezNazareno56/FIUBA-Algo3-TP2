package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AlgoRomaTest {

    @Test
    public void seJuegan20RondasEntoncesLaCantidadDeRondasEs20EnAlgoRoma(){

        AlgoRoma algoRoma = new AlgoRoma();
        int cantidadRondasEsperadas = 20 ;

        for( int i=0 ; i < 20 ; i++ ) {

            try {
                algoRoma.jugarRonda();
            } catch (FinDelJuegoException e){
                throw new RuntimeException(e);
            }
        }

        assertEquals( cantidadRondasEsperadas, algoRoma.getCantidadRondas()  );

    }

    @Test
    public void seJueganMasDe30RondasSeLanzaExceptionFinDelJuego(){

        AlgoRoma algoRoma = new AlgoRoma();

        for( int i=0 ; i < 30 ; i++ ) {

            try {
                algoRoma.jugarRonda();
            } catch (FinDelJuegoException e){
                throw new RuntimeException(e);
            }
        }

        assertThrows(FinDelJuegoException.class, algoRoma::jugarRonda);
    }

    @Test
    public void seAgreganMasDe6JugadoresSeLanzaMaximoGladiadoresException(){

        AlgoRoma algoRoma = new AlgoRoma();

        for( int i=1 ; i <= 6 ; i++ ) {

            algoRoma.agregarGladiador("Espartaco");
        }

        assertThrows(MaximoGladiadoresException.class,
                ()->{
                    algoRoma.agregarGladiador("Espartaco");
                });
    }

    @Test
    public void agregarGladiadoresEnUnJuegoIniciadoLanzaJuegoEnCursoException(){

        AlgoRoma algoRoma = new AlgoRoma();

        algoRoma.agregarGladiador("Espartaco");
        algoRoma.agregarGladiador("Augusto");

        algoRoma.inicializarJuego();

        assertThrows(JuegoEnCursoException.class,
                ()->{
                    algoRoma.agregarGladiador("Aurelio");
                });
    }

    @Test
    public void jugarTurnoSinInicializarLanzaJuegoNoIniciadoException(){

        AlgoRoma algoRoma = new AlgoRoma();

        algoRoma.agregarGladiador("Espartaco");
        algoRoma.agregarGladiador("Augusto");


        assertThrows(JuegoNoIniciadoException.class,
                algoRoma::jugarTurno);
    }



    @Test
    public void jugarMasDe30RondasLanzaFinDelJuegoException() throws Exception {

        AlgoRoma algoRoma = new AlgoRoma();

        Mapa mapa = Mockito.mock(Mapa.class);

        algoRoma.setMapa(mapa);

        algoRoma.agregarGladiador("Espartaco");
        algoRoma.agregarGladiador("Augusto");

        algoRoma.inicializarJuego();

        for( int i=1 ; i <= 60 ; i++ ) {
            algoRoma.jugarTurno();

        }

        assertThrows(FinDelJuegoException.class,
                algoRoma::jugarTurno);

        //voy a verificar que avanzar se llamo una vez en el mockito de mapa

        //verify(mapa, times(1)).avanzarNPosicionesGladiador(ArgumentMatchers.any(Gladiador.class), ArgumentMatchers.anyInt());
    }

}
