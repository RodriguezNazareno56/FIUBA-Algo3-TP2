package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.components.boton.BotonProximaEscenaEventHandler;
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

public class BienvenidaPantalla extends VBox {

    private Stage stage;

    public BienvenidaPantalla(Stage stage, Scene proximaEscena){
        super(30);
        this.stage = stage;

        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(20));
        Image imagen = new Image("file:src/main/resources/edu/fiuba/algo3/vista/backgroundBienvenidaPantalla.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));


        Button empezar = new Button();
        empezar.setText("EMPEZAR");
        empezar.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 28px;-fx-background-radius: 10;");


        Label etiquetaJuego = new Label();
        etiquetaJuego.setFont(Font.font("Helvetica", FontWeight.BOLD,42));

        etiquetaJuego.setText("BIENVENIDOS \nA BATALLA DE GLADIADORES");
        etiquetaJuego.setTextFill(Color.web("#FFFFFF"));

        BotonProximaEscenaEventHandler proximaEscenaEventHandler = new BotonProximaEscenaEventHandler(this.stage, proximaEscena);
        empezar.setOnAction(proximaEscenaEventHandler);

        HBox hboxLabel = new HBox(10);
        hboxLabel.getChildren().addAll(etiquetaJuego);

        HBox hboxButton = new HBox(10);
        hboxButton.getChildren().add(empezar);

        this.getChildren().addAll(hboxLabel, hboxButton);
    }



}
