package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Gladiador.TriunfoException;
import edu.fiuba.algo3.MovimientoException;
import edu.fiuba.algo3.casilleros.Casillero;
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
        Throwable exception= Assertions.assertThrows(MovimientoPausadoExeption.class, () -> {
            gladiadorMock.avanzar(1);
        });
        assertEquals("El gladiador esta pausado para mover en este turno", exception.getMessage());
    }

    @Test
    public void unaLesionAfectaAUnGladiadorImpidiendoleAvanzarUnTurno() throws TriunfoException, MovimientoPausadoExeption, MovimientoException {
        //Arrange
        Consecuencia lesion = new Lesion();
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

        //Act
        lesion.afectarGladiador(gladiador);

        //Assert
//        Throwable exception= Assertions.assertThrows(MovimientoPausadoExeption.class, () -> {
//            gladiador.avanzar(1);
//        });
        Throwable exception= Assertions.assertThrows(MovimientoPausadoExeption.class, () -> {
            gladiador.avanzar(1);
        });
        assertEquals("El gladiador esta pausado para mover en este turno", exception.getMessage());
    }
}
