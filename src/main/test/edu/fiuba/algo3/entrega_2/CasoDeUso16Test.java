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
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.camino.Camino;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso16Test {

    Path json = Paths.get("src/main/test/edu/fiuba/algo3/entrega_2/Json_test_resources/CasoDeUso15_16_17.json");
    private Mapa mapaEsperado;

    @BeforeEach
    public void setUp() {
        int ancho = 10;
        int largo = 18;
        this.mapaEsperado = new Mapa(ancho, largo);

        Camino caminoEsperado = CasoDeUso15_16_17.obtenerCaminoHardcodeado();
        this.mapaEsperado.setCamino(caminoEsperado);
    }

    @Test
    public void verificarLecturaYConversionUnidadesModeloDominioJsonMapa() throws Exception {
        // Arrange
        // MapaService para obtener el mapa desde el json
        Dado dadoParaBacanal = new Dado();
        CeldaMapper celdaMapper = new CeldaMapper(dadoParaBacanal);
        CaminoRepository caminoRepository = new CaminoRepositoryImpl(
                new CaminoDAOJsonImpl(json),
                new CaminoMapper(celdaMapper));

        MapaRepository mapaRepository = new MapaRepositoryImpl(
                new MapaDAOJsonImpl(json),
                new MapaMapper());

        MapaService mapaService = new MapaService(caminoRepository, mapaRepository);

        // Act
        Mapa mapa = mapaService.cargarMapa();

        // Assert
        assertEquals(mapaEsperado, mapa);
    }
}
