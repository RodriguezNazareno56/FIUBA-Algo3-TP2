package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaGanador extends VBox {

    public VistaGanador(String mensajeGanador){
        super();

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        Label etiquetaJuego = new Label();
        etiquetaJuego.setFont(Font.font("Helvetica", FontWeight.BOLD,42));

        etiquetaJuego.setText("FELICITACIONES \nGANASTE LA PARTIDA");
        etiquetaJuego.setTextFill(Color.web("#FFFFFF"));

        String url = "file:src/main/resources/edu/fiuba/algo3/vista/gladiador/marron/GreekBasic.png";
        Image gladiadorImage = new Image(url);
        ImageView imageView = new ImageView(gladiadorImage);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        Label mensaje = new Label();
        mensaje.setFont(Font.font("Helvetica", FontWeight.BOLD,24));

        mensaje.setText(mensajeGanador);
        mensaje.setTextFill(Color.web("#FFFFFF"));

        this.setPadding(new Insets(20));
        Image imagen = new Image("File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/TexturaCesped-100-100.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        this.getChildren().addAll(etiquetaJuego,imageView,mensaje);
    }
}
