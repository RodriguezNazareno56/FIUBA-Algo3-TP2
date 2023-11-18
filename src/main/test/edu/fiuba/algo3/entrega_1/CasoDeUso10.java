package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Casillero;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.Llave;
import edu.fiuba.algo3.Concecuencias.FieraSalvaje;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.Senority.Novato;
import edu.fiuba.algo3.Gladiador.Senority.Senority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso10 {

    private Gladiador gladiador;

    @BeforeEach
    void setUp() {
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Llave();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void verificarQueSiLoAtacaUnaFieraSalvajeYPoseeTodoElEquipamientoElDanioEnEnergiaEs0() {
        // TODO: double dispatch para diferenciar ataque ante los distintos tipos de equipamiento
        FieraSalvaje fieraSalvaje = new FieraSalvaje();

        // Act
        fieraSalvaje.afectarGladiador(gladiador);

        // Assert
        assertEquals(gladiador.getEnergia(), 20);
    }
}
