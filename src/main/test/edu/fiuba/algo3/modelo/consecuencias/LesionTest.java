package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.NombreInvalidoException;
import edu.fiuba.algo3.modelo.gladiador.exepciones.MovimientoException;
import edu.fiuba.algo3.modelo.gladiador.exepciones.TriunfoNoPosibleException;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LesionTest {

    @Test
    public void afectarGladiador() throws Exception {
        //Arrange
        IConsecuencia lesion = new Lesion();
        Gladiador gladiadorMock = mock(Gladiador.class);
        doThrow(new MovimientoException("El gladiador esta pausado para mover en este turno"))
                .when(gladiadorMock)
                .avanzar();

        //Act
        lesion.afectarGladiador(gladiadorMock);

        //Assert
        Assertions.assertThrows(MovimientoException.class, gladiadorMock::avanzar);
    }

    @Test
    public void unaLesionAfectaAUnGladiadorImpidiendoleAvanzarUnTurno() throws TriunfoNoPosibleException, FinDelJuegoException, NombreInvalidoException {
        //Arrange
        IConsecuencia lesion = new Lesion();
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));

        //Act
        lesion.afectarGladiador(gladiador);

        //Assert
        Assertions.assertThrows(MovimientoException.class, gladiador::avanzar);
    }
}
