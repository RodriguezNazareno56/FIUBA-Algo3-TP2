package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.Bienvenida;
import edu.fiuba.algo3.vista.Configuracion;
import edu.fiuba.algo3.vista.ConfiguracionAvatares;
import edu.fiuba.algo3.vista.EstadoJuego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        EstadoJuego estadoJuego = new EstadoJuego();
        //la cantidad de jugadores lo debe establecer el usuario en configuracion
        estadoJuego.setCantidadJugadores(5);

        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        StackPane root = new StackPane();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);


        var configuracionAvatares = new Scene(new StackPane(new ConfiguracionAvatares(stage, scene, estadoJuego)), 640, 480);
        var config = new Scene(new StackPane(new Configuracion(stage, configuracionAvatares)), 640, 480);

        //var config = new Scene(new StackPane(new Configuracion(stage, scene)), 640, 480);
        root.getChildren().add(new Bienvenida(stage, config));

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