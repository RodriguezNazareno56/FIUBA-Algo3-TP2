package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.celda.Celda;
import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.consecuencias.Triunfo;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.equipamientos.Llave;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.consecuencias.EquipamientoIncrementado;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso11Test {

    private Gladiador gladiador;
    private Mapa mapa;
    private List<ICelda> celdas;

    @BeforeEach
    public void setUp() throws NombreInvalidoException {
        // Construyo un camino con 9 celdas sin consecuencias y una celda final con consecuencia Triunfo
        this.celdas = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            celdas.add(new Celda(new Coordenada(i,i), new ArrayList<>()));
        }
        // Celda final con consecuencia Triunfo
        List<IConsecuencia> consecuencias = new ArrayList<>();
        IConsecuencia triunfo = new Triunfo();
        consecuencias.add(triunfo);
        celdas.add(new Celda(new Coordenada(9,9), consecuencias));
        Camino camino = new Camino(celdas);

        // Construyo un Gladiador
        Energia energia = new Energia(20);
        Equipamiento equipamiento = new Llave();
        Senority senority = new Senority();
        String nombre = "Espartaco";
        this.gladiador = new Gladiador(nombre,energia, equipamiento, senority, Mockito.mock(Logger.class));

        // Construyo un mapa con el camino y el gladiador
        this.mapa = new Mapa(10, 10, camino);
        this.mapa.setGladiador(gladiador);
    }

    @Test
    public void verificarQueSiElGladiadorTieneLaLlaveYRecibeOtroPremioNoCambiaNada() throws Exception {
        // Arrange
        IConsecuencia equipamientoIncrementado = new EquipamientoIncrementado();

        // Act
        equipamientoIncrementado.afectarGladiador(gladiador);

        // Assert
        // Si al llegar a la ultima celda, el jugador no retrocede a la mitad del camino significa que tras
        // recibir otra premio teniendo la llave, no cambio de equipo sino que aun conserva la llave
        mapa.avanzarNPosicionesGladiador(this.gladiador,10);
        assertEquals(this.celdas.get(celdas.size()-1), mapa.getPosicionDeGladiador(gladiador));
    }
}
