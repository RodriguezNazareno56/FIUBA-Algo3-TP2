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
import edu.fiuba.algo3.entrega_2.Json_test_resources.CasoDeUso15_16_17;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso17Test {

    Path json = Paths.get("src/main/test/edu/fiuba/algo3/entrega_2/Json_test_resources/CasoDeUso15_16_17.json");
    private Mapa mapaEsperado;
    private MapaService mapaService;

    @BeforeEach
    public void setUp() throws Exception {
        int ancho = 10;
        int largo = 18;
        this.mapaEsperado = new Mapa(ancho, largo);

        // Seteo al mapaEsperado el caminoEsperado
        Camino caminoEsperado = CasoDeUso15_16_17.obtenerCaminoHardcodeado();
        this.mapaEsperado.setCamino(caminoEsperado);

        // MapaService
        Dado dadoParaBacanal = new Dado();
        CeldaMapper celdaMapper = new CeldaMapper(dadoParaBacanal);
        CaminoRepository caminoRepository = new CaminoRepositoryImpl(
                new CaminoDAOJsonImpl(json),
                new CaminoMapper(celdaMapper));
        
        MapaRepository mapaRepository = new MapaRepositoryImpl(
                new MapaDAOJsonImpl(json),
                new MapaMapper());

        this.mapaService = new MapaService(caminoRepository, mapaRepository);
    }

    @Test
    public void verificarCreacionJuegoAcordeJson() throws Exception {
        // Misma estrategia que el casoDeUso17 pero esta vez instanciamos JuegoRoma
        // Arrange
        Dado dado = new Dado();
        Logger loggerMock = Mockito.mock(Logger.class);
        
        // Act
        AlgoRoma algoRoma = new AlgoRoma(mapaService, dado, loggerMock);

        // Assert
        Mapa mapaEnAlgoRoma = algoRoma.getMapa();
        assertEquals(mapaEsperado, mapaEnAlgoRoma);
    }
}
