package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.data_acceso.DAOs.CaminoDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.data_mappers.CaminoMapper;
import edu.fiuba.algo3.data_acceso.data_mappers.CeldaMapper;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepository;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepositoryImpl;
import edu.fiuba.algo3.entrega_2.Json_test_resources.CasoDeUso15_16_17;
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.camino.Camino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso15Test {

    Path json = Paths.get("src/main/test/edu/fiuba/algo3/entrega_2/Json_test_resources/CasoDeUso15_16_17.json");
    private Camino caminoEsperado;

    @BeforeEach
    public void setUp() {
        this.caminoEsperado = CasoDeUso15_16_17.obtenerCaminoHardcodeado();
    }

    @Test
    public void verificarLecturaYConversionUnidadesModeloDominioJsonEnemigos() throws Exception {
        // Arrange.
        // CaminoRepository para obtener el camino desde el json
        Dado dadoParaBacanal = new Dado();
        CeldaMapper celdaMapper = new CeldaMapper(dadoParaBacanal);
        CaminoRepository caminoRepository = new CaminoRepositoryImpl(
                new CaminoDAOJsonImpl(json),
                new CaminoMapper(celdaMapper)
        );

        // Act
        Camino camino = caminoRepository.obtener();

        // Assert
        assertEquals(caminoEsperado, camino);
    }
}
