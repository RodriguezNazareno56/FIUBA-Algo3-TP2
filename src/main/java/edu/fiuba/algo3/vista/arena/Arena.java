package edu.fiuba.algo3.vista.arena;

import edu.fiuba.algo3.modelo.AlgoRoma;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Arena extends BorderPane {

    public Arena(AlgoRoma algoRoma){
        super();


        double altoImagenPerfil = 70 ;
        double anchoImagenPerfil = 70;
        double cantidadFilasMapa = 20;
        double cantidadColumnasMapa = 10;

        ToolBar toolBar = new ToolBar();
        this.setBottom(toolBar);


        // COLUMNA : Perfiles de Jugadores
        VBox columnaJugadoresIzquierda = new VBox();
        HBox panelInferior = new HBox();
        Image imagen1 = new Image("File:src/main/java/edu/fiuba/algo3/vista/imagenes/Perfil_1.png");
        ImageView imagenPerfil1 = new ImageView(imagen1);
        imagenPerfil1.setFitHeight(altoImagenPerfil);
        imagenPerfil1.setFitWidth(anchoImagenPerfil);

        Image imagen2 = new Image("File:src/main/java/edu/fiuba/algo3/vista/imagenes/Perfil_2.png");
        ImageView imagenPerfil2 = new ImageView(imagen2);
        imagenPerfil2.setFitHeight(altoImagenPerfil);
        imagenPerfil2.setFitWidth(anchoImagenPerfil);

        Image imagen3 = new Image("File:src/main/java/edu/fiuba/algo3/vista/imagenes/Perfil_3.png");
        ImageView imagenPerfil3 = new ImageView(imagen3);
        imagenPerfil3.setFitHeight(altoImagenPerfil);
        imagenPerfil3.setFitWidth(anchoImagenPerfil);

        Image imagen4 = new Image("File:src/main/java/edu/fiuba/algo3/vista/imagenes/Perfil_4.png");
        ImageView imagenPerfil4 = new ImageView(imagen4);
        imagenPerfil4.setFitHeight(altoImagenPerfil);
        imagenPerfil4.setFitWidth(anchoImagenPerfil);

        Image imagen5 = new Image("File:src/main/java/edu/fiuba/algo3/vista/imagenes/Perfil_5.png");
        ImageView imagenPerfil5 = new ImageView(imagen5);
        imagenPerfil5.setFitHeight(altoImagenPerfil);
        imagenPerfil5.setFitWidth(anchoImagenPerfil);

        Image imagen6 = new Image("File:src/main/java/edu/fiuba/algo3/vista/imagenes/Perfil_6.png");
        ImageView imagenPerfil6 = new ImageView(imagen6);
        imagenPerfil6.setFitHeight(altoImagenPerfil);
        imagenPerfil6.setFitWidth(anchoImagenPerfil);



        columnaJugadoresIzquierda.getChildren().addAll(imagenPerfil1, imagenPerfil2, imagenPerfil3, imagenPerfil4, imagenPerfil5, imagenPerfil6);


        columnaJugadoresIzquierda.setSpacing(8);
        columnaJugadoresIzquierda.setPadding(new Insets(8));
        columnaJugadoresIzquierda.setStyle("-fx-background-color:#323232");

        // CREACION DEL MAPA ARENA

        GridPane mapaArena = new GridPane();
        mapaArena.setAlignment(Pos.CENTER);
        mapaArena.setGridLinesVisible(false);
        mapaArena.setHgap(5);
        mapaArena.setVgap(5);

        algoRoma.getMapa()
                .getCamino()
                .getCeldas()
                .forEach(celda -> mapaArena.add(new Rectangle(40 , 40, Color.CHOCOLATE) , celda.getCoordenada().getX() , celda.getCoordenada().getY() ));


        for( int i = 0 ; i < 19 ; i++ ){
            panelInferior.getChildren().add(new Rectangle(60,60, Color.DARKGRAY));
        }

        panelInferior.setSpacing(8);
        panelInferior.setPadding(new Insets(8));
        panelInferior.setStyle("-fx-background-color:#323232");


        this.setCenter(mapaArena);
        this.setMargin(mapaArena, new Insets( 10,10,10,10 ));
        this.setLeft(columnaJugadoresIzquierda);
        this.setMargin(columnaJugadoresIzquierda, new Insets( 10,10,10,10 ));
        this.setBottom(panelInferior);
        this.setMargin(panelInferior, new Insets( 10,10,10,10 ));


        BorderPane.setAlignment(mapaArena, Pos.TOP_CENTER);
    }

}