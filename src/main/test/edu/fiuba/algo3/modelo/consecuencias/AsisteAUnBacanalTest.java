package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.Dado;
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
        Consecuencia asisteAUnBacanal = new AsisteAUnBacanal(dadoMock);
        Gladiador gladiadorMock = mock(Gladiador.class);

        //Act
        gladiadorMock.recibirConsecuencia(asisteAUnBacanal);

        //Assert
        verify(gladiadorMock,times(1)).recibirConsecuencia(asisteAUnBacanal);

    }

    @Test
    public void unGladiadorAsisteAUnBacanalTomaUnTragoYPierdeEnergia() {
        //Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority, Mockito.mock(Logger.class));

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
    public void unGladiadorAsisteAUnBacanalTomaDosTragosYPierdeEnergia() {
        //Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority, Mockito.mock(Logger.class));

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
    public void unGladiadorAsisteAUnBacanalTomaTresTragosYPierdeEnergia() {
        //Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority, Mockito.mock(Logger.class));

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
    public void unGladiadorAsisteAUnBacanalTomaCuatroTragosYPierdeEnergia() {
        //Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority, Mockito.mock(Logger.class));

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
    public void unGladiadorAsisteAUnBacanalTomaCincoTragosYPierdeEnergia() {
        //Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority, Mockito.mock(Logger.class));

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
    public void unGladiadorAsisteAUnBacanalYSuEnergiaQuedaNegativa() {
        //Arrange
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority, Mockito.mock(Logger.class));

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
