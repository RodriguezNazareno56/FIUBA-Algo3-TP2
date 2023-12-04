package edu.fiuba.algo3.modelo.consecuencias;


import edu.fiuba.algo3.modelo.constantes.ComidaConstantes;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

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
        int energiaInicialValor = 20;
        Energia energia = new Energia(energiaInicialValor);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
        Comida comida = new Comida();
        Energia energiaEsperada = new Energia(energiaInicialValor + ComidaConstantes.VALOR_DE_RECOMPOSICION);

        //Act
        comida.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unGladiadorConEnergiaNegativaEsAfectadoPorComidaYSuEnergiaSeIncrementa() {
        // Arrange
        int energiaInicialValor = -10;
        Energia energia = new Energia(energiaInicialValor);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
        Comida comida = new Comida();
        Energia energiaEsperada = new Energia(energiaInicialValor + ComidaConstantes.VALOR_DE_RECOMPOSICION);

        //Act
        comida.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }
}