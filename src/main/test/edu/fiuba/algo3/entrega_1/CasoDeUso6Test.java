package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.NombreInvalidoException;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.modelo.consecuencias.EquipamientoIncrementado;
import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso6Test {

    private Gladiador gladiador;
    private final int energiaInicialValor = 20;

    @BeforeEach
    public void setUp() throws NombreInvalidoException {
        Energia energia = new Energia(energiaInicialValor);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        this.gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
    }

    @Test
    public void verificarQueSiRecibeUnPremioPorTerceraVezObtieneEscudoYEspada() throws Exception {
        //Arrange
        IConsecuencia incrementoDeEquipo = new EquipamientoIncrementado();
        // Un gladiador sin equipamiento y con 20 puntos de vida. Recibira un premio por tercera vez y sera atacado
        // por una fiera, se espera que se defienda con el EscudoYEspada y tan solo sufra 2 puntos de danio
        Energia energiaEsperada = new Energia(energiaInicialValor - FieraSalvaje.ATAQUE_CONTRA_EQUIPADO_ESCUDO_Y_ESPADA);

        //Act
        incrementoDeEquipo.afectarGladiador(gladiador);
        incrementoDeEquipo.afectarGladiador(gladiador);
        incrementoDeEquipo.afectarGladiador(gladiador);
        this.gladiador.recibirAtaque(new FieraSalvaje());

        //Assert
        assertEquals(energiaEsperada, this.gladiador.getEnergia());
    }
}