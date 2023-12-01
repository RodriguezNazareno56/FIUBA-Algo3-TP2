package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.data_acceso.DAOs.CaminoDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.DAOs.MapaDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.data_acceso.data_mappers.CaminoMapper;
import edu.fiuba.algo3.data_acceso.data_mappers.CeldaMapper;
import edu.fiuba.algo3.data_acceso.data_mappers.MapaMapper;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepository;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepositoryImpl;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepository;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepositoryImpl;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso17Test {

    Path json = Paths.get("src/main/test/edu/fiuba/algo3/entrega_2/Json_test_resources/CasoDeUso17.json");
    private MapaService mapaService;

    @BeforeEach
    public void setUp() throws Exception {
        // Mock de dado para jugar bacanal, siempre retorna 1
        Dado dadoMockParaJugarBacanal = Mockito.mock(Dado.class);
        Mockito.when(dadoMockParaJugarBacanal.tirarDado()).thenReturn(1);

        // MapaService
        CaminoRepository caminoRepository = new CaminoRepositoryImpl(
                new CaminoDAOJsonImpl(json),
                new CaminoMapper(new CeldaMapper(dadoMockParaJugarBacanal)));
        MapaRepository mapaRepository = new MapaRepositoryImpl(
                new MapaDAOJsonImpl(json),
                new MapaMapper());

        this.mapaService = new MapaService(caminoRepository, mapaRepository);
    }

    @Test
    public void verificarCreacionJuegoAcordeJson() throws Exception {
        // Misma estrategia que el casoDeUso17 pero esta vez instanciamos JuegoRoma
        // Arrange

        // Mockeo el dado para que siempre se avance de a una posicion
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.tirarDado()).thenReturn(1);

        // Creo un algo roma y le agrego un gladiador
        Logger loggerMock = Mockito.mock(Logger.class);
        AlgoRoma algoRoma = new AlgoRoma(mapaService, dado, loggerMock);
        algoRoma.agregarGladiador("Mike Tyson");

        // Act
        algoRoma.inicializarJuego();

        // Obtengo el gladiador para testear que sea afectado del modo esperado  TODO: posible refactor.
        Gladiador gladiador = null;
        for (Gladiador g : algoRoma.getGladiadores()) {
            if (g.getNombre().equals("Mike Tyson")) {
                gladiador = g;
            }
        }

        // Assert

        // El json especifica, en la segunda celda un premio de equipamiento.
        // El gladiador ha sido inicializado con  puntos de energia y sin equipamiento se espera que reciba un casco.
        algoRoma.jugarTurno();
        // El json especifica, en la tercer celda una Fiera.
        // Se espera que sea daniado por 15 puntos de energia ya que en la celda anterior recibio un casco.
        algoRoma.jugarTurno();
        assertEquals(new Energia(5), gladiador.getEnergia());

        // El json especifica, en la cuarta celda un Lesion
        algoRoma.jugarTurno();
        Assertions.assertThrows(Exception.class, algoRoma::jugarTurno);

        // El json especifica, en la quinta celda un Premio de comida.
        // Se espera que el gladiador que poseia 5 puntos de energia incremente en 15 llegando asi a 20 puntos.
        algoRoma.jugarTurno();
        assertEquals(new Energia(20), gladiador.getEnergia());

        // El json especifica, en la sexta celda un Bacanal. El dado con el que se juega el bacanal esta mockeado y
        // siempre retonar 1 por lo toma un solo trago y se pierde 4 puntos
        algoRoma.jugarTurno();
        assertEquals(new Energia(16), gladiador.getEnergia());

        // Comprobada la conversion de todas las entidades del modelo (celdas, obstaculos, premios). Comprobaremos
        // que una celda especificada con un obstaculo y un premio al mismo tiempo es construida correctamente.
        // El json especifica, en la septima celda una Lesion y un premio de Comida.
        algoRoma.jugarTurno();
        assertEquals(new Energia(16+15), gladiador.getEnergia());
        Assertions.assertThrows(Exception.class, gladiador::avanzar);

        // El json especifica, en la octava la celda final. Esperamos que se comporte como tal y siendo que el gladiador
        // no posee la llave, este sea retornado a mitad del camino (cuarta celda).
        algoRoma.jugarTurno();
        // El json especifica, en la quinta celda un Premio de comida.
        // Se espera que el gladiador que poseia 31 puntos de energia incremente en 15 llegando asi a 31 puntos.
        algoRoma.jugarTurno();
        assertEquals(new Energia(31+15), gladiador.getEnergia());
    }
}
