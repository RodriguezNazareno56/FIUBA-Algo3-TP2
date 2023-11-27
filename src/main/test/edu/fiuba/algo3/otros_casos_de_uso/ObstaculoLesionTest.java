package edu.fiuba.algo3.otros_casos_de_uso;

import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;
import edu.fiuba.algo3.modelo.consecuencias.Lesion;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.MovimientoPausadoExeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObstaculoLesionTest {

    @Test
    public void verificarQueSiRecibeUnObstaculoLesionYSeEncuentraEnELTurnoSiguienteNoSePuedeMover() throws Exception {
        //Arrange
        Consecuencia lesion = new Lesion();
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        Gladiador gladiador = new Gladiador(energia, equipamiento, senority);

        //Act
        gladiador.recibirConsecuencia(lesion);

        //Assert
        Assertions.assertThrows(MovimientoPausadoExeption.class, () -> {
            gladiador.avanzar(1);
        });
    }
}
