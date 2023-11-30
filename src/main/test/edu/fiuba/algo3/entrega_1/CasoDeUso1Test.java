package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.MovimientoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

public class CasoDeUso1Test {

    /**
     * Por enunciado: Cada gladiador comienza con 20 puntos de energía, sin equipamiento.
     */
    @Test
    public void verificarQueElJugadorEmpiezaConLaEnergiaYEquipamientoCorrespondiente() throws Exception {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority, Mockito.mock(Logger.class));

        // Assert
        // Un gladiador debe iniciar sin equipamiento y con 20 puntos de energia.
        // Un gladiador sin equipamiento al ser atacado por una fiera salvaje recibe 20 puntos de energia
        // Si la inicializacion fue correcta, entonces tras el ataque debe quedar sin energia
        // y por ende incapaz de moverse
        gladiador.recibirConsecuencia(new FieraSalvaje());
        Assertions.assertThrows(MovimientoException.class, gladiador::avanzar);
    }
}
