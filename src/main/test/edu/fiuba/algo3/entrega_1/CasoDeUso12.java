package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.AlgoRoma;
import edu.fiuba.algo3.FinDelJuego;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso12 {

    private AlgoRoma algoRoma;

    @BeforeEach
    public void SetUp(){
        this.algoRoma = new AlgoRoma();
    }

    @Test
    public void verificarQueSiPasan30TurnosYNadieLlegoALaMetaSeTerminaElJuego() {
        // TODO: falta implementar

        for( int i=0 ; i < 30 ; i++ ){

            try {
                this.algoRoma.jugarRonda();
            } catch (FinDelJuego e) {
                throw new RuntimeException(e);
            }
        }

        Throwable exception= Assertions.assertThrows(FinDelJuego.class, () -> {
            this.algoRoma.jugarRonda();
        });

        assertEquals("Fin del Juego: Se alcanzo el numero maximo de rondas", exception.getMessage());


    }
}
