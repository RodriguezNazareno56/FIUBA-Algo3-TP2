package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.equipamientos.Casco;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso7Test {

    private Gladiador gladiador;
    private final int energiaInicialValor = 20;

    @BeforeEach
    public void setUp() throws NombreInvalidoException {
        Energia energia = new Energia(energiaInicialValor);
        Equipamiento equipamiento = new Casco();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        this.gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
    }

    @Test
    public void verificarQueSiHayUnCombateConUnaFieraSalvajeYTieneUnCascoPierde15PuntosDeEnergia() throws Exception {
        // Arrange
        FieraSalvaje fieraSalvaje = new FieraSalvaje();
        // Se espera que un gladiador que inicia con 20 puntos de energia, pierda 15 puntos al ser atacado por una
        // fiera cuando el mismo posee un Casco como equipamiento
        Energia energiaEsperada = new Energia(energiaInicialValor - FieraSalvaje.ATAQUE_CONTRA_EQUIPADO_CASCO);

        // Act
        fieraSalvaje.afectarGladiador(gladiador);

        // Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }
}
