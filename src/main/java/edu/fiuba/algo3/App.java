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
import edu.fiuba.algo3.modelo.AlgoRomaModelo;
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.vista.BienvenidaPantalla;
import edu.fiuba.algo3.vista.ViewProperties;
import edu.fiuba.algo3.vista.dado.DadoButton;
import edu.fiuba.algo3.vista.ElegirGladiadorPantalla;
import edu.fiuba.algo3.vista.AlgoRomaPantalla;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * JavaFX App
 */
public class App extends Application {

    private AlgoRomaModelo algoRoma;
    private Dado dado;

    @Override
    public void start(Stage stage) throws IOException {
        this.cargarDependencias();

        HashMap<String, String> colorPorClaveNombreGladiador = new HashMap<>();

        AudioClip sonidoDeFondo = new AudioClip("file:src/main/resources/edu/fiuba/algo3/vista/media/gamemusic.mp3");
        sonidoDeFondo.play();

        DadoButton dadoButton = new DadoButton(algoRoma, stage);
        dado.agregarObservador(dadoButton);

        AlgoRomaPantalla algoRomaPantalla = new AlgoRomaPantalla(stage, algoRoma, dadoButton, colorPorClaveNombreGladiador, sonidoDeFondo);
        Scene mapaVista = new Scene(algoRomaPantalla, ViewProperties.stageMaximoAlto, ViewProperties.stageMaximoAncho );

        ElegirGladiadorPantalla agregarJugadorPantalla = new ElegirGladiadorPantalla(stage, mapaVista,
                algoRoma , algoRomaPantalla, colorPorClaveNombreGladiador, sonidoDeFondo);
        Scene escenaJugador = new Scene(agregarJugadorPantalla, ViewProperties.stageMaximoAlto, ViewProperties.stageMaximoAncho);

        BienvenidaPantalla bienvenidaPantalla = new BienvenidaPantalla(stage, escenaJugador, sonidoDeFondo);
        Scene escenaBienvenida = new Scene(bienvenidaPantalla, ViewProperties.stageMaximoAlto, ViewProperties.stageMaximoAncho);


        stage.setScene(escenaBienvenida);
        stage.setWidth(ViewProperties.stageMaximoAlto);
        stage.setHeight(ViewProperties.stageMaximoAncho);
        stage.centerOnScreen();
        stage.show();
    }

    private void cargarDependencias() throws IOException {
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

         dado = new Dado();

         algoRoma = new AlgoRoma(mapaService, dado, LoggerFactory.getLogger("App"));
    }



    public static void main(String[] args) {
        launch();
    }

}