package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class IniciarJugadores extends VBox {

    Stage stage;

    public IniciarJugadores(Stage stage){

        super();

        this.stage  = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));


        Arena arena = new Arena(stage);
        Scene escenaArena = new Scene(arena, 640, 480);

        Image imagenComenzar = new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenIniciarJugadores.jpg");

        BackgroundSize backgroundSize = new BackgroundSize(
                100, 100, true, true, true, false);

        BackgroundImage imagenDeFondoComenzar = new BackgroundImage(imagenComenzar,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);
        this.setBackground(new Background(imagenDeFondoComenzar));


        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18 ));

        etiqueta.setText("Iniciar Jugadores");
        etiqueta.setTextFill(Color.web("#66A7C5"));

        Button botonVolver = new Button();
        botonVolver.setText("ARENA");

        BotonVolverEventHandler botonVolverEventHandler = new BotonVolverEventHandler(stage, escenaArena);
        botonVolver.setOnAction(botonVolverEventHandler);


        this.getChildren().addAll(etiqueta, botonVolver);





    }



}
