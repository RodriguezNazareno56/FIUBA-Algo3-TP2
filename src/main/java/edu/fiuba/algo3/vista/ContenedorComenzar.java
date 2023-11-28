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

public class ContenedorComenzar extends VBox {

    Stage stage;

    public ContenedorComenzar(Stage stage, Scene proximaExcena){

        super();
        this.stage  = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Image imagenComenzar = new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenComenzarGladiador.jpg");
        BackgroundImage imagenDeFondoComenzar = new BackgroundImage(imagenComenzar,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondoComenzar));

        Button botonComenzar = new Button();
        botonComenzar.setText("Comenzar");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18 ));

        etiqueta.setText("Presiona en comenzar");
        etiqueta.setTextFill(Color.web("#66A7C5"));

        BotonComenzarEventHandler botonComenzarEventHandler = new BotonComenzarEventHandler(stage, proximaExcena);
        botonComenzar.setOnAction(botonComenzarEventHandler);

        this.getChildren().addAll(etiqueta, botonComenzar);





    }



}
