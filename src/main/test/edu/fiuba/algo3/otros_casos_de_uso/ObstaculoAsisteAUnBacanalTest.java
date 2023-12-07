package edu.fiuba.algo3.otros_casos_de_uso;

import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.consecuencias.AsisteAUnBacanal;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.gladiador.exepciones.MovimientoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObstaculoAsisteAUnBacanalTest {

    @Test
    public void verificarQueSiRecibeUnObstaculoAsisteAUnBacanalSacaCuatroPuntosDeEnergiaPorCadaTragoTomado() throws Exception {
        //Arrange
        int cantiadDeTragos = 6;
        Dado dadoMock = Mockito.mock(Dado.class);
        Mockito.when(dadoMock.tirarDado()).thenReturn(cantiadDeTragos);
        IConsecuencia asisteAUnBacanal = new AsisteAUnBacanal(dadoMock);
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        Gladiador gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));

        //Act
        gladiador.recibirConsecuencia(asisteAUnBacanal);

        //Assert
        Assertions.assertThrows(MovimientoException.class, gladiador::avanzar);
    }
}
