package edu.fiuba.algo3.entrega_1.otros;

import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.SinEquipamiento;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.senority.Novato;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import edu.fiuba.algo3.MovimientoExeption;
import edu.fiuba.algo3.casilleros.CasilleroFactory;
import edu.fiuba.algo3.casilleros.ICasillero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GladiadorAvanza5CasillerosTest {

    private Gladiador gladiador;

    @BeforeEach
    public void setUp() {
        CasilleroFactory casilleroFactory = new CasilleroFactory();
        ICasillero casilleroInicial = casilleroFactory.construirCasilleros(10);
        ICasillero casillero = casilleroInicial;
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Novato();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void gladiadorAvanzar5CasillerosAvanza5Casilleros() {
        // Act
        try {
            gladiador.avanzar(5);
        } catch (MovimientoExeption e) {
            assert false;
        }

        // Assert
        assertEquals(gladiador.getPosicion(), 5);
    }
}
