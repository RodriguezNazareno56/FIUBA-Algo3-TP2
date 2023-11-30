package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Arena extends BorderPane {

    Stage stage;
    public Arena(Stage stage){

        this.stage = stage;

        double altoImagenPerfil = 70 ;
        double anchoImagenPerfil = 70;
        double cantidadFilasMapa = 20;
        double cantidadColumnasMapa = 10;
        double cantidadjJugadores = 6;


        //Rutas de imagenes para perfiles
        ArrayList rutasImagenesPerfiles = new ArrayList<String>();
        rutasImagenesPerfiles.add("File:src/main/java/edu/fiuba/algo3/vista/Perfil_1.png");
        rutasImagenesPerfiles.add("File:src/main/java/edu/fiuba/algo3/vista/Perfil_2.png");
        rutasImagenesPerfiles.add("File:src/main/java/edu/fiuba/algo3/vista/Perfil_3.png");
        rutasImagenesPerfiles.add("File:src/main/java/edu/fiuba/algo3/vista/Perfil_4.png");
        rutasImagenesPerfiles.add("File:src/main/java/edu/fiuba/algo3/vista/Perfil_5.png");
        rutasImagenesPerfiles.add("File:src/main/java/edu/fiuba/algo3/vista/Perfil_6.png");

        //Nombres de los perfiles
        ArrayList nombresPerfiles = new ArrayList<String>();
        nombresPerfiles.add("PLAYER1");
        nombresPerfiles.add("PLAYER2");
        nombresPerfiles.add("PLAYER3");
        nombresPerfiles.add("PLAYER4");
        nombresPerfiles.add("PLAYER5");
        nombresPerfiles.add("PLAYER6");


        // COLUMNA : Contenedor para los perfiles de los Jugadores
        VBox columnaJugadoresIzquierda = new VBox();
        HBox panelInferior = new HBox();


        for( int i=0 ; i < cantidadjJugadores ; i++){

            Image imagen = new Image(String.valueOf(rutasImagenesPerfiles.get(i)));
            ImageView imagenPerfil = new ImageView(imagen);
            imagenPerfil.setFitHeight(altoImagenPerfil);
            imagenPerfil.setFitWidth(anchoImagenPerfil);

            columnaJugadoresIzquierda.getChildren().add(imagenPerfil);

            Label nombrePerfil = new Label();
            nombrePerfil.setText(nombresPerfiles.get(i).toString());
            nombrePerfil.setTextFill(Color.WHITE);

            columnaJugadoresIzquierda.getChildren().add(nombrePerfil);


        }

        columnaJugadoresIzquierda.setSpacing(8);
        columnaJugadoresIzquierda.setPadding(new Insets(8));
        columnaJugadoresIzquierda.setStyle("-fx-background-color:#323232");
        columnaJugadoresIzquierda.setAlignment(Pos.CENTER);



        // CREACION DEL MAPA ARENA

        GridPane mapaArena = new GridPane();
        mapaArena.setAlignment(Pos.CENTER);
        mapaArena.setGridLinesVisible(false);
        mapaArena.setHgap(5);
        mapaArena.setVgap(5);

        for( int i = 0 ; i < cantidadFilasMapa ; i++ ){
            for( int j = 0 ; j < cantidadColumnasMapa ; j ++ ){

                mapaArena.add(new Rectangle(40 , 40, Color.CHOCOLATE) , i , j  );

            }
        }

        //CREACION DEL PANEL DE CONTROL

        //Cuadro de Energia
        VBox cuadroEnergia = new VBox();

        Label tituloEnergia = new Label();
        tituloEnergia.setText("ENERGIA");
        tituloEnergia.setFont(Font.font("Tahoma", FontWeight.BOLD, 14 ));
        tituloEnergia.setTextFill(Color.WHITE);

        Label cantidadEnergia = new Label();
        cantidadEnergia.setText("20");
        cantidadEnergia.setFont(Font.font("Tahoma", FontWeight.BOLD, 18 ));
        cantidadEnergia.setTextFill(Color.WHITE);

        cuadroEnergia.getChildren().addAll(tituloEnergia, cantidadEnergia);
        cuadroEnergia.setAlignment(Pos.CENTER);

        //Cuadro EQUIPAMIENTO

        VBox cuadroEquipamiento = new VBox();

        Label tituloEquipamiento = new Label();
        tituloEquipamiento.setText("EQUIPAMIENTO");
        tituloEquipamiento.setFont(Font.font("Tahoma", FontWeight.BOLD, 14 ));
        tituloEquipamiento.setTextFill(Color.WHITE);

        Label tipoEquipamiento = new Label();
        tipoEquipamiento.setText("CASCO");
        tipoEquipamiento.setFont(Font.font("Tahoma", FontWeight.BOLD, 14 ));
        tipoEquipamiento.setTextFill(Color.WHITE);

        cuadroEquipamiento.getChildren().addAll(tituloEquipamiento, tipoEquipamiento);
        cuadroEquipamiento.setAlignment(Pos.CENTER);



        panelInferior.getChildren().addAll(cuadroEnergia, cuadroEquipamiento);
        panelInferior.setSpacing(15);
        panelInferior.setPadding(new Insets(8));
        panelInferior.setStyle("-fx-background-color:#323232");
        panelInferior.setAlignment(Pos.CENTER);

        this.setCenter(mapaArena);
        this.setMargin(mapaArena, new Insets( 10,10,10,10 ));
        this.setLeft(columnaJugadoresIzquierda);
        this.setMargin(columnaJugadoresIzquierda, new Insets( 10,10,10,10 ));
        this.setBottom(panelInferior);
        this.setMargin(panelInferior, new Insets( 10,10,10,10 ));


        BorderPane.setAlignment(mapaArena, Pos.TOP_CENTER);




    }



}
