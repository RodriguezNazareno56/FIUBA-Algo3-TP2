package edu.fiuba.algo3.seniority;

import edu.fiuba.algo3.gladiador.Energia;
import edu.fiuba.algo3.gladiador.senority.SemiSenior;
import edu.fiuba.algo3.gladiador.senority.Senority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;


public class SemiSeniorTest {

    private Energia energiaMock;

    @BeforeEach
    public void SetUp() {
        energiaMock = Mockito.mock(Energia.class);
    }

    @Test
    public void novatoNoIncrementaEnergiaConExperienciaMenorAOcho(){

        //Arrange
        SemiSenior semiSenior = new SemiSenior();
        //Act

        //Una vez inicializado se incrementa 3 veces la energia
        for(int i = 0 ; i < 3 ; i++ ) {
            semiSenior.aumentarEnergia(energiaMock);
        }


        //Assert

        //La energia resultante debe ser nula

        //Verifico que el metodo aumentarEnergia de la clase Energia se llame 3 veces
        Mockito.verify(energiaMock, Mockito.times(3))
                .aumentarEnergia(Mockito.any(Energia.class));
        //Verifico que el metodo aumentarEnergia de la clase Energia se llame 3 veces con parametro cinco
        Mockito.verify(energiaMock, Mockito.times(3))
                .aumentarEnergia( ArgumentMatchers.argThat(arg -> arg.getValor() == 5));

    }


    @Test
    public void semiSeniorAlIncrementarCincoVecesExperienciaRetornaSeSenior() {

        //Arrange
        SemiSenior novato = new SemiSenior();
        Senority miSeniority;

        //Act

        //Una vez inicializado se incrementa 5 veces la experiencia
        //Por lo tanto el proximo estado de miSeniority es Se

        miSeniority = novato.aumentarExperiencia();

        for (int i = 0; i < 5; i++) {
            miSeniority = miSeniority.aumentarExperiencia();
        }

        miSeniority.aumentarEnergia(energiaMock);

        //Assert

        //Verifico que el metodo aumentarEnergia de la clase Energia se llame 1 vez con parametro diez
        //Ya que si es Senior el aumento de energia es 10
        Mockito.verify(energiaMock, Mockito.times(1))
                .aumentarEnergia( ArgumentMatchers.argThat(arg -> arg.getValor() == 10));


    }

}


