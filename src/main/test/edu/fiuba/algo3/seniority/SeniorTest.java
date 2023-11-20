package edu.fiuba.algo3.seniority;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.senority.Senior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;


public class SeniorTest {

    private Energia energiaMock;

    @BeforeEach
    public void SetUp() {
        energiaMock = Mockito.mock(Energia.class);
    }

    @Test
    public void novatoNoIncrementaEnergiaConExperienciaMenorAOcho(){

        //Arrange
        Senior senior = new Senior();
        //Act

        //Una vez inicializado se incrementa 3 veces la energia
        for(int i = 0 ; i < 3 ; i++ ) {
            senior.aumentarEnergia(energiaMock);
        }


        //Assert

        //La energia resultante debe ser nula

        //Verifico que el metodo aumentarEnergia de la clase Energia se llame 3 veces
        Mockito.verify(energiaMock, Mockito.times(3))
                .aumentarEnergia(Mockito.any(Energia.class));
        //Verifico que el metodo aumentarEnergia de la clase Energia se llame 3 veces con parametro cinco
        Mockito.verify(energiaMock, Mockito.times(3))
                .aumentarEnergia( ArgumentMatchers.argThat(arg -> arg.getValor() == 10));

    }


}