package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.SinEquipamiento;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.senority.Novato;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import edu.fiuba.algo3.casilleros.Casillero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso1 {

    /**
     * Por enunciado: Cada gladiador comienza con 20 puntos de energía, sin equipamiento.
     */
    @Test
    public void verificarQueElJugadorEmpiezaConLaEnergiaYEquipamientoCorrespondiente() {
        // TODO: refactorizar para quitar los getEnergia() y getEquipamiento()
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

        // Assert
        assertEquals(gladiador.obtenerEquipamiento(), equipamiento);
        assertEquals(gladiador.getEnergia(), 20);

    }
}
