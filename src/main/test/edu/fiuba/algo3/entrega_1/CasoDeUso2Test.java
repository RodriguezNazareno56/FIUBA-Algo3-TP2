package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CasoDeUso2Test {

    private Gladiador gladiador;
    private Mapa mapa;

    @BeforeEach
    public void setUp() {
        List<ICelda> celdas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            celdas.add(new Celda(new Coordenada(i,i), new ArrayList<>()));
        }
        Camino camino = new Camino(celdas);

        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        this.gladiador = new Gladiador(energia, equipamiento, senority);

        List<Gladiador> gladiadores = new ArrayList<>();
        gladiadores.add(this.gladiador);

        this.mapa = new Mapa(10, 10, camino, gladiadores);
    }

    @Test
    public void verificarQueElJugadorSalgaDeLaCasillaInicial() {
        Assertions.assertThrows(MovimientoException.class, () -> {
            mapa.retrocederNPosicionesGladiador(gladiador, 1);
        });
    }
}
