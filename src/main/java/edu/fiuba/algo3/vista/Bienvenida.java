package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.components.boton.BotonProximaEscenaEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Bienvenida extends VBox {

    private Stage stage;

    public Bienvenida(Stage stage, Scene proximaEscena){
        super();
        this.stage = stage;

        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(20));
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenes/nuevaroma.png");
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

        this.getChildren().addAll(etiquetaJuego, empezar);
    }



}
