package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Gladiador.Gladiador;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AsisteAUnBacanalTest {


    @Test
    void afectarGladiador(){
        //Arrange
        int cantiadDeTragos = 6;
        Consecuencia asisteAUnBacanal = new AsisteAUnBacanal(cantiadDeTragos);
        Gladiador gladiadorMock = mock(Gladiador.class);

        //Act
        gladiadorMock.recibirConsecuencia(asisteAUnBacanal);

        //Assert
        verify(gladiadorMock,times(1)).recibirConsecuencia(asisteAUnBacanal);

    }
}
