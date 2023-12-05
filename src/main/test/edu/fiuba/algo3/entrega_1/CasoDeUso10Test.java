package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.Llave;
import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso10Test {

    private Gladiador gladiador;
    private final int energiaInicialValor = 20;

    @BeforeEach
    public void setUp() {
        Senority senority = new Senority();
        Energia energia = new Energia(energiaInicialValor);
        Equipamiento equipamiento = new Llave();
        String nombre = "Espartaco";
        this.gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
    }

    @Test
    public void verificarQueSiLoAtacaUnaFieraSalvajeYPoseeTodoElEquipamientoElDanioEnEnergiaEs0() {
        // Arrange
        FieraSalvaje fieraSalvaje = new FieraSalvaje();
        // Se espera que un gladiador que inicia con una energia de 20 puntos, no pierda energia al ser atacado por
        // una fiera cuando el gladiador posee el maximo equipamiento
        Energia energiaEsperada = new Energia(energiaInicialValor - FieraSalvaje.ATAQUE_CONTRA_EQUIPADO_LLAVE);

        // Act
        fieraSalvaje.afectarGladiador(gladiador);

        // Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }
}
