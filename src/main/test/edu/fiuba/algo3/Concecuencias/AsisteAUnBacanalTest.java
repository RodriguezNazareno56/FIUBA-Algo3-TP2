package edu.fiuba.algo3.Concecuencias;

import edu.fiuba.algo3.Casillero;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.SinEquipamiento;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.senority.Novato;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AsisteAUnBacanalTest {


    @Test
    public void afectarGladiador(){
        //Arrange
        int cantiadDeTragos = 6;
        Consecuencia asisteAUnBacanal = new AsisteAUnBacanal(cantiadDeTragos);
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
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

        AsisteAUnBacanal bacanal = new AsisteAUnBacanal(1);
        int energiaEsperada = 16; // se le restan 4 * cantidadTragos

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
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

        AsisteAUnBacanal bacanal = new AsisteAUnBacanal(2);
        int energiaEsperada = 12; // se le restan 4 * cantidadTragos

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
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

        AsisteAUnBacanal bacanal = new AsisteAUnBacanal(3);
        int energiaEsperada = 8; // se le restan 4 * cantidadTragos

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
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

        AsisteAUnBacanal bacanal = new AsisteAUnBacanal(4);
        int energiaEsperada = 4; // se le restan 4 * cantidadTragos

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
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

        AsisteAUnBacanal bacanal = new AsisteAUnBacanal(5);
        int energiaEsperada = 0; // se le restan 4 * cantidadTragos

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
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

        AsisteAUnBacanal bacanal = new AsisteAUnBacanal(6);
        int energiaEsperada = -4; // se le restan 4 * cantidadTragos

        //Act
        bacanal.afectarGladiador(gladiador);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());
    }
}
