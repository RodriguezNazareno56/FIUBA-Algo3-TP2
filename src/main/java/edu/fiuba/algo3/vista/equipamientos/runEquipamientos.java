package edu.fiuba.algo3.vista.equipamientos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class runEquipamientos extends Application {
    @Override
    public void start(Stage stage) {
        StackPane layout = new StackPane();

        EquipamientosPanel panelEquipamientos = new EquipamientosPanel();
        layout.getChildren().add(panelEquipamientos);

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