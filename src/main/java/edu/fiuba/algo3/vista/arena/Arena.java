package edu.fiuba.algo3.vista.arena;

import edu.fiuba.algo3.modelo.AlgoRoma;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Arena extends BorderPane {

    public Arena(AlgoRoma algoRoma){
        super();


        double altoImagenPerfil = 60 ;
        double anchoImagenPerfil = 60;
        double cantidadFilasMapa = 20;
        double cantidadColumnasMapa = 10;

        double cantidadGladiadores = algoRoma.getGladiadores().size();

        ToolBar toolBar = new ToolBar();
        this.setBottom(toolBar);


        ArrayList imgPerfilGladiador = new ArrayList<String>();
        imgPerfilGladiador.add("File:src/main/java/edu/fiuba/algo3/vista/imagenes/PerfilGladiador1.png");
        imgPerfilGladiador.add("File:src/main/java/edu/fiuba/algo3/vista/imagenes/PerfilGladiador2.png");
        imgPerfilGladiador.add("File:src/main/java/edu/fiuba/algo3/vista/imagenes/PerfilGladiador3.png");
        imgPerfilGladiador.add("File:src/main/java/edu/fiuba/algo3/vista/imagenes/PerfilGladiador4.png");
        imgPerfilGladiador.add("File:src/main/java/edu/fiuba/algo3/vista/imagenes/PerfilGladiador5.png");
        imgPerfilGladiador.add("File:src/main/java/edu/fiuba/algo3/vista/imagenes/PerfilGladiador6.png");


        VBox contenedorPerfilGladiadores = new VBox();
        HBox panelInferior = new HBox();




        for( int i = 0 ; i < cantidadGladiadores ; i++ ){

            Image imagen = new Image(String.valueOf(imgPerfilGladiador.get(i)));
            ImageView imagenPerfilGladiador = new ImageView(imagen);
            imagenPerfilGladiador.setFitHeight(altoImagenPerfil);
            imagenPerfilGladiador.setFitWidth(anchoImagenPerfil);

            Label nombreGladiador = new Label();
            nombreGladiador.setText("Gladiador");
            nombreGladiador.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
            nombreGladiador.setTextFill(Color.WHITE);

            contenedorPerfilGladiadores.getChildren().add(imagenPerfilGladiador);
            contenedorPerfilGladiadores.getChildren().add(nombreGladiador);
            contenedorPerfilGladiadores.setAlignment(Pos.CENTER);

        }

        contenedorPerfilGladiadores.setSpacing(8);
        contenedorPerfilGladiadores.setPadding(new Insets(8));
        contenedorPerfilGladiadores.setStyle("-fx-background-color:#323232");




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
        this.setLeft(contenedorPerfilGladiadores);
        this.setMargin(contenedorPerfilGladiadores, new Insets( 10,10,10,10 ));
        this.setBottom(panelInferior);
        this.setMargin(panelInferior, new Insets( 10,10,10,10 ));


        BorderPane.setAlignment(mapaArena, Pos.TOP_CENTER);
    }

}