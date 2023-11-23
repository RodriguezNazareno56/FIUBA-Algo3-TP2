package edu.fiuba.algo3.consecuencias;

import edu.fiuba.algo3.casilleros.Casillero;
import edu.fiuba.algo3.equipamientos.Casco;
import edu.fiuba.algo3.equipamientos.Armadura;
import edu.fiuba.algo3.equipamientos.EscudoYEspada;
import edu.fiuba.algo3.equipamientos.Llave;
import edu.fiuba.algo3.equipamientos.Equipamiento;
import edu.fiuba.algo3.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.gladiador.Energia;
import edu.fiuba.algo3.gladiador.Gladiador;
import edu.fiuba.algo3.gladiador.senority.Novato;
import edu.fiuba.algo3.gladiador.senority.Senority;
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
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

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
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

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
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

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
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

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
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();
        Equipamiento equipamientoEsperado = new Llave();

        //Act
        equipamientoIncrementado.afectarGladiador(gladiador);

        //Assert
        assertEquals(equipamientoEsperado, gladiador.obtenerEquipamiento());
    }
}