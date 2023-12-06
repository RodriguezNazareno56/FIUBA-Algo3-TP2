package edu.fiuba.algo3.vista.mapa.components;

import edu.fiuba.algo3.controladores.observers.Observador;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
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
import java.util.HashMap;

public class Gladiadores extends VBox implements Observador {

    private AlgoRoma algoRoma;

    private HashMap<String, String> dirImagenesPorNombreGladiador;

    private ArrayList<String> nombresAgregados;

    private ArrayList imagenesPerfilGladiador;

    private double maxCantidadPerfiles = 6;

    private double altoImagenPerfil = 60 ;

    private double anchoImagenPerfil = 60;



    public Gladiadores(AlgoRoma algoRoma, HashMap<String, String> dirImagenesPorNombreGladiador){

        this.algoRoma = algoRoma;
        this.dirImagenesPorNombreGladiador = dirImagenesPorNombreGladiador;
        this.imagenesPerfilGladiador = new ArrayList<String>();
        this.nombresAgregados = new ArrayList<String>();

        //Inicializo vector de imagenes de los perfiles
        String srcImage = "File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/perfilesGladiadores/PerfilGladiador";

        for( int i = 1 ; i <= maxCantidadPerfiles ; i++ ){
            this.imagenesPerfilGladiador.add( srcImage + i + ".png" );
        }

    }


    @Override
    public void actualizar(){
        this.actualizarNuevoGladiadorConImagen();
/*
        double cantidadGladiadores = algoRoma.getGladiadores().size();

        for( int i = 0 ; i < cantidadGladiadores ; i++ ){

            Image imagen = new Image(String.valueOf(this.imagenesPerfilGladiador.get(i)));
            ImageView imagenPerfilGladiador = new ImageView(imagen);
            imagenPerfilGladiador.setFitHeight(altoImagenPerfil);
            imagenPerfilGladiador.setFitWidth(anchoImagenPerfil);

            Label nombreGladiador = new Label();
            nombreGladiador.setText(algoRoma.getGladiadores().get(i).getNombre());
            nombreGladiador.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
            nombreGladiador.setTextFill(Color.WHITE);

            this.getChildren().add(imagenPerfilGladiador);
            this.getChildren().add(nombreGladiador);


        }
*/

        this.setAlignment(Pos.CENTER);
        this.setSpacing(8);
        this.setPadding(new Insets(8));
        this.setStyle("-fx-background-color:#323232");

    }

    private void actualizarNuevoGladiadorConImagen(){
        ArrayList<Gladiador> gladiadores = algoRoma.getGladiadores();

        for( Gladiador gladiador : gladiadores ){
            String nombreGladiador = gladiador.getNombre();
            String dirImagen = this.dirImagenesPorNombreGladiador.get(nombreGladiador);
            if( dirImagen != null && !nombresAgregados.contains(nombreGladiador) ){
                nombresAgregados.add(nombreGladiador);

                Image imagen = new Image(dirImagen);
                ImageView imagenPerfilGladiador = new ImageView(imagen);
                imagenPerfilGladiador.setFitHeight(altoImagenPerfil);
                imagenPerfilGladiador.setFitWidth(anchoImagenPerfil);

                Label nombreGladiadorLabel = new Label();
                nombreGladiadorLabel.setText(nombreGladiador);
                nombreGladiadorLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
                nombreGladiadorLabel.setTextFill(Color.WHITE);

                this.getChildren().add(imagenPerfilGladiador);
                this.getChildren().add(nombreGladiadorLabel);
            }
        }
    }

}

