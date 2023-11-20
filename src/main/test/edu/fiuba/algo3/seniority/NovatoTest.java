package edu.fiuba.algo3.seniority;

import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.senority.Novato;
import edu.fiuba.algo3.Gladiador.senority.Senority;
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

    @Test
    public void novatoAlIncrementarNueveVecesExperienciaRetornaSemiSenior() {

        //Arrange
        Novato novato = new Novato();
        Senority miSeniority;

        //Act

        //Una vez inicializado se incrementa 8 veces la experiencia
        //Por lo tanto el proximo estado de miSeniority es SemiSenior

        miSeniority = novato.aumentarExperiencia();

        for (int i = 0; i < 8; i++) {
            miSeniority = miSeniority.aumentarExperiencia();
        }

        miSeniority.aumentarEnergia(energiaMock);

        //Assert

        //Verifico que el metodo aumentarEnergia de la clase Energia se llame 1 vez con parametro cinco
        //Ya que si es SemiSenior el aumento de energia es 5
        Mockito.verify(energiaMock, Mockito.times(1))
                .aumentarEnergia( ArgumentMatchers.argThat(arg -> arg.getValor() == 5));


        }

    }
