package edu.fiuba.algo3.vista.mapa.componentes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class CeldaVista extends StackPane {

    public CeldaVista(double alto, double ancho){

        Image imagen = new Image("File:src/main/java/edu/fiuba/algo3/vista/imagenes/TexturaCamino-100-100.png");
        ImageView imagenCelda = new ImageView(imagen);
        imagenCelda.setFitWidth(ancho);
        imagenCelda.setFitHeight(alto);

        this.setMaxHeight(alto);
        this.setMaxWidth(ancho);
        this.getChildren().add(imagenCelda);

    }



}
