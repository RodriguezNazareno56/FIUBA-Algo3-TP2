package edu.fiuba.algo3.modelo.celda;

import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.TriunfoNoPosibleException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class CeldaTest {

    @Test
    public void afectarGladiadorConConsecuenciaCuandoCeldaTieneUnaSolaConsecuencia() throws TriunfoNoPosibleException {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        Coordenada coordenada = Mockito.mock(Coordenada.class);
        Consecuencia consecuencia = Mockito.mock(Consecuencia.class);
        List<Consecuencia> consecuencias = new ArrayList<>();
        consecuencias.add(consecuencia);
        // Celda con una lista que contiene 1 consecuencia
        ICelda celda = new Celda(coordenada, consecuencias);

        // Act
        celda.afectarGladiadorConConsecuencia(gladiador);

        // Assert
        Mockito.verify(consecuencia, Mockito.times(1))
                .afectarGladiador(gladiador);
    }

    @Test
    public void afectarGladiadorConConsecuenciaCuandoCeldaTieneMasDeUnaConsecuencia() throws TriunfoNoPosibleException {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        Coordenada coordenada = Mockito.mock(Coordenada.class);
        Consecuencia consecuencia = Mockito.mock(Consecuencia.class);
        List<Consecuencia> consecuencias = new ArrayList<>();
        consecuencias.add(consecuencia);
        consecuencias.add(consecuencia);
        consecuencias.add(consecuencia);
        // Celda con una lista que contiene 3 consecuencias
        ICelda celda = new Celda(coordenada, consecuencias);

        // Act
        celda.afectarGladiadorConConsecuencia(gladiador);

        // Assert
        Mockito.verify(consecuencia, Mockito.times(3))
                .afectarGladiador(gladiador);
    }
}