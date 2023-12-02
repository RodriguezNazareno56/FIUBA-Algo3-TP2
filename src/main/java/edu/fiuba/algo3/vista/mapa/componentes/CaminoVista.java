package edu.fiuba.algo3.vista.mapa.componentes;

import edu.fiuba.algo3.modelo.AlgoRoma;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CaminoVista extends GridPane {

    public CaminoVista(AlgoRoma algoRoma){


        Image imagen = new Image("File:src/main/java/edu/fiuba/algo3/vista/imagenes/TexturaCesped-100-100.png");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));


        this.setAlignment(Pos.CENTER);
        this.setGridLinesVisible(false);
        this.setHgap(5); //Separacion horizontal entre celdas
        this.setVgap(5); //Separacion vertical entre celdas


        algoRoma.getMapa()
                .getCamino()
                .getCeldas()
                .forEach(celda -> this.add(new Rectangle(40, 40, Color.CHOCOLATE), celda.getCoordenada().getX(), celda.getCoordenada().getY()));


    }


}
