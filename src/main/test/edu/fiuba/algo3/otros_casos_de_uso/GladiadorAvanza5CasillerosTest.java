package edu.fiuba.algo3.otros_casos_de_uso;

import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.casilleros.CasillerosFactory;
import edu.fiuba.algo3.modelo.casilleros.ICasillero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GladiadorAvanza5CasillerosTest {

    private Gladiador gladiador;

    @BeforeEach
    public void setUp() {
        CasillerosFactory casillerosFactory = new CasillerosFactory();
        ICasillero casilleroInicial = casillerosFactory.construirCasilleros(10);
        ICasillero casillero = casilleroInicial;
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void gladiadorAvanzar5CasillerosAvanza5Casilleros() {
        // Act
        try {
            gladiador.avanzar(5);
        } catch (Exception e) {
            assert false;
        }

        // Assert
        assertEquals(5, gladiador.getPosicion());
    }
}
