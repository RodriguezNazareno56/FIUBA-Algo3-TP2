package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.casilleros.Casillero;
import edu.fiuba.algo3.gladiador.Energia;
import edu.fiuba.algo3.equipamientos.Equipamiento;
import edu.fiuba.algo3.equipamientos.Llave;
import edu.fiuba.algo3.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.gladiador.Gladiador;
import edu.fiuba.algo3.gladiador.senority.Novato;
import edu.fiuba.algo3.gladiador.senority.Senority;
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
        FieraSalvaje fieraSalvaje = new FieraSalvaje();

        // Act
        fieraSalvaje.afectarGladiador(gladiador);

        // Assert
        assertEquals(gladiador.getEnergia(), 20);
    }
}
