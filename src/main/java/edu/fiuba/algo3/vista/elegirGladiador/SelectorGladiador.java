package edu.fiuba.algo3.vista.elegirGladiador;

import edu.fiuba.algo3.controladores.UnirseButtonHandler;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.vista.elegirGladiador.componentes.BotonSiguienteImagenEventHandler;
import edu.fiuba.algo3.vista.elegirGladiador.componentes.TextoAccionaBotonEventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SelectorGladiador extends HBox {

    private AlgoRoma algoRoma;

    private ImageView imagenPerfilGladiador;

    private ArrayList<Image> imagenes;

    private Button buttonEnviarNombre;

    private final int DIMENSION_IMAGEN = 130;

    public SelectorGladiador(AlgoRoma algoRoma, ArrayList<Image> imagenes) {
        super();
        this.algoRoma = algoRoma;
        this.imagenes = imagenes;;
        this.imagenPerfilGladiador = new ImageView(imagenes.get(0));


        VBox contenedorGladiador = this.crearImagenTextoGladiador();

        Button botonSiguiente = new Button(">");
        botonSiguiente.setOnAction(new BotonSiguienteImagenEventHandler(imagenes, true, imagenPerfilGladiador));
        botonSiguiente.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 18px;-fx-background-radius: 10;");

        Button botonAnterior = new Button("<");
        botonAnterior.setOnAction(new BotonSiguienteImagenEventHandler(imagenes, false, imagenPerfilGladiador));
        botonAnterior.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 18px;-fx-background-radius: 10;");

        this.getChildren().addAll(botonAnterior, contenedorGladiador, botonSiguiente);

        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);

    }


    public VBox crearImagenTextoGladiador() {
        VBox vBox = new VBox();

        imagenPerfilGladiador.setFitHeight(DIMENSION_IMAGEN);
        imagenPerfilGladiador.setFitWidth(DIMENSION_IMAGEN);

        TextField textFieldEscribirNombre = new TextField("");
        this.buttonEnviarNombre = new Button("Seleccionar");


        buttonEnviarNombre.setOnAction(new UnirseButtonHandler( textFieldEscribirNombre,algoRoma));
        textFieldEscribirNombre.setOnKeyPressed(new TextoAccionaBotonEventHandler(buttonEnviarNombre));

        buttonEnviarNombre.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 22px;-fx-background-radius: 10;");

        vBox.getChildren().addAll(imagenPerfilGladiador, textFieldEscribirNombre, buttonEnviarNombre);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        return vBox;
    }

    public Image getImagenPerfilGladiador() {
        return imagenPerfilGladiador.getImage();
    }

    public Image getAndDeleteImagenPerfilGladiador() {
        //refactor
        if(imagenes.isEmpty()) {
            imagenPerfilGladiador.setImage(null);
            return null;
        }

        Image imagen = imagenPerfilGladiador.getImage();
        this.imagenes.remove(imagen);

        if(imagenes.isEmpty()){
            imagenPerfilGladiador.setImage(null);
        }
        else{
            imagenPerfilGladiador.setImage(imagenes.get(0));
        }


        return imagen;
    }


    public void desactivarBotones(boolean disable){
        for (Node node : this.getChildren()) {
            node.setDisable(disable);
        }
    }
}
