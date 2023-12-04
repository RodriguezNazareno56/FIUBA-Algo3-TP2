package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.equipamientos.Casco;
import edu.fiuba.algo3.modelo.equipamientos.Armadura;
import edu.fiuba.algo3.modelo.equipamientos.EscudoYEspada;
import edu.fiuba.algo3.modelo.equipamientos.Llave;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.exepciones.TriunfoNoPosibleException;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

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
    public void unGladiadorSinEquipamientoEsAfectadoYObtieneUnCasco() throws TriunfoNoPosibleException, FinDelJuegoException {
        // Arrange
        Energia energiaInicial = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energiaInicial, equipamiento, senority, Mockito.mock(Logger.class));
        IConsecuencia fieraSalvaje = new FieraSalvaje();

        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();
        Energia energiaEsperada = new Energia(5); //ataque de fiera salvaje le resta 15 puntos con Casco

        //Act
        equipamientoIncrementado.afectarGladiador(gladiador);
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unGladiadorConCascoEsAfectadoYObtieneUnaArmadura() throws TriunfoNoPosibleException, FinDelJuegoException {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Casco();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
        IConsecuencia fieraSalvaje = new FieraSalvaje();

        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();
        Energia energiaEsperada = new Energia(10); //ataque de fiera salvaje le resta 10 puntos con Armadura

        //Act
        equipamientoIncrementado.afectarGladiador(gladiador);
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unGladiadorConArmaduraEsAfectadoYObtieneEscudoYEspada() throws TriunfoNoPosibleException, FinDelJuegoException {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Armadura();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
        IConsecuencia fieraSalvaje = new FieraSalvaje();

        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();
        Energia energiaEsperada = new Energia(18); //ataque de fiera salvaje le resta 2 puntos con Escudo y Espada

        //Act
        equipamientoIncrementado.afectarGladiador(gladiador);
        fieraSalvaje.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unGladiadorConEscudoYEspadaEsAfectadoYObtieneUnaLlave() throws TriunfoNoPosibleException, FinDelJuegoException {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new EscudoYEspada();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
        IConsecuencia fieraSalvaje = new FieraSalvaje();

        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();
        Energia energiaEsperada = new Energia(20); //ataque de fiera salvaje no resta energia con Llave

        //Act
        equipamientoIncrementado.afectarGladiador(gladiador);
        for (int i = 0; i < 50; i++) {  //el gladiador no puede llegar a 50 turnos
            fieraSalvaje.afectarGladiador(gladiador);
        }

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unGladiadorConLlaveEsAfectadoSigueTeniendoLaLLave() throws TriunfoNoPosibleException, FinDelJuegoException {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Llave();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
        IConsecuencia fieraSalvaje = new FieraSalvaje();

        EquipamientoIncrementado equipamientoIncrementado = new EquipamientoIncrementado();
        Energia energiaEsperada = new Energia(20); //ataque de fiera salvaje no resta energia con Llave

        //Act
        equipamientoIncrementado.afectarGladiador(gladiador);


        //Assert
        for (int i = 0; i < 50; i++) {  //el gladiador no puede llegar a 50 turnos
            fieraSalvaje.afectarGladiador(gladiador);
        }
        assertEquals(energiaEsperada, gladiador.getEnergia()); //sigue sin afectarle los ataques de la fiera
    }
}