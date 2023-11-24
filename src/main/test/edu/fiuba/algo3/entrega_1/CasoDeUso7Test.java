package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.casilleros.Casillero;
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
    void setUp() {
        Casillero casillero = new Casillero(0);
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Casco();
        Senority senority = new Senority();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void verificarQueSiHayUnCombateConUnaFieraSalvajeYTieneUnCascoPierde15PuntosDeEnergia() throws Exception {
        // TODO: falta ver si se puede sacar el getEnergia()
        // Arrange
        FieraSalvaje fieraSalvaje = new FieraSalvaje();

        // Act
        this.gladiador.recibirConsecuencia(fieraSalvaje);

        // Assert
        assertEquals(5, gladiador.getEnergia());
    }
}
