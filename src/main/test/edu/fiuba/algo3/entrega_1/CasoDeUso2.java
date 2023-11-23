package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.equipamientos.Equipamiento;
import edu.fiuba.algo3.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.gladiador.Energia;
import edu.fiuba.algo3.gladiador.Gladiador;
import edu.fiuba.algo3.gladiador.senority.Novato;
import edu.fiuba.algo3.gladiador.senority.Senority;
import edu.fiuba.algo3.casilleros.CasillerosFactory;
import edu.fiuba.algo3.casilleros.ICasillero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso2 {

    private Gladiador gladiador;

    @BeforeEach
    void setUp() {
        CasillerosFactory casillerosFactory = new CasillerosFactory();
        ICasillero casillero = casillerosFactory.construirCasilleros(2);
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Novato();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void verificarQueElJugadorSalgaDeLaCasillaInicial() {

        // Assert
        Throwable exception= Assertions.assertThrows(MovimientoException.class,
                this.gladiador::retroceder);
        assertEquals("Gladiador: Movimiento invalido", exception.getMessage());
    }
}
