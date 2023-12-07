package edu.fiuba.algo3.vista.elegirGladiador;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GladiadorElegidoVista extends VBox {

    private ImageView imageViewGladiador;

    private Label labelNombreGladiador;
    public GladiadorElegidoVista(String nombreGladiador, Image imagen) {
        super();

        this.imageViewGladiador = new ImageView(imagen);
        imageViewGladiador.setFitHeight(100);
        imageViewGladiador.setFitWidth(100);

        this.labelNombreGladiador = new Label(nombreGladiador);
        labelNombreGladiador.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        labelNombreGladiador.setTextFill(Color.DARKGREEN);

        this.getChildren().addAll(imageViewGladiador, labelNombreGladiador);

        this.setAlignment(javafx.geometry.Pos.CENTER);
        this.setSpacing(5);

    }
}
