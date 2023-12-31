package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import edu.fiuba.algo3.modelo.gladiador.exepciones.MovimientoException;
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
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CasoDeUso2Test {

    private Gladiador gladiador;
    private Mapa mapa;

    @BeforeEach
    public void setUp() throws NombreInvalidoException {
        // Construyo un camino con 10 celdas
        List<ICelda> celdas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            celdas.add(new Celda(new Coordenada(i,i), new ArrayList<>()));
        }
        Camino camino = new Camino(celdas);

        // Construyo un gladiador
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new SinEquipamiento();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        this.gladiador = new Gladiador(nombre,energia, equipamiento, senority, Mockito.mock(Logger.class));

        // construyo un Mapa con el camino y el gladiador
        this.mapa = new Mapa(10, 10, camino);
        this.mapa.setGladiador(gladiador);
    }

    @Test
    public void verificarQueElJugadorSalgaDeLaCasillaInicial() {
        Assertions.assertThrows(MovimientoException.class, () -> {
            mapa.retrocederNPosicionesGladiador(gladiador, 1);
        });
    }
}
