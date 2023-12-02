package edu.fiuba.algo3.vista.Jugador;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.vista.components.boton.BotonProximaEscenaEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    public Jugador(Stage stage, Scene proximaEscena, AlgoRoma algoRoma) {
        super(30);
        this.stage = stage;

        this.setAlignment(Pos.TOP_CENTER);
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
        textField.setMaxWidth(240);
        Label resultadoLabel = new Label("Texto ingresado: ");
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            resultadoLabel.setText("Texto ingresado: " + newValue);
        });


        Label etiquetaJuego = new Label();
        etiquetaJuego.setFont(Font.font("Helvetica", FontWeight.BOLD, 42));
        etiquetaJuego.setText("ALIAS DEL GLADIADOR");
        etiquetaJuego.setTextFill(Color.web("#FFFFFF"));

        unirse.setOnAction(e->{
            var nombre = textField.getText().trim();
            if(nombre.length() <=3){
                this.alert();
                return;
            }
            if(algoRoma.cantidadDeGladiadores()>=6){
                unirse.setDisable(true);
            }
            else {
                algoRoma.agregarGladiador(nombre);
                textField.clear();

            }
        });



        BotonProximaEscenaEventHandler proximaEscenaEventHandler = new BotonProximaEscenaEventHandler(this.stage, proximaEscena);
        empezar.setOnAction(e -> {
            if(algoRoma.cantidadDeGladiadores()>=2 && algoRoma.cantidadDeGladiadores()<=6){
                algoRoma.notificarAObservadores();
                empezar.setOnAction(proximaEscenaEventHandler);
            }
        });

        this.getChildren().addAll(etiquetaJuego, textField, unirse,empezar);

    }

    private void alert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error de validación");
        alert.setHeaderText(null);
        alert.setContentText("EL nombre debe contener por lo menos cuatro caracteres");
        alert.showAndWait();
    }


}
