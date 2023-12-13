package edu.fiuba.algo3.vista.paneles_de_visualizacion.componentes;

import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ComidaInfo extends VBox implements PantallaInfo {
    private Label etiquetaJuego;

    public ComidaInfo(){
        super();

        this.setAlignment(Pos.BOTTOM_CENTER);
        this.setPadding(new Insets(20));
        this.etiquetaJuego = new Label();
        etiquetaJuego.setFont(Font.font("Helvetica", FontWeight.BOLD,42));
        etiquetaJuego.setTextFill(Color.web("#FFFFFF"));
        aplicarEfectosDeContornoTexto(etiquetaJuego);

        //String url = "file:src/main/resources/edu/fiuba/algo3/vista/gladiador/marron/GreekBasic.png";
        //Image comidaImage = new Image(url);
        //ImageView imageView = new ImageView(comidaImage);
        //imageView.setFitHeight(200);
        //imageView.setPreserveRatio(true);

        Label mensaje = new Label();
        mensaje.setFont(Font.font("Helvetica", FontWeight.BOLD,24));

        //mensaje.setText(mensajeGanador);
        mensaje.setText("toca para continuar");
        mensaje.setTextFill(Color.web("#FFFFFF"));
        aplicarEfectosDeContornoTexto(mensaje);


        this.setPadding(new Insets(20));
        Image imagen = new Image("File:src/main/resources/edu/fiuba/algo3/vista/imagenesConsecuencia/comida.png");

        Background background = new Background(new BackgroundFill(new ImagePattern(imagen), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY));
        this.setBackground(background);

        //StackPane labels = new StackPane();
        //labels.setAlignment(etiquetaJuego, Pos.BOTTOM_CENTER);
        //labels.setAlignment(mensaje, Pos.BOTTOM_CENTER);
        //labels.getChildren().addAll(etiquetaJuego, mensaje);
        //this.getChildren().addAll(labels);
        this.getChildren().addAll(etiquetaJuego, mensaje);
    }

    public VBox getPantallaConInfoDe(Gladiador gladiador, IConsecuencia consecuencia) {
        etiquetaJuego.setText("\n"+gladiador + " encontró comida\n Su energía subió 15 puntos!");
        return this;
    }

    private void aplicarEfectosDeContornoTexto(Label texto) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(2.0);
        dropShadow.setOffsetY(2.0);
        dropShadow.setColor(Color.BLACK); // Color del contorno
        texto.setEffect(dropShadow);
    }
}
