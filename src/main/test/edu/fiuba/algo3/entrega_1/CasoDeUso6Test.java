package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;
import edu.fiuba.algo3.modelo.consecuencias.EquipamientoIncrementado;
import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.casilleros.Casillero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso6Test {

    private Gladiador gladiador;

    @BeforeEach
    void setUp() {
        Casillero casillero = new Casillero(0);
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        this.gladiador = new Gladiador(energia, equipamiento, casillero, senority);
    }

    @Test
    public void verificarQueSiRecibeUnPremioPorTerceraVezObtieneEscudoYEspada() throws Exception {
        //Arrange
        Consecuencia incrementoDeEquipo = new EquipamientoIncrementado();

        //Act
        this.gladiador.recibirConsecuencia(incrementoDeEquipo);
        this.gladiador.recibirConsecuencia(incrementoDeEquipo);
        this.gladiador.recibirConsecuencia(incrementoDeEquipo);
        this.gladiador.recibirAtaque(new FieraSalvaje());

        //Assert
        // Un gladiador sin equipamiento y con 20 puntos de vida. Recibira un premio por tercera vez y sera atacado
        // por una fiera, se espera que se defienda con el EscudoYEspada y tan solo sufra 2 puntos de danio
        assertEquals(18, this.gladiador.getEnergia());
    }
}