package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.consecuencias.Comida;
import edu.fiuba.algo3.equipamientos.Equipamiento;
import edu.fiuba.algo3.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.gladiador.Energia;
import edu.fiuba.algo3.gladiador.Gladiador;
import edu.fiuba.algo3.gladiador.senority.Novato;
import edu.fiuba.algo3.gladiador.senority.Senority;
import edu.fiuba.algo3.casilleros.Casillero;
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

