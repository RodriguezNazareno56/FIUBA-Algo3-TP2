package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Casillero;
import edu.fiuba.algo3.Concecuencias.Consecuencia;
import edu.fiuba.algo3.Concecuencias.FieraSalvaje;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.Llave;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Concecuencias.EquipamientoIncrementado;
import edu.fiuba.algo3.Gladiador.senority.Novato;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso11 {

    private Gladiador gladiador;
    private Equipamiento equipamiento;

    @BeforeEach
    void setUp() {
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Energia energia = new Energia(20);
        this.equipamiento = new Llave();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void verificarQueSiElGladiadorTieneLaLlaveYRecibeOtroPremioNoCambiaNada() {
        // Arrange
        Consecuencia equipamientoIncrementado = new EquipamientoIncrementado();
        int enerigiaEsperada = 20;

        // Act
        this.gladiador.recibirConsecuencia(equipamientoIncrementado);
        this.gladiador.recibirAtaque(new FieraSalvaje());

        // Assert
        assertEquals(enerigiaEsperada, this.gladiador.getEnergia());

    }
}
