package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.components.boton.BotonProximaEscenaNombresGladiadoresEventHandler;
import edu.fiuba.algo3.vista.components.boton.TextoNombreGladiadorEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.ArrayList;

public class ConfiguracionAvatares extends VBox {
    private Stage stage;
    private int cantidadJugadores;

    private Scene scene;
    public ConfiguracionAvatares( Stage stage,Scene scene, int cantidadJugadores) {
        super();
        this.scene = scene;
        this.stage = stage;
        this.cantidadJugadores = cantidadJugadores;

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));

        ArrayList<TextField> nombresJugadores = new ArrayList<TextField>();
        ArrayList<Label> etiquetasJugadores = new ArrayList<Label>();
        ArrayList<HBox> contenedoresJugadores = new ArrayList<HBox>();
        for (int i = 0; i < cantidadJugadores; i++) {
            TextField nombreJugador = new TextField();
            Label etiquetaJugador = new Label("Gladiador" + (i+1));
            HBox contenedorJugador = new HBox(nombreJugador, etiquetaJugador);
            contenedorJugador.setPadding(new Insets(20));
            contenedorJugador.setSpacing(10);

            nombreJugador.setOnKeyPressed(new TextoNombreGladiadorEventHandler(etiquetaJugador, nombreJugador));
            nombresJugadores.add(nombreJugador);
            etiquetasJugadores.add(etiquetaJugador);
            this.getChildren().add(contenedorJugador);
        }

        Label errorEnNombres = new Label("");
        Button botonEnviar = new Button("Iniciar Juego");
        VBox contenedorBoton = new VBox(errorEnNombres, botonEnviar);

        BotonProximaEscenaNombresGladiadoresEventHandler botonEnviarEventHandler = new BotonProximaEscenaNombresGladiadoresEventHandler(stage, scene, nombresJugadores, errorEnNombres);
        botonEnviar.setOnAction(botonEnviarEventHandler);

        botonEnviar.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 28px;-fx-background-radius: 10;");

        this.getChildren().add(contenedorBoton);




    }


}
