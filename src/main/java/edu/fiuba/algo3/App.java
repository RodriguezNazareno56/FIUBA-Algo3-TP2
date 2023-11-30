package edu.fiuba.algo3;

import edu.fiuba.algo3.data_acceso.DAOs.CaminoDAO;
import edu.fiuba.algo3.data_acceso.DAOs.CaminoDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.DAOs.MapaDAO;
import edu.fiuba.algo3.data_acceso.DAOs.MapaDAOJsonImpl;
import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.data_acceso.data_mappers.CaminoMapper;
import edu.fiuba.algo3.data_acceso.data_mappers.CeldaMapper;
import edu.fiuba.algo3.data_acceso.data_mappers.MapaMapper;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepository;
import edu.fiuba.algo3.data_acceso.repositories.CaminoRepositoryImpl;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepositoryImpl;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepository;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.vista.Bienvenida;
import edu.fiuba.algo3.vista.Configuracion;
import edu.fiuba.algo3.vista.Jugador.Jugador;
import edu.fiuba.algo3.vista.arena.Arena;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.EventRecordingLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        Path jsonPath = Paths.get("src/main/resources/mapa.json");
        CaminoDAO caminoDAO = new CaminoDAOJsonImpl(jsonPath);
        Dado dadoParaBacanal = new Dado();
        CeldaMapper celdaMapper = new CeldaMapper(dadoParaBacanal);
        CaminoMapper caminoMapper = new CaminoMapper(celdaMapper);

        CaminoRepository caminoRepository = new CaminoRepositoryImpl(caminoDAO, caminoMapper);

        MapaDAO mapaDAO = new MapaDAOJsonImpl(jsonPath);
        MapaMapper mapaMapper = new MapaMapper();

        MapaRepository mapaRepository = new MapaRepositoryImpl(mapaDAO,mapaMapper);

        MapaService mapaService = new MapaService(caminoRepository, mapaRepository);
        Dado dado = new Dado();

        StackPane root = new StackPane();

        AlgoRoma algoRoma = new AlgoRoma(mapaService, dado, LoggerFactory.getLogger("App"));

        var arena = new Arena(algoRoma);
        var arenaScene = new Scene(new StackPane(arena), 640, 480);

        var jugador = new Scene(new StackPane(new Jugador(stage, arenaScene, algoRoma)), 640, 480);

        root.getChildren().add(new Bienvenida(stage, jugador));

        var escens = new Scene(root,640, 480);

        stage.setScene(escens);
        stage.setWidth(1200);
        stage.setHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}