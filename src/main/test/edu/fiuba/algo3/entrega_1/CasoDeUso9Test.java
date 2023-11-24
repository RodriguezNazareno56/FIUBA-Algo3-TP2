package edu.fiuba.algo3.entrega_1;

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

public class CasoDeUso9Test {

    private Gladiador gladiador;
    private final int cantidadDeCasilleros = 10;

    @BeforeEach
    public void setUp() {
        CasillerosFactory casillerosFactory = new CasillerosFactory();
        ICasillero casillero = casillerosFactory.construirCasilleros(cantidadDeCasilleros);
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void verificarQueSiLlegaALaMetaSinLaLlaveEnElEquipamientoRetrocedeALaMitadDeLasCasillas() throws Exception {
        // Act
        this.gladiador.avanzar(cantidadDeCasilleros);

        // Assert
        // Al llegar al final sin la llave vuelve a mitad de las casillas
        assertEquals(cantidadDeCasilleros/2, this.gladiador.getPosicion());
    }
}
