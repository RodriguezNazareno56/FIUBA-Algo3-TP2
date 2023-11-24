package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.casilleros.Casillero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso3Test {

    private Gladiador gladiador;

    @BeforeEach
    public void setUp() {
        Casillero casillero = new Casillero(0);
        Energia energia = new Energia(0);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void verificarQueUnJugadorSinEnergiaNoPuedaJugarElTurno() {
        Assertions.assertThrows(MovimientoException.class,() -> {
            gladiador.avanzar(1);
        });
    }
}
