package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.dado.DadoButton;
import edu.fiuba.algo3.vista.equipamientos.EquipamientosPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RUNNER_PARA_VISUALIZAR_AVANCES extends Application {
    @Override
    public void start(Stage stage) {
        StackPane layout = new StackPane();

        EquipamientosPanel panelEquipamientos = new EquipamientosPanel();
        layout.getChildren().add(panelEquipamientos);

        DadoButton dadoButton = new DadoButton();
        layout.getChildren().add(dadoButton);

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