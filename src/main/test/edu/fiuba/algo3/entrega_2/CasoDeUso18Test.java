package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.data_acceso.DAOs.CaminoDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.DAOs.MapaDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.data_acceso.data_mappers.CaminoMapper;
import edu.fiuba.algo3.data_acceso.data_mappers.CeldaMapper;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.data_acceso.data_mappers.MapaMapper;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepository;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepositoryImpl;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepository;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepositoryImpl;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso18Test {

    Path json = Paths.get("src/main/test/edu/fiuba/algo3/entrega_2/Json_test_resources/CasoDeUso16.json");
    Logger loggerMock;
    AlgoRoma algoRoma;

    @BeforeEach
    public void setUp() throws Exception {
        // Mockeo el logger
        this.loggerMock = Mockito.mock(Logger.class);

        // Mockeo el mapaService
        MapaService mapaServiceMock = Mockito.mock(MapaService.class);
        Mockito.when(mapaServiceMock.cargarMapa()).thenReturn(Mockito.mock(Mapa.class));

        // Instancio AlgoRoma
        this.algoRoma = new AlgoRoma(mapaServiceMock, Mockito.mock(Dado.class), loggerMock);
    }

    @Test
    public void verificarSistemaLogNecesarioEntrega3() {
        // Act
        algoRoma.inicializarJuego();

        // Verify
        // this.logger.info("Juego inicilizado") al inicializar juego
        Mockito.verify(loggerMock, Mockito.times(1)).info(Mockito.anyString());
    }
}
