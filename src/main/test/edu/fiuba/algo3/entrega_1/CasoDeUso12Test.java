package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso12Test {

    private AlgoRoma algoRoma;

    @BeforeEach
    public void SetUp(){
        this.algoRoma = new AlgoRoma();
    }

    @Test
    public void verificarQueSiPasan30TurnosYNadieLlegoALaMetaSeTerminaElJuego() {
        // Arrange
        for( int i=0 ; i < 30 ; i++ ){
            try {
                this.algoRoma.jugarRonda();
            } catch (FinDelJuegoException e) {
                throw new RuntimeException(e);
            }
        }

        // Assert
        Assertions.assertThrows(FinDelJuegoException.class, algoRoma::jugarRonda);
    }
}
