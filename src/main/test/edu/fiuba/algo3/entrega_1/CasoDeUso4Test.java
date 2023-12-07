package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.NombreInvalidoException;
import edu.fiuba.algo3.modelo.consecuencias.Comida;
import edu.fiuba.algo3.modelo.constantes.ComidaConstantes;
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

public class CasoDeUso4Test {

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
    public void verificarQueSiRecibeComidaIncrementaEnergiaEn15() throws Exception {
        // Arrange
        Comida comida = new Comida();
        // Se espera que un gladiador que inicia con 20 puntos de energia, al comer incremente la misma en 15 puntos
        Energia energiaEsperada = new Energia(energiaInicialValor + ComidaConstantes.VALOR_DE_RECOMPOSICION);

        // Act
        this.gladiador.recibirConsecuencia(comida);

        // Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }
}

