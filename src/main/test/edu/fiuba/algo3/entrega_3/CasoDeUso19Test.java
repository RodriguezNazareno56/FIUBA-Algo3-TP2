package edu.fiuba.algo3.entrega_3;

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
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.JuegoNoIniciadoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CasoDeUso19Test {

    Path json = Paths.get("src/main/test/edu/fiuba/algo3/entrega_3/json_test_resources/CasoDeUso19.json");
    AlgoRoma algoRoma;

    @BeforeEach
    public void setUp() throws Exception {
        CaminoRepository caminoRepository = new CaminoRepositoryImpl(
                new CaminoDAOJsonImpl(json),
                new CaminoMapper(new CeldaMapper(new Dado())));
        MapaRepository mapaRepository = new MapaRepositoryImpl(
                new MapaDAOJsonImpl(json),
                new MapaMapper());
        MapaService mapaService = new MapaService(caminoRepository, mapaRepository);

        // Mockeo el dado para que siempre se avance de a una posicion
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.tirarDado()).thenReturn(1);

        // Creo un algo roma y le agrego un gladiador
        this.algoRoma = new AlgoRoma(mapaService, dado, LoggerFactory.getLogger(AlgoRoma.class));
    }

    @Test
    public void simularVerificarQueElJugadorGanaUnaPartida() throws Exception {
        // Arrange
        algoRoma.agregarGladiador("Mike Tyson");
        algoRoma.agregarGladiador("Rocky Balboa");

        // Act
        // Los jugadores llegan hasta la anteultima casilla con equipamiento llave
        for (int i = 0; i < 8; i++) {
            algoRoma.jugarTurno();
        }

        // Assert
        Assertions.assertThrows(FinDelJuegoException.class, algoRoma::jugarTurno);
    }
}
