package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.constantes.Constantes;
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AsisteAUnBacanalTest {


    @Test
    public void afectarGladiador() throws Exception {
        //Arrange
        int cantiadDeTragos = 6;
        Dado dadoMock = Mockito.mock(Dado.class);
        Mockito.when(dadoMock.tirarDado()).thenReturn(cantiadDeTragos);
        IConsecuencia asisteAUnBacanal = new AsisteAUnBacanal(dadoMock);
        Gladiador gladiadorMock = mock(Gladiador.class);

        //Act
        asisteAUnBacanal.afectarGladiador(gladiadorMock);

        //Assert
        Energia energiaAfectada = new Energia(cantiadDeTragos * Constantes.CANTIDAD_DE_PUNTOS_PERDIDOS_POR_COPA_DE_VINO_EN_BACANAL);
        verify(gladiadorMock,times(1)).tomarCopasDeVino(energiaAfectada);

    }

    @Test
    public void unGladiadorAsisteAUnBacanalTomaUnTragoYPierdeEnergia() throws NombreInvalidoException {
        //Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));

        Dado dadoMock = Mockito.mock(Dado.class);
        Mockito.when(dadoMock.tirarDado()).thenReturn(1);
        AsisteAUnBacanal bacanal = new AsisteAUnBacanal(dadoMock);
        Energia energiaEsperada = new Energia(16); // se le restan 4 * cantidadTragos

        //Act
        bacanal.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unGladiadorAsisteAUnBacanalTomaDosTragosYPierdeEnergia() throws NombreInvalidoException {
        //Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));

        Dado dadoMock = Mockito.mock(Dado.class);
        Mockito.when(dadoMock.tirarDado()).thenReturn(2);
        AsisteAUnBacanal bacanal = new AsisteAUnBacanal(dadoMock);
        Energia energiaEsperada = new Energia(12); // se le restan 4 * cantidadTragos

        //Act
        bacanal.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unGladiadorAsisteAUnBacanalTomaTresTragosYPierdeEnergia() throws NombreInvalidoException {
        //Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));

        Dado dadoMock = Mockito.mock(Dado.class);
        Mockito.when(dadoMock.tirarDado()).thenReturn(3);
        AsisteAUnBacanal bacanal = new AsisteAUnBacanal(dadoMock);
        Energia energiaEsperada = new Energia(8); // se le restan 4 * cantidadTragos

        //Act
        bacanal.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unGladiadorAsisteAUnBacanalTomaCuatroTragosYPierdeEnergia() throws NombreInvalidoException {
        //Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));

        Dado dadoMock = Mockito.mock(Dado.class);
        Mockito.when(dadoMock.tirarDado()).thenReturn(4);
        AsisteAUnBacanal bacanal = new AsisteAUnBacanal(dadoMock);
        Energia energiaEsperada = new Energia(4); // se le restan 4 * cantidadTragos

        //Act
        bacanal.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unGladiadorAsisteAUnBacanalTomaCincoTragosYPierdeEnergia() throws NombreInvalidoException {
        //Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));

        Dado dadoMock = Mockito.mock(Dado.class);
        Mockito.when(dadoMock.tirarDado()).thenReturn(5);
        AsisteAUnBacanal bacanal = new AsisteAUnBacanal(dadoMock);
        Energia energiaEsperada = new Energia(0); // se le restan 4 * cantidadTragos

        //Act
        bacanal.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }

    @Test
    public void unGladiadorAsisteAUnBacanalYSuEnergiaQuedaNegativa() throws NombreInvalidoException {
        //Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));

        Dado dadoMock = Mockito.mock(Dado.class);
        Mockito.when(dadoMock.tirarDado()).thenReturn(6);
        AsisteAUnBacanal bacanal = new AsisteAUnBacanal(dadoMock);
        Energia energiaEsperada = new Energia(-4); // se le restan 4 * cantidadTragos

        //Act
        bacanal.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }
}
