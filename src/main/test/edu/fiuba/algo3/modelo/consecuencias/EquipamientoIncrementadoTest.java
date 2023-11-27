package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.equipamientos.Casco;
import edu.fiuba.algo3.modelo.equipamientos.Armadura;
import edu.fiuba.algo3.modelo.equipamientos.EscudoYEspada;
import edu.fiuba.algo3.modelo.equipamientos.Llave;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

public class EquipamientoIncrementadoTest {

    @Test
    public void afectarGladiadorHaceQueGladiadorIncrementeSuEquipamiento() {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();

        // Act
        equipamientoIncrementado.afectarGladiador(gladiador);

        // Assert
        Mockito.verify(gladiador, times(1)).incrementarEquipamiento();
    }

    @Test
    public void unGladiadorSinEquipamientoEsAfectadoYObtieneUnCasco() {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority);

        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();
        Equipamiento equipamientoEsperado = new Casco();

        //Act
        equipamientoIncrementado.afectarGladiador(gladiador);

        //Assert
        assertEquals(equipamientoEsperado, gladiador.obtenerEquipamiento());
    }

    @Test
    public void unGladiadorConCascoEsAfectadoYObtieneUnaArmadura() {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Casco();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority);

        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();
        Equipamiento equipamientoEsperado = new Armadura();

        //Act
        equipamientoIncrementado.afectarGladiador(gladiador);

        //Assert
        assertEquals(equipamientoEsperado, gladiador.obtenerEquipamiento());
    }

    @Test
    public void unGladiadorConArmaduraEsAfectadoYObtieneEscudoYEspada() {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Armadura();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority);

        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();
        Equipamiento equipamientoEsperado = new EscudoYEspada();

        //Act
        equipamientoIncrementado.afectarGladiador(gladiador);

        //Assert
        assertEquals(equipamientoEsperado, gladiador.obtenerEquipamiento());
    }

    @Test
    public void unGladiadorConEscudoYEspadaEsAfectadoYObtieneUnaLlave() {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new EscudoYEspada();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority);

        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();
        Equipamiento equipamientoEsperado = new Llave();

        //Act
        equipamientoIncrementado.afectarGladiador(gladiador);

        //Assert
        assertEquals(equipamientoEsperado, gladiador.obtenerEquipamiento());
    }

    @Test
    public void unGladiadorConLlaveEsAfectadoSigueTeniendoLaLLave() {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Llave();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority);

        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();
        Equipamiento equipamientoEsperado = new Llave();

        //Act
        equipamientoIncrementado.afectarGladiador(gladiador);

        //Assert
        assertEquals(equipamientoEsperado, gladiador.obtenerEquipamiento());
    }
}