package edu.fiuba.algo3.vista.gladiador;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GladiadorVista extends StackPane {

    public enum Color {
        DORADO,
        GRIS,
        MARRON;
    }

    private String colorString;
    private ImageView imageView;

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

        //Imagen de fondo de la vista Gladiador
        ImageView imagenFondoVistaGLadiador = new ImageView("file:src/main/resources/edu/fiuba/algo3/vista/gladiador/GladiadorBoxBackground.png");
        imagenFondoVistaGLadiador.setFitWidth(110);
        imagenFondoVistaGLadiador.setFitHeight(110);
        this.getChildren().add(imagenFondoVistaGLadiador);

        //Representacion de Gladiador
        String url = "file:src/main/resources/edu/fiuba/algo3/vista/gladiador/"+ colorString + "/GreekBasic.png";
        Image gladiadorImage = new Image(url);
        //ImageView imageView = new ImageView(gladiadorImage);
        imageView = new ImageView(gladiadorImage);
        imageView.setFitHeight(65);
        imageView.setPreserveRatio(true);

        //Nombre de gladiador
        Label nombreLabel = new Label();
        nombreLabel.setText(nombreGladiador);
        nombreLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
        nombreLabel.setTextFill(javafx.scene.paint.Color.SADDLEBROWN);

        //Contenedor de representacion de gladidador + nombre
        VBox gladiadorVista = new VBox();
        gladiadorVista.getChildren().add(imageView);
        gladiadorVista.getChildren().add(nombreLabel);
        gladiadorVista.setSpacing(0);
        gladiadorVista.setAlignment(Pos.CENTER);

        this.getChildren().add(gladiadorVista);
        this.setAlignment(Pos.CENTER);
    }

    public void cambiarColor(String colorString) {
        String url = "file:src/main/resources/edu/fiuba/algo3/vista/gladiador/"+ colorString + "/GreekBasic.png";
        Image gladiadorImage = new Image(url);
        imageView.setImage(gladiadorImage);
    }

}
