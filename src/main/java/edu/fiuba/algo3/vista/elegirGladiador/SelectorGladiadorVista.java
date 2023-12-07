package edu.fiuba.algo3.vista.elegirGladiador;

import edu.fiuba.algo3.controladores.GladiadorFactory;
import edu.fiuba.algo3.controladores.UnirseButtonHandler;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.vista.elegirGladiador.componentes.SiguienteImagenButtonEventHandler;
import edu.fiuba.algo3.vista.elegirGladiador.componentes.TextoAccionaBotonEventHandler;
import edu.fiuba.algo3.vista.mapa.AlgoRomaPantalla;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SelectorGladiadorVista extends HBox {

    private AlgoRoma algoRoma;

    private AlgoRomaPantalla algoRomaPantalla;

    private ImageView imageViewGladiador;

    private ArrayList<Image> imagenes;

    private Button buttonEnviarNombre;

    private final int DIMENSION_IMAGEN = 130;

    public SelectorGladiadorVista(AlgoRoma algoRoma, AlgoRomaPantalla romaPantalla, ArrayList<Image> imagenes, AlgoRomaPantalla algoRomaPantalla) {
        super();
        this.algoRoma = algoRoma;
        this.algoRomaPantalla = algoRomaPantalla;
        this.imagenes = imagenes;;
        this.imageViewGladiador = new ImageView(imagenes.get(0));


        VBox contenedorGladiadorElegible = this.crearGladiadorElegible();

        Button botonSiguiente = new Button(">");
        botonSiguiente.setOnAction(new SiguienteImagenButtonEventHandler(imagenes, true, imageViewGladiador));
        botonSiguiente.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 18px;-fx-background-radius: 10;");

        Button botonAnterior = new Button("<");
        botonAnterior.setOnAction(new SiguienteImagenButtonEventHandler(imagenes, false, imageViewGladiador));
        botonAnterior.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 18px;-fx-background-radius: 10;");

        this.getChildren().addAll(botonAnterior, contenedorGladiadorElegible, botonSiguiente);

        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);

    }


    private VBox crearGladiadorElegible() {
        VBox vBox = new VBox();

        imageViewGladiador.setFitHeight(DIMENSION_IMAGEN);
        imageViewGladiador.setFitWidth(DIMENSION_IMAGEN);

        TextField textFieldNombreParaGladiador = new TextField("");
        this.buttonEnviarNombre = new Button("Unirse");

        GladiadorFactory gladiadorFactory = new GladiadorFactory(algoRoma, algoRomaPantalla);
        UnirseButtonHandler unirseButtonHandler = new UnirseButtonHandler(textFieldNombreParaGladiador, gladiadorFactory);
        buttonEnviarNombre.setOnAction(unirseButtonHandler);

        //buttonEnviarNombre.setOnAction(new AgregarGladiadorButtonEventHandler( textFieldNombreParaGladiador,algoRoma));
        buttonEnviarNombre.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 22px;-fx-background-radius: 10;");
        textFieldNombreParaGladiador.setOnKeyPressed(new TextoAccionaBotonEventHandler(buttonEnviarNombre));



        vBox.getChildren().addAll(imageViewGladiador, textFieldNombreParaGladiador, buttonEnviarNombre);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        return vBox;
    }

    public Image getImagenPerfilGladiador() {
        return imageViewGladiador.getImage();
    }

    public Image getAndDeleteImagenPerfilGladiador() {
        //refactor
        if(imagenes.isEmpty()) {
            imageViewGladiador.setImage(null);
            return null;
        }

        Image imagen = imageViewGladiador.getImage();
        this.imagenes.remove(imagen);

        if(imagenes.isEmpty()){
            imageViewGladiador.setImage(null);
        }
        else{
            imageViewGladiador.setImage(imagenes.get(0));
        }


        return imagen;
    }


    public void desactivarBotones(boolean disable){
        for (Node node : this.getChildren()) {
            node.setDisable(disable);
        }
    }
}
