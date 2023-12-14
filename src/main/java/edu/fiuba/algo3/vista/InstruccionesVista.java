package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class InstruccionesVista extends BorderPane {

    public InstruccionesVista(){

        super();

        ImageView imagenFondo = new ImageView("File:src/main/resources/edu/fiuba/algo3/vista/instrucciones/Instruciones.png");
        imagenFondo.setFitWidth(854);
        imagenFondo.setFitHeight(480);

        this.setCenter(imagenFondo);
        BorderPane.setAlignment(imagenFondo, Pos.CENTER);

    }



}
