package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.menuBarra.MenuBarra;
import edu.fiuba.algo3.vista.components.boton.BotonProximaEscenaEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BienvenidaPantalla extends BorderPane {

    private Stage stage;

    public BienvenidaPantalla(Stage stage, Scene proximaEscena, AudioClip sonidoFondo){
        super();

        this.stage = stage;

        MenuBarra menuBarra = new MenuBarra(stage , sonidoFondo);
        this.setTop(menuBarra);


        //Contenido principal de la pantalla

        VBox contenedorPrincipal = new VBox();

        Image imagen = new Image("file:src/main/resources/edu/fiuba/algo3/vista/backgroundBienvenidaPantalla.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorPrincipal.setBackground(new Background(imagenDeFondo));

        contenedorPrincipal.setAlignment(Pos.CENTER_LEFT);
        contenedorPrincipal.setPadding(new Insets(20));
        contenedorPrincipal.setMaxHeight(Double.MAX_VALUE);
        contenedorPrincipal.setMaxWidth(Double.MAX_VALUE);

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

        contenedorPrincipal.getChildren().addAll(hboxLabel, hboxButton);
        this.setCenter(contenedorPrincipal);


    }



}
