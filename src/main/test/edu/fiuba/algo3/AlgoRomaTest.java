package edu.fiuba.algo3;

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
            } catch (FinDelJuego e){
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
            } catch (FinDelJuego e){
                throw new RuntimeException(e);
            }
        }

        Throwable exception= Assertions.assertThrows(FinDelJuego.class, () -> {
            algoRoma.jugarRonda();
        });

        assertEquals("Fin del Juego: Se alcanzo el numero maximo de rondas", exception.getMessage());


    }



}
