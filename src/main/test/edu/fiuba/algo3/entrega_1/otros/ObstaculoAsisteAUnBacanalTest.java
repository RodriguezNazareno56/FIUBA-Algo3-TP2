package edu.fiuba.algo3.entrega_1.otros;

import edu.fiuba.algo3.casilleros.Casillero;
import edu.fiuba.algo3.consecuencias.AsisteAUnBacanal;
import edu.fiuba.algo3.consecuencias.Consecuencia;
import edu.fiuba.algo3.equipamientos.Equipamiento;
import edu.fiuba.algo3.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.gladiador.Energia;
import edu.fiuba.algo3.gladiador.Gladiador;
import edu.fiuba.algo3.gladiador.senority.Novato;
import edu.fiuba.algo3.gladiador.senority.Senority;
import edu.fiuba.algo3.MovimientoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObstaculoAsisteAUnBacanalTest {

    @Test
    public void verificarQueSiRecibeUnObstaculoAsisteAUnBacanalSacaCuatroPuntosDeEnergiaPorCadaTragoTomado() throws Exception {
        //Arrange
        int cantiadDeTragos = 6;
        Consecuencia asisteAUnBacanal = new AsisteAUnBacanal(cantiadDeTragos);
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Gladiador gladiador = new Gladiador(energia, equipamiento, casillero, senority);

        //Act
        gladiador.recibirConsecuencia(asisteAUnBacanal);

        //Assert
        Throwable exception= Assertions.assertThrows(MovimientoException.class, () -> {
            gladiador.avanzar(1);
        });
        assertEquals("El gladiador no se puede mover sin energia", exception.getMessage());
    }
}
