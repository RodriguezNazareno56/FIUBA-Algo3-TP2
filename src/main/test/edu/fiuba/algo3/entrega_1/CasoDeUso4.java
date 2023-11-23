package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Concecuencias.Comida;
import edu.fiuba.algo3.Concecuencias.Consecuencia;
import edu.fiuba.algo3.Concecuencias.FieraSalvaje;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.Casco;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.senority.Novato;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import edu.fiuba.algo3.MovimientoException;
import edu.fiuba.algo3.casilleros.Casillero;
import edu.fiuba.algo3.casilleros.CasillerosFactory;
import edu.fiuba.algo3.casilleros.ICasillero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso4 {

    private Gladiador gladiador;

    private final int cantidadDeCasilleros = 4;

    @BeforeEach
    void setUp() {
        CasillerosFactory casillerosFactory = new CasillerosFactory();
        ICasillero casillero = casillerosFactory.construirCasilleros(cantidadDeCasilleros);
        Energia energia = new Energia(1);
        Equipamiento equipamiento = new Casco();
        Senority senority = new Novato();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void verificarQueSiRecibeComidaIncrementaEnergiaEn15() throws Exception {

        // Arrange
        Comida comida = new Comida();
        Consecuencia fieraSalvaje = new FieraSalvaje();

        // Act
        this.gladiador.recibirConsecuencia(comida);


        this.gladiador.recibirConsecuencia(fieraSalvaje);
        //por la energia debido a la comida el gladiador con casco deberia poder avanzar
        this.gladiador.avanzar(1);

        //no deberia poder avanzar tras recibir una segunda fiera
        this.gladiador.recibirConsecuencia(fieraSalvaje);

        // Assert
        Throwable exception= Assertions.assertThrows(MovimientoException.class, () -> {
            gladiador.avanzar(1);
        });
        assertEquals("El gladiador no se puede mover sin energia", exception.getMessage());
    }
}
