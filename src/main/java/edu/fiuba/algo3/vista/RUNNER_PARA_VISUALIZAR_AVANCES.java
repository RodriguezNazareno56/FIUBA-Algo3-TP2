package edu.fiuba.algo3.vista;

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
import edu.fiuba.algo3.data_acceso.repositories.MapaRepository;
import edu.fiuba.algo3.data_acceso.repositories.MapaRepositoryImpl;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.vista.dado.DadoButton;
import edu.fiuba.algo3.vista.equipamientos.EquipamientosPanel;
import edu.fiuba.algo3.vista.gladiador.Gladiador;
import edu.fiuba.algo3.vista.gladiador.GladiadorAnimado;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RUNNER_PARA_VISUALIZAR_AVANCES extends Application {
    @Override
    public void start(Stage stage) {
        StackPane layout = new StackPane();

        EquipamientosPanel panelEquipamientos = new EquipamientosPanel();
        layout.getChildren().add(panelEquipamientos);

        DadoButton dadoButton = new DadoButton();
        layout.getChildren().add(dadoButton);

        Gladiador gladiador = new Gladiador();
        gladiador.setTranslateX(-150);
        layout.getChildren().add(gladiador);

        GladiadorAnimado gladiadorAnimado = new GladiadorAnimado();
        gladiadorAnimado.setTranslateX(150);
        layout.getChildren().add(gladiadorAnimado);

        Scene scene = new Scene(layout, 600, 600);

        // Configurar el escenario principal
        stage.setTitle("Gladiador App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}