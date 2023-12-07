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
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.vista.BienvenidaPantalla;
import edu.fiuba.algo3.vista.Jugador.AgregarJugadorPantalla;
import edu.fiuba.algo3.vista.ViewProperties;
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

    private AlgoRoma algoRoma;
    private Dado dado;

    @Override
    public void start(Stage stage) throws IOException {
        this.cargarDependencias();

        DadoButton dadoButton = new DadoButton(algoRoma);
        dado.agregarObservador(dadoButton);

        AlgoRomaPantalla algoRomaPantalla = new AlgoRomaPantalla(algoRoma, dadoButton);
        Scene mapaVista = new Scene(algoRomaPantalla, ViewProperties.stageMaximoAlto, ViewProperties.stageMaximoAncho );

        AgregarJugadorPantalla agregarJugadorPantalla = new AgregarJugadorPantalla(stage, mapaVista, algoRoma );
        Scene escenaJugador = new Scene(agregarJugadorPantalla, ViewProperties.stageMaximoAlto, ViewProperties.stageMaximoAncho);

        BienvenidaPantalla bienvenidaPantalla = new BienvenidaPantalla(stage, escenaJugador);
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