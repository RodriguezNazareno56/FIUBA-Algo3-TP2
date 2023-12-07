package edu.fiuba.algo3.vista.gladiador;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GladiadorVista extends VBox {
    public enum Color {
        DORADO,
        GRIS,
        MARRON;
    }

    private String colorString;

    public GladiadorVista(String nombreGladiador, Color color) {
        switch (color) {
            case GRIS:
                this.colorString = "gris";
                break;
            case MARRON:
                this.colorString = "marron";
                break;
            case DORADO:
                this.colorString = "dorado";
                break;
        }

        String url = "file:src/main/resources/edu/fiuba/algo3/vista/gladiador/"+ colorString + "/GreekBasic.png";
        Image gladiadorImage = new Image(url);
        ImageView imageView = new ImageView(gladiadorImage);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);

        Label nombreLabel = new Label();
        nombreLabel.setText(nombreGladiador);
        nombreLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        nombreLabel.setTextFill(javafx.scene.paint.Color.WHITE);

        this.getChildren().add(imageView);
        this.getChildren().add(nombreLabel);
    }


}
