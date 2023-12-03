package edu.fiuba.algo3.vista.mapa.components;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class CaminoVista extends GridPane {

    public CaminoVista(AlgoRoma algoRoma){


        Image imagen = new Image("File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/TexturaCesped-100-100.png");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));



        this.setAlignment(Pos.CENTER);
        this.setGridLinesVisible(false);
        this.setHgap(5); //Separacion horizontal entre celdas
        this.setVgap(5); //Separacion vertical entre celdas




        algoRoma.getMapa()
                .getCamino()
                .getCeldas()
                .forEach(celda -> this.add(new CeldaVista(50, 50 ), celda.getCoordenada().getX(), celda.getCoordenada().getY()));

/*
        FlowPane celdaPrueba = new FlowPane(Orientation.VERTICAL);
        this.setMaxHeight(60);
        this.setMaxHeight(60);

        Circle circuloRojo = new Circle(10, Color.RED);

        celdaPrueba.getChildren().add(circuloRojo);
        celdaPrueba.getChildren().add(new Circle( 10, Color.BLUE));
        celdaPrueba.getChildren().add(new Circle( 10, Color.YELLOW));
        celdaPrueba.getChildren().add(new Circle( 10, Color.CYAN));
        celdaPrueba.getChildren().add(new Circle( 10, Color.WHITE));
        celdaPrueba.getChildren().add(new Circle( 10, Color.BLACK));

        celdaPrueba.getChildren().remove(circuloRojo);


        this.add( celdaPrueba, 7 , 1 );
*/

    }
}