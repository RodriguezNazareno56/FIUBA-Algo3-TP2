package edu.fiuba.algo3.entrega_1.otros;

import edu.fiuba.algo3.casilleros.Casillero;
import edu.fiuba.algo3.Concecuencias.Consecuencia;
import edu.fiuba.algo3.Concecuencias.Lesion;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.SinEquipamiento;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.senority.Novato;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import edu.fiuba.algo3.MovimientoPausadoExeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObstaculoLesionTest {

    @Test
    public void verificarQueSiRecibeUnObstaculoLesionYSeEncuentraEnELTurnoSiguienteNoSePuedeMover() throws Exception {
        //Arrange
        Consecuencia lesion = new Lesion();
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

        //Act
        gladiador.recibirConsecuencia(lesion);

        //Assert
        Throwable exception= Assertions.assertThrows(MovimientoPausadoExeption.class, () -> {
            gladiador.avanzar(1);
        });
        assertEquals("El gladiador esta pausado para mover en este turno", exception.getMessage());
    }
}
