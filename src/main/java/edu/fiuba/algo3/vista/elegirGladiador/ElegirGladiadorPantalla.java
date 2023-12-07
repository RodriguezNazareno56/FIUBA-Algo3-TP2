package edu.fiuba.algo3.vista.elegirGladiador;

import edu.fiuba.algo3.controladores.ComenzarPartidaButtonHandler;
import edu.fiuba.algo3.controladores.observers.Observador;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class ElegirGladiadorPantalla extends VBox implements Observador {

    private HashMap<Image, String> imagenesGladiadores = new HashMap<>();

    private HashMap<String, String> dirImagenesPorNombreGladiador;

    private AlgoRoma algoRoma;

    private HBox gladiadoresElegidosHBox;

    private Button botonSiguienteEscena;

    private SelectorGladiador selectorGladiador;

    private final int ESPACIADO_GLADIADORES_ELEGIDOS = 60;

    private final int ESPACIADO_BLOQUES = 40;
    public ElegirGladiadorPantalla(Stage stage, Scene escenaSiguiente, AlgoRoma algoRoma, HashMap<String, String> dirImagenesPorNombreGladiador) {
        super();
        this.algoRoma = algoRoma;
        algoRoma.agregarObservador(this);
        this.dirImagenesPorNombreGladiador = dirImagenesPorNombreGladiador;

        this.gladiadoresElegidosHBox = new HBox();
        this.selectorGladiador = new SelectorGladiador(algoRoma, this.getImageGladiadores());

        this.getChildren().addAll(this.gladiadoresElegidosHBox, selectorGladiador);

        gladiadoresElegidosHBox.setAlignment(Pos.CENTER);
        gladiadoresElegidosHBox.setSpacing(ESPACIADO_GLADIADORES_ELEGIDOS);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(ESPACIADO_BLOQUES);

        botonSiguienteEscena = new Button("Jugar");
        botonSiguienteEscena.setOnAction(new ComenzarPartidaButtonHandler(stage, escenaSiguiente, algoRoma));
        botonSiguienteEscena.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 28px;-fx-background-radius: 10;");

        this.actualizarBotonSiguienteEscena();
        this.getChildren().add(botonSiguienteEscena);

        /*
        //poner otra imagen, esta imagen no contrasta bien con las fotos
        Image imagen = new Image("file:src/main/resources/edu/fiuba/algo3/vista/backgroundAgregarJugadorPantalla.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(
                imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

         */
    }

    @Override
    public void actualizar() {

        this.actualizarGladiadoresElegidos();

        this.actualizarBotonSiguienteEscena();
        this.actualizarBotonElegirNombreGladiador();
    }

    private void actualizarGladiadoresElegidos(){
        Image imagenElegida = this.selectorGladiador.getAndDeleteImagenPerfilGladiador();

        Gladiador gladiador = algoRoma.getGladiadores().get(algoRoma.getGladiadores().size() - 1);
        GladiadorElegidoVista gladiadorVista = new GladiadorElegidoVista(gladiador, imagenElegida);
        this.gladiadoresElegidosHBox.getChildren().add(gladiadorVista);
        gladiadoresElegidosHBox.setSpacing(60);


        String nombreGladiador = gladiador.getNombre();
        this.dirImagenesPorNombreGladiador.put(nombreGladiador, this.imagenesGladiadores.get(imagenElegida));
    }

    private void actualizarBotonSiguienteEscena(){
        if( algoRoma.getGladiadores().size() < algoRoma.getMinimaCantidadGladiadores()){
            botonSiguienteEscena.setDisable(true);
        }
        else{
            botonSiguienteEscena.setDisable(false);
        }
    }

    private void actualizarBotonElegirNombreGladiador(){
        if(algoRoma.getGladiadores().size() >= algoRoma.getMaximaCantidadGladiadores()){
            //selectorGladiador.setDesactivarBotonEnviarNombre(true);
            selectorGladiador.desactivarBotones(true);
        }
        else{
            //selectorGladiador.setDesactivarBotonEnviarNombre(false);
            selectorGladiador.desactivarBotones(false);

        }
    }

    public ArrayList<Image> getImageGladiadores() {
        ArrayList<Image> imagenes = new ArrayList<Image>();
        for (int i = 1; i <= 6; i++) {
            String direccionImagen = "File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/perfilesGladiadores/PerfilGladiador" + i + ".png";
            Image imagen = new Image(direccionImagen);
            imagenes.add(imagen);

            this.imagenesGladiadores.put(imagen, direccionImagen);
        }
        return imagenes;
    }
}
