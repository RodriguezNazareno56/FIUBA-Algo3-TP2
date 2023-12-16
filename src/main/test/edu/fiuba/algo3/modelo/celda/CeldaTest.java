package edu.fiuba.algo3.modelo.celda;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.consecuencias.Comida;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.exepciones.TriunfoNoPosibleException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CeldaTest {

    @Test
    public void afectarGladiadorConConsecuenciaCuandoCeldaTieneUnaSolaConsecuencia() throws TriunfoNoPosibleException, FinDelJuegoException {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        Coordenada coordenada = Mockito.mock(Coordenada.class);
        IConsecuencia consecuencia = Mockito.mock(IConsecuencia.class);
        List<IConsecuencia> consecuencias = new ArrayList<>();
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
    public void afectarGladiadorConConsecuenciaCuandoCeldaTieneMasDeUnaConsecuencia() throws TriunfoNoPosibleException, FinDelJuegoException {
        // Arrange
        Gladiador gladiador = Mockito.mock(Gladiador.class);
        Coordenada coordenada = Mockito.mock(Coordenada.class);
        IConsecuencia consecuencia = Mockito.mock(IConsecuencia.class);
        List<IConsecuencia> consecuencias = new ArrayList<>();
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

    @Test
    public void dosCeldasSonIgualesCuandoPoseenLasMismasCoordenadasYConsecuancias() {
        // Arrange
        Coordenada coordenada1 = new Coordenada(1,5);
        IConsecuencia consecuencia1 = new FieraSalvaje();
        List<IConsecuencia> consecuencias1 = new ArrayList<>();
        consecuencias1.add(consecuencia1);
        Celda celda1 = new Celda(coordenada1, consecuencias1);

        Coordenada coordenada2 = new Coordenada(1,5);
        IConsecuencia consecuencia2 = new FieraSalvaje();
        List<IConsecuencia> consecuencias2 = new ArrayList<>();
        consecuencias2.add(consecuencia2);
        Celda celda2 = new Celda(coordenada2, consecuencias2);

        assertEquals(celda1, celda2);
    }

    @Test
    public void dosCeldasSonIgualesCuandoPoseenLasMismasCoordenadasYMismaListaDeConsecuancias() {
        // Arrange
        Coordenada coordenada1 = new Coordenada(1,5);
        IConsecuencia fieraSalvaje1 = new FieraSalvaje();
        IConsecuencia comida1 = new Comida();
        List<IConsecuencia> consecuencias1 = new ArrayList<>();
        consecuencias1.add(fieraSalvaje1);
        consecuencias1.add(comida1);
        Celda celda1 = new Celda(coordenada1, consecuencias1);

        Coordenada coordenada2 = new Coordenada(1,5);
        IConsecuencia fieraSalvaje2 = new FieraSalvaje();
        IConsecuencia comida2 = new Comida();
        List<IConsecuencia> consecuencias2 = new ArrayList<>();
        consecuencias2.add(fieraSalvaje2);
        consecuencias2.add(comida2);
        Celda celda2 = new Celda(coordenada2, consecuencias2);

        assertEquals(celda1, celda2);
    }

    @Test
    public void dosCeldasNoSonIgualesCuandoPoseenNoPoseenElMismoTipoDeConsecuancias() {
        // Arrange
        Coordenada coordenada1 = new Coordenada(1,5);
        IConsecuencia consecuencia1 = new Comida();
        List<IConsecuencia> consecuencias1 = new ArrayList<>();
        consecuencias1.add(consecuencia1);
        Celda celda1 = new Celda(coordenada1, consecuencias1);

        Coordenada coordenada2 = new Coordenada(1,5);
        IConsecuencia consecuencia2 = new FieraSalvaje();
        List<IConsecuencia> consecuencias2 = new ArrayList<>();
        consecuencias2.add(consecuencia2);
        Celda celda2 = new Celda(coordenada2, consecuencias2);

        assertNotEquals(celda1, celda2);
    }
}