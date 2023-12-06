package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.vista.gladiador.EnergiaVista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RUNNER_PARA_VISUALIZAR_AVANCES extends Application {
    @Override
    public void start(Stage stage) {
        StackPane layout = new StackPane();

//        EquipamientosPanel panelEquipamientos = new EquipamientosPanel();
//        layout.getChildren().add(panelEquipamientos);
//
//        Gladiador gladiador = new Gladiador();
//        gladiador.setTranslateX(-150);
//        layout.getChildren().add(gladiador);
//
//        GladiadorAnimado gladiadorAnimado = new GladiadorAnimado();
//        gladiadorAnimado.setTranslateX(150);
//        layout.getChildren().add(gladiadorAnimado);

        Energia energia = new Energia(20);
        EnergiaVista energiaVista = new EnergiaVista(energia, 20);
        layout.getChildren().add(energiaVista);
        energia.aumentarEnergia(new Energia(22));

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