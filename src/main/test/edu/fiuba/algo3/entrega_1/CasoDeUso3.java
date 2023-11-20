package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.SinEquipamiento;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.senority.Novato;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import edu.fiuba.algo3.inventario.InventarioDeEquipamiento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso3 {

    private Gladiador gladiador;

    @BeforeEach
    void setUp() {
        Casillero casillero = new Casillero(0);
        Energia energia = new Energia(0);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Novato();
        InventarioDeEquipamiento inventarioDeEquipamiento = new InventarioDeEquipamiento();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority, inventarioDeEquipamiento);
    }

    @Test
    public void verificarQueUnJugadorSinEnergiaNoPuedaJugarElTurno() {
        // TODO: falta implementar
        Throwable exception= Assertions.assertThrows(MovimientoExeption.class, () -> {
            this.gladiador.avanzar();
        });
        assertEquals("El gladiador no se puede mover sin energia", exception.getMessage());
    }
}
