package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Concecuencias.Comida;
import edu.fiuba.algo3.Concecuencias.Consecuencia;
import edu.fiuba.algo3.Concecuencias.FieraSalvaje;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.Casco;
import edu.fiuba.algo3.Equipamientos.SinEquipamiento;
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

    @BeforeEach
    void setUp() {
        Casillero casillero = new Casillero(0);
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Novato();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void verificarQueSiRecibeComidaIncrementaEnergiaEn15() throws Exception {
        // Arrange
        Comida comida = new Comida();

        // Act
        this.gladiador.recibirConsecuencia(comida);

        // Assert
        assertEquals(gladiador.getEnergia(), 35);
    }
}

