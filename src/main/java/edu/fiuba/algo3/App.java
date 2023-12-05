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
import edu.fiuba.algo3.vista.BienvenidaPantalla;
import edu.fiuba.algo3.vista.Jugador.AgregarJugadorPantalla;
import edu.fiuba.algo3.vista.dado.DadoButton;
import edu.fiuba.algo3.vista.mapa.AlgoRomaPantalla;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.LoggerFactory;

import java.io.IOException;
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

        AlgoRoma algoRoma = new AlgoRoma(mapaService, dado, LoggerFactory.getLogger("App"));

        /*
        StackPane root = new StackPane();
        var arena = new Arena(algoRoma);
        var arenaScene = new Scene(new StackPane(arena), 640, 480);
        var jugador = new Scene(new StackPane(new Jugador(stage, arenaScene, algoRoma)), 640, 480);
        root.getChildren().add(new Bienvenida(stage, jugador));
        var escens = new Scene(root,640, 480);
        stage.setScene(escens);
        stage.setWidth(1200);
        stage.setHeight(600);
        stage.show();
        */

        DadoButton dadoButton = new DadoButton(algoRoma);
        dado.agregarObservador(dadoButton);

        // TODO: renombrar escenaArena
        AlgoRomaPantalla algoRomaPantalla = new AlgoRomaPantalla(algoRoma, dadoButton);
        Scene escenaArena = new Scene(algoRomaPantalla, 640, 480 );

        AgregarJugadorPantalla agregarJugadorPantalla = new AgregarJugadorPantalla(stage, escenaArena, algoRoma );
        Scene escenaJugador = new Scene(agregarJugadorPantalla, 640, 480);

        BienvenidaPantalla bienvenidaPantalla = new BienvenidaPantalla(stage, escenaJugador);
        Scene escenaBienvenida = new Scene(bienvenidaPantalla, 640, 480);


        stage.setScene(escenaBienvenida);
        stage.setWidth(1200);
        stage.setHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}