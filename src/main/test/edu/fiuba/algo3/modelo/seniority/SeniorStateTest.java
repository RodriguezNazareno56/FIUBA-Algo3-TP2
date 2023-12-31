package edu.fiuba.algo3.modelo.seniority;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.senority.states.SeniorState;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;


public class SeniorStateTest {

    private Energia energiaMock;

    @BeforeEach
    public void SetUp() {
        energiaMock = Mockito.mock(Energia.class);
    }

    @Test
    public void seniorIncrementa10PuntosLaEnergia(){

        //Arrange
        SeniorState seniorState = new SeniorState(Mockito.mock(Senority.class));
        //Act

        //Una vez inicializado se incrementa 3 veces la energia
        for(int i = 0 ; i < 3 ; i++ ) {
            seniorState.aumentarEnergia(energiaMock);
        }


        //Assert

        //Verifico que el metodo aumentarEnergia de la clase Energia se llame 3 veces
        Mockito.verify(energiaMock, Mockito.times(3))
                .aumentarEnergia(Mockito.any(Energia.class));
        //Verifico que el metodo aumentarEnergia de la clase Energia se llame 3 veces con parametro cinco
        Mockito.verify(energiaMock, Mockito.times(3))
                .aumentarEnergia( ArgumentMatchers.argThat(arg -> arg.getValor() == 10));
    }


}