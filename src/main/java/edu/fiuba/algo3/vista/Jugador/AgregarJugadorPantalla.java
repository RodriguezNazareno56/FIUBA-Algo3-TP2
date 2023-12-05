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

public class AgregarJugadorPantalla extends VBox {

    public AgregarJugadorPantalla(Stage stage, Scene proximaEscena, AlgoRoma algoRoma) {
        super(30);

        // Style
        this.setAlignment(Pos.TOP_CENTER);
        this.setPadding(new Insets(20));
        Image imagen = new Image("file:src/main/resources/edu/fiuba/algo3/vista/backgroundAgregarJugadorPantalla.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(
                imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Label etiquetaJuego = new Label();
        etiquetaJuego.setFont(Font.font("Helvetica", FontWeight.BOLD, 42));
        etiquetaJuego.setText("ALIAS DEL GLADIADOR");
        etiquetaJuego.setTextFill(Color.web("#FFFFFF"));


        TextField textField = new TextField();
        textField.setMaxWidth(240);


        UnirseButtonHandler unirseButtonHandler = new UnirseButtonHandler(textField, algoRoma);
        UnirseButton unirse = new UnirseButton(unirseButtonHandler);

        textField.setOnKeyPressed(new AgregarJugadorTextHandler(unirse));


        ComenzarPartidaButtonHandler comenzarPartidaButtonHandler = new ComenzarPartidaButtonHandler(stage, proximaEscena, algoRoma);
        ComenzarPartidaButton comenzarPartida = new ComenzarPartidaButton(comenzarPartidaButtonHandler);

        this.getChildren().addAll(etiquetaJuego, textField, unirse, comenzarPartida);
    }
}
