package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.Concecuencias.Consecuencia;
import edu.fiuba.algo3.Concecuencias.EquipamientoIncrementado;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.SinEquipamiento;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.Senority.Novato;
import edu.fiuba.algo3.Gladiador.Senority.Senority;
import edu.fiuba.algo3.inventario.Inventario;
import edu.fiuba.algo3.inventario.InventarioDeEquipamiento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso5 {

    private Gladiador gladiador;

    /**@BeforeEach
    void setUp() {
        Casillero casillero = new Casillero(0);
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Nada();
        Senority senority = new Novato();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }**/

    @Test
    public void verificarQueSiRecibeUnPremioPorPrimeraVezObtieneUnCasco() {
        // TODO: falta implementar
        //Arrange
        Casillero casillero = new Casillero(0);
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Novato();
        Inventario<Equipamiento> inventarioDeEquipamiento = new InventarioDeEquipamiento();
        Consecuencia incrementoDeEquipo = new EquipamientoIncrementado();

        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority, inventarioDeEquipamiento);

        //Act
        incrementoDeEquipo.afectarGladiador(gladiador);

        //Assert
        assertEquals(gladiador.obtenerEquipamiento(), inventarioDeEquipamiento.buscarPor(1));
    }
}
