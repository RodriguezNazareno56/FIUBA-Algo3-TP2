package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Concecuencias.FieraSalvaje;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.SinEquipamiento;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.senority.Novato;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import edu.fiuba.algo3.MovimientoExeption;
import edu.fiuba.algo3.casilleros.Casillero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso1 {

    /**
     * Por enunciado: Cada gladiador comienza con 20 puntos de energía, sin equipamiento.
     */
    @Test
    public void verificarQueElJugadorEmpiezaConLaEnergiaYEquipamientoCorrespondiente() throws Exception {
        // Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

        // Assert
        // Un gladiador debe iniciar sin equipamiento y con 20 puntos de energia.
        // Un gladiador sin equipamiento al ser atacado por una fiera salvaje recibe 20 puntos de energia
        // Si la inicializacion fue correcta, entonces tras el ataque debe quedar sin energia
        // y por ende incapaz de moverse
        gladiador.recibirConsecuencia(new FieraSalvaje());
        Throwable exception= Assertions.assertThrows(MovimientoExeption.class, gladiador::avanzar);
        assertEquals("El gladiador no se puede mover sin energia", exception.getMessage());
    }
}
