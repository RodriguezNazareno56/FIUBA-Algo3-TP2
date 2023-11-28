package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Arena extends BorderPane {

    Stage stage;
    public Arena(Stage stage){

        this.stage = stage;

        VBox columnaJugadores = new VBox();

        Image imagen1 = new Image("File:src/main/java/edu/fiuba/algo3/vista/Perfil_1.png");
        ImageView imagenPerfil1 = new ImageView(imagen1);

        Image imagen2 = new Image("File:src/main/java/edu/fiuba/algo3/vista/Perfil_2.png");
        ImageView imagenPerfil2 = new ImageView(imagen2);

        Image imagen3 = new Image("File:src/main/java/edu/fiuba/algo3/vista/Perfil_3.png");
        ImageView imagenPerfil3 = new ImageView(imagen3);

        Image imagen4 = new Image("File:src/main/java/edu/fiuba/algo3/vista/Perfil_4.png");
        ImageView imagenPerfil4 = new ImageView(imagen4);


        columnaJugadores.getChildren().addAll(imagenPerfil1, imagenPerfil2, imagenPerfil3, imagenPerfil4);
        columnaJugadores.setSpacing(8);
        columnaJugadores.setPadding(new Insets(30));

        this.setLeft(columnaJugadores);



    }



}
