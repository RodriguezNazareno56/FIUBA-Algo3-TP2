package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.SystemInfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Aplicacion extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Gladiadores en Fuga");

        IniciarJugadores iniciarJugadores = new IniciarJugadores(stage);
        Scene escenaIniciarJugadores = new Scene(iniciarJugadores, 640, 480);



        ContenedorComenzar contenedorComenzar = new ContenedorComenzar(stage, escenaIniciarJugadores);
        Scene escenaComenzar = new Scene(contenedorComenzar, 640, 480);



        var label = new Label("Bienvenidos");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(escenaComenzar);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}