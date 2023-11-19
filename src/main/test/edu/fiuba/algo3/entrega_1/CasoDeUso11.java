package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Casillero;
import edu.fiuba.algo3.Concecuencias.Consecuencia;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.Llave;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Concecuencias.EquipamientoIncrementado;
import edu.fiuba.algo3.Gladiador.Senority.Novato;
import edu.fiuba.algo3.Gladiador.Senority.Senority;
import edu.fiuba.algo3.Inventario.Inventario;
import edu.fiuba.algo3.Inventario.InventarioDeEquipamiento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso11 {

    private Gladiador gladiador;
    private Inventario<Equipamiento> inventarioDeEquipamiento;
    private Equipamiento equipamiento;

    @BeforeEach
    void setUp() {
        Casillero casillero = new Casillero(0);
        Senority senority = new Novato();
        Energia energia = new Energia(20);
        this.equipamiento = new Llave();
        this.inventarioDeEquipamiento = new InventarioDeEquipamiento();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority, inventarioDeEquipamiento);
    }

    @Test
    public void verificarQueSiElGladiadorTieneLaLlaveYRecibeOtroPremioNoCambiaNada() {
        // TODO: falta implementar
        Consecuencia equipamientoIncrementado = new EquipamientoIncrementado();

        this.gladiador.recibirConsecuencia(equipamientoIncrementado);

        assertEquals(gladiador.obtenerEquipamiento(), this.inventarioDeEquipamiento.buscarPor(this.equipamiento));

    }
}
