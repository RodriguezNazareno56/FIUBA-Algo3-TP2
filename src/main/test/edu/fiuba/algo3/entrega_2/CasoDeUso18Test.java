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
    public void setUp() throws IOException {
        CaminoRepository caminoRepository = new CaminoRepositoryImpl(
                new CaminoDAOJsonImpl(json),
                new CaminoMapper(new CeldaMapper()));
        MapaRepository mapaRepository = new MapaRepositoryImpl(
                new MapaDAOJsonImpl(json),
                new MapaMapper());
        MapaService mapaService = new MapaService(caminoRepository, mapaRepository);

        // Mockeo el dado para que siempre se avance de a una posicion
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.tirarDado()).thenReturn(1);

        // Mockeo el logger
        this.loggerMock = Mockito.mock(Logger.class);

        // Creo un algo roma y le agrego un gladiador
        this.algoRoma = new AlgoRoma(mapaService, dado, loggerMock);
        algoRoma.agregarGladiador("Mike Tyson");
    }

    @Test
    public void verificarSistemaLogNecesarioEntrega3() {
        // Act
        algoRoma.inicializarJuego();

        // Verify
        Mockito.verify(loggerMock, Mockito.times(1)).info(Mockito.anyString());
    }
}
