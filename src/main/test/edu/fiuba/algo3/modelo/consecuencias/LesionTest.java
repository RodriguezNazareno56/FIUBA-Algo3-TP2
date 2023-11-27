package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.gladiador.TriunfoException;
import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.MovimientoPausadoExeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LesionTest {

    @Test
    public void afectarGladiador() throws Exception {
        //Arrange
        Consecuencia lesion = new Lesion();
        Gladiador gladiadorMock = mock(Gladiador.class);
        doThrow(new MovimientoPausadoExeption("El gladiador esta pausado para mover en este turno"))
                .when(gladiadorMock)
                .avanzar(1);

        //Act
        gladiadorMock.recibirConsecuencia(lesion);

        //Assert
        Assertions.assertThrows(MovimientoPausadoExeption.class, () -> {
            gladiadorMock.avanzar(1);
        });
    }

    @Test
    public void unaLesionAfectaAUnGladiadorImpidiendoleAvanzarUnTurno() throws TriunfoException, MovimientoPausadoExeption, MovimientoException {
        //Arrange
        Consecuencia lesion = new Lesion();
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority);

        //Act
        lesion.afectarGladiador(gladiador);

        //Assert
        Assertions.assertThrows(MovimientoPausadoExeption.class, () -> {
            gladiador.avanzar(1);
        });
    }
}
