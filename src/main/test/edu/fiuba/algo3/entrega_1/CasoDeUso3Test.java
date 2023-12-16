package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import edu.fiuba.algo3.modelo.gladiador.exepciones.MovimientoException;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

public class CasoDeUso3Test {

    private Gladiador gladiador;

    @BeforeEach
    public void setUp() throws NombreInvalidoException {
        Energia energia = new Energia(0);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        this.gladiador = new Gladiador(nombre, energia, equipamiento, senority, Mockito.mock(Logger.class));
    }

    @Test
    public void verificarQueUnJugadorSinEnergiaNoPuedaJugarElTurno() {
        Assertions.assertThrows(MovimientoException.class, gladiador::avanzar);
    }
}
