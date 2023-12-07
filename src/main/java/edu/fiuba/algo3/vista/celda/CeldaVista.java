package edu.fiuba.algo3.vista.celda;

import javafx.geometry.Orientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class CeldaVista extends FlowPane {

    public CeldaVista(double alto, double ancho){

        this.setOrientation(Orientation.VERTICAL);

        Image imagen = new Image("File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/TexturaCelda-100-100.png");
        ImageView imagenCelda = new ImageView(imagen);
        imagenCelda.setFitWidth(ancho);
        imagenCelda.setFitHeight(alto);

        this.setMaxHeight(alto);
        this.setMaxWidth(ancho);

        this.getChildren().add(imagenCelda);

    }
}
