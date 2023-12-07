package edu.fiuba.algo3.vista.mapa.components;

import edu.fiuba.algo3.controladores.observers.ObservadorSenority;
import edu.fiuba.algo3.modelo.AlgoRoma;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

// TODO: renombrar a panelGladiadores
public class Gladiadores extends VBox {

    private AlgoRoma algoRoma;

    private ArrayList imagenesPerfilGladiador;

    private double maxCantidadPerfiles = 6;

    private double altoImagenPerfil = 60 ;

    private double anchoImagenPerfil = 60;



    public Gladiadores(AlgoRoma algoRoma){

        this.algoRoma = algoRoma;
        this.imagenesPerfilGladiador = new ArrayList<String>();

        //Inicializo vector de imagenes de los perfiles
        String srcImage = "File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/perfilesGladiadores/PerfilGladiador";

        for( int i = 1 ; i <= maxCantidadPerfiles ; i++ ){
            this.imagenesPerfilGladiador.add( srcImage + i + ".png" );
        }

    }

    public void agregarGladiador(){

        int cantidadGladiadores = algoRoma.getGladiadores().size();


        Image imagen = new Image(String.valueOf(this.imagenesPerfilGladiador.get(cantidadGladiadores - 1)));
        ImageView imagenPerfilGladiador = new ImageView(imagen);
        imagenPerfilGladiador.setFitHeight(altoImagenPerfil);
        imagenPerfilGladiador.setFitWidth(anchoImagenPerfil);

        Label nombreGladiador = new Label();
        nombreGladiador.setText(algoRoma.getGladiadores().get(cantidadGladiadores - 1).getNombre());
        nombreGladiador.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        nombreGladiador.setTextFill(Color.WHITE);

        this.getChildren().add(imagenPerfilGladiador);
        this.getChildren().add(nombreGladiador);



        this.setAlignment(Pos.CENTER);
        this.setSpacing(8);
        this.setPadding(new Insets(8));
        this.setStyle("-fx-background-color:#323232");

    }
}

