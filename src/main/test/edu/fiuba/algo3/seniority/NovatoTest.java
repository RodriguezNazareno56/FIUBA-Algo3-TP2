package edu.fiuba.algo3.seniority;

import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.senority.Novato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;


public class NovatoTest {

    private Energia energiaMock;

    @BeforeEach
    public void SetUp() {
        energiaMock = Mockito.mock(Energia.class);
    }

    @Test
    public void novatoNoIncrementaEnergiaConExperienciaMenorAOcho(){

        //Arrange
        Novato novato = new Novato();
        int energiaEsperada = 0;

        //Act

        //Una vez inicializado se incrementa 3 veces la energia
        for(int i = 0 ; i < 3 ; i++ ) {
            novato.aumentarEnergia(energiaMock);
        }


        //Assert

        //La energia resultante debe ser nula

        //Verifico que el metodo aumentarEnergia de la clase Energia se llame 3 veces
        Mockito.verify(energiaMock, Mockito.times(3))
                .aumentarEnergia(Mockito.any(Energia.class));
        //Verifico que el metodo aumentarEnergia de la clase Energia se llame 3 veces con parametro cero
        Mockito.verify(energiaMock, Mockito.times(3))
                .aumentarEnergia( ArgumentMatchers.argThat(arg -> arg.getValor() == 0));

    }


}
