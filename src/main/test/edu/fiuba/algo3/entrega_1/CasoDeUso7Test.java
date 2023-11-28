package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.equipamientos.Casco;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso7Test {

    private Gladiador gladiador;

    @BeforeEach
    public void setUp() {
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Casco();
        Senority senority = new Senority();
        this.gladiador = new Gladiador(energia, equipamiento, senority);
    }

    @Test
    public void verificarQueSiHayUnCombateConUnaFieraSalvajeYTieneUnCascoPierde15PuntosDeEnergia() throws Exception {
        // Arrange
        FieraSalvaje fieraSalvaje = new FieraSalvaje();
        // Se espera que un gladiador que inicia con 20 puntos de energia, pierda 15 puntos al ser atacado por una
        // fiera cuando el mismo posee un Casco como equipamiento
        Energia energiaEsperada = new Energia(5);

        // Act
        this.gladiador.recibirConsecuencia(fieraSalvaje);

        // Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }
}
