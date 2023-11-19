package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.Concecuencias.Comida;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.SinEquipamiento;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.Senority.Novato;
import edu.fiuba.algo3.Gladiador.Senority.Senority;
import edu.fiuba.algo3.inventario.InventarioDeEquipamiento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso4 {

    private Gladiador gladiador;

    @BeforeEach
    void setUp() {
        Casillero casillero = new Casillero(0);
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Novato();
        InventarioDeEquipamiento inventarioDeEquipamiento = new InventarioDeEquipamiento();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority, inventarioDeEquipamiento);
    }

    @Test
    public void verificarQueSiRecibeComidaIncrementaEnergiaEn10() {
        // TODO: falta capas quitar el .getEnergia()
        // Arrange
        Comida comida = new Comida();

        // Act
        comida.afectarGladiador(gladiador);

        // Assert
        assertEquals(gladiador.getEnergia(), 30);
    }
}
