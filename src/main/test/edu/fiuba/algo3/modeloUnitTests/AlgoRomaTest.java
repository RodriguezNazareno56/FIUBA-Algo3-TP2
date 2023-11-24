package edu.fiuba.algo3.modeloUnitTests;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        Assertions.assertThrows(FinDelJuegoException.class, algoRoma::jugarRonda);
    }



}
