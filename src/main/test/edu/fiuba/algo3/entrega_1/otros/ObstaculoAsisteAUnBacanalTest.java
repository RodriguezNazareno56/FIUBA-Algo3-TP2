package edu.fiuba.algo3.entrega_1.otros;

import edu.fiuba.algo3.Casillero;
import edu.fiuba.algo3.Concecuencias.AsisteAUnBacanal;
import edu.fiuba.algo3.Concecuencias.Consecuencia;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.SinEquipamiento;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.senority.Novato;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObstaculoAsisteAUnBacanalTest {

    @Test
    public void verificarQueSiRecibeUnObstaculoAsisteAUnBacanalSacaCuatroPuntosDeEnergiaPorCadaTragoTomado(){
        //Arrange
        int cantiadDeTragos = 3;
        Consecuencia asisteAUnBacanal = new AsisteAUnBacanal(cantiadDeTragos);
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);
        int energiaEsperada = 8;

        //Act
        gladiador.recibirConsecuencia(asisteAUnBacanal);

        //Assert
        assertEquals(energiaEsperada, gladiador.getEnergia());


    }
}
