package edu.fiuba.algo3.otros_casos_de_uso;

import edu.fiuba.algo3.modelo.consecuencias.AsisteAUnBacanal;
import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.MovimientoException;
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
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority);

        //Act
        gladiador.recibirConsecuencia(asisteAUnBacanal);

        //Assert
        Assertions.assertThrows(MovimientoException.class, gladiador::avanzar);
    }
}
