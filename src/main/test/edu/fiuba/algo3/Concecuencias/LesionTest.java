package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.MovimientoExeption;
import edu.fiuba.algo3.MovimientoPausadoExeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LesionTest {

    @Test
    void afectarGladiador() throws MovimientoExeption, MovimientoPausadoExeption {
        //Arrange
        Consecuencia lesion = new Lesion();
        Gladiador gladiadorMock = mock(Gladiador.class);
        doThrow(new MovimientoPausadoExeption("El gladiador esta pausado para mover en este turno"))
                .when(gladiadorMock)
                .avanzar();

        //Act
        gladiadorMock.recibirConsecuencia(lesion);

        //Assert
        Throwable exception= Assertions.assertThrows(MovimientoPausadoExeption.class, gladiadorMock::avanzar);
        assertEquals("El gladiador esta pausado para mover en este turno", exception.getMessage());
    }
}
