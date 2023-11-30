package edu.fiuba.algo3.vista.Jugador;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.vista.components.boton.BotonProximaEscenaEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Jugador extends VBox {
    private Stage stage;
    private AlgoRoma algoRoma;

    public Jugador(Stage stage, Scene proximaEscena, AlgoRoma algoRoma) {
        super();
        this.stage = stage;
        this.algoRoma = algoRoma;

        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(20));
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenes/nuevaroma.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));


        Button unirse = new Button();
        unirse.setText("UNIRSE");
        unirse.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 28px;-fx-background-radius: 10;");

        Button empezar = new Button();
        empezar.setText("COMENZAR PARTIDA");
        empezar.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 28px;-fx-background-radius: 10;");


        TextField textField = new TextField();
        Label resultadoLabel = new Label("Texto ingresado: ");
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            resultadoLabel.setText("Texto ingresado: " + newValue);
        });


        Label etiquetaJuego = new Label();
        etiquetaJuego.setFont(Font.font("Helvetica", FontWeight.BOLD, 42));

        etiquetaJuego.setText("UNIRSE A LA PARTIDA");
        etiquetaJuego.setTextFill(Color.web("#FFFFFF"));
        for(int i=0;i<5;i++){
            unirse.setOnAction(e->{
                var nombre = textField.getText().trim();
                algoRoma.agregarGladiador(nombre);
                textField.clear();
            });
        }

        BotonProximaEscenaEventHandler proximaEscenaEventHandler = new BotonProximaEscenaEventHandler(this.stage, proximaEscena);
        empezar.setOnAction(proximaEscenaEventHandler);

        this.getChildren().addAll(etiquetaJuego, textField, unirse,empezar);

    }
}
