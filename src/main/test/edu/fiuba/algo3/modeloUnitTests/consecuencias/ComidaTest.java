package edu.fiuba.algo3.modeloUnitTests.consecuencias;


import edu.fiuba.algo3.modelo.casilleros.Casillero;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.consecuencias.Comida;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Novato;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


public class ComidaTest {
    @Test
    public void afectarGladiadorHaceQueGladiadorComa() {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        Comida comida= new Comida();

        // Act
        comida.afectarGladiador(gladiador);

        // Assert
        Mockito.verify(gladiador, Mockito.times(1))
                .comer(Mockito.any(Energia.class));
    }

    @Test
    public void unGladiadorEsAfectadoPorComidaYSuEnergiaSeIncrementa() {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);
        Comida comida = new Comida();
        int energiaEsperada = 35;

        //Act
        comida.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unGladiadorConEnergiaNegativaEsAfectadoPorComidaYSuEnergiaSeIncrementa() {
        // Arrange
        Energia energia = new Energia(-10);
        Equipamiento equipamiento = new SinEquipamiento();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);
        Comida comida = new Comida();
        int energiaEsperada = 5; // -10 + 15

        //Act
        comida.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }
}