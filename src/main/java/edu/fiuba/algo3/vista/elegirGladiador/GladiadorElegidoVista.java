package edu.fiuba.algo3.vista.elegirGladiador;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GladiadorElegidoVista extends VBox {
    private Gladiador gladiador;

    private ImageView imageViewGladiador;

    private Label nombreGladiador;
    public GladiadorElegidoVista(Gladiador gladiador, Image imagen) {
        super();

        this.gladiador = gladiador;

        this.imageViewGladiador = new ImageView(imagen);
        imageViewGladiador.setFitHeight(100);
        imageViewGladiador.setFitWidth(100);

        this.nombreGladiador = new Label(gladiador.getNombre());
        nombreGladiador.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        nombreGladiador.setTextFill(Color.DARKGREEN);

        this.getChildren().addAll(imageViewGladiador, nombreGladiador);

        this.setAlignment(javafx.geometry.Pos.CENTER);
        this.setSpacing(5);

    }


}
