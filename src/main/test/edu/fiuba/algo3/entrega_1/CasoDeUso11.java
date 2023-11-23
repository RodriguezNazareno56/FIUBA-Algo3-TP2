package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.gladiador.TriunfoException;
import edu.fiuba.algo3.casilleros.Casillero;
import edu.fiuba.algo3.consecuencias.Consecuencia;
import edu.fiuba.algo3.gladiador.Energia;
import edu.fiuba.algo3.equipamientos.Equipamiento;
import edu.fiuba.algo3.equipamientos.Llave;
import edu.fiuba.algo3.gladiador.Gladiador;
import edu.fiuba.algo3.consecuencias.EquipamientoIncrementado;
import edu.fiuba.algo3.gladiador.senority.Novato;
import edu.fiuba.algo3.gladiador.senority.Senority;
import org.junit.jupiter.api.Assertions;
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
    public void verificarQueSiElGladiadorTieneLaLlaveYRecibeOtroPremioNoCambiaNada() throws Exception {
        // Arrange
        Consecuencia equipamientoIncrementado = new EquipamientoIncrementado();
        int enerigiaEsperada = 20;

        // Act
        this.gladiador.recibirConsecuencia(equipamientoIncrementado);

        // Assert
        //Si "triunfar" lanza la Excepcion "Campeon" significa que aun posee la llave
        //Y no se modifico su equipamiento luego de recibir anteriormente otro

        Throwable exception= Assertions.assertThrows(TriunfoException.class,() -> {
            this.gladiador.triunfar();
        });

        assertEquals("Campeon", exception.getMessage());

    }
}
