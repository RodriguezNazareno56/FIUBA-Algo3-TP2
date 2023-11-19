package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.Concecuencias.Consecuencia;
import edu.fiuba.algo3.Concecuencias.EquipamientoIncrementado;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.Equipamientos.Nada;
import edu.fiuba.algo3.Gladiador.Energia;
import edu.fiuba.algo3.Gladiador.Gladiador;
import edu.fiuba.algo3.Gladiador.Senority.Novato;
import edu.fiuba.algo3.Gladiador.Senority.Senority;
import edu.fiuba.algo3.Inventario.Inventario;
import edu.fiuba.algo3.Inventario.InventarioDeEquipamiento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso6 {

    private Gladiador gladiador;
    private Inventario<Equipamiento> inventarioDeEquipamiento;

    @BeforeEach
    void setUp() {
        Casillero casillero = new Casillero(0);
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Nada();
        Senority senority = new Novato();
        this.inventarioDeEquipamiento = new InventarioDeEquipamiento();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority, inventarioDeEquipamiento);
    }

    @Test
    public void verificarQueSiRecibeUnPremioPorTerceraVezObtieneEscudoYEspada() {
        // TODO: falta implementar
        //Arrenge
        Consecuencia incrementoDeEquipo = new EquipamientoIncrementado();

        //Act
        this.gladiador.recibirConsecuencia(incrementoDeEquipo);
        this.gladiador.recibirConsecuencia(incrementoDeEquipo);
        this.gladiador.recibirConsecuencia(incrementoDeEquipo);

        assertEquals(gladiador.obtenerEquipamiento(), this.inventarioDeEquipamiento.buscarPor(3));
    }
}
