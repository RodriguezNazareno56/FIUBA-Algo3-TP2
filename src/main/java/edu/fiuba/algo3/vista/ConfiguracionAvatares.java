package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.components.boton.TextoNombreGladiadorEventHandler;
import edu.fiuba.algo3.vista.components.boton.ValidadorNombresProximaEscena;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.ArrayList;

public class ConfiguracionAvatares extends VBox {
    private Stage stage;

    public ConfiguracionAvatares( Stage stage,Scene scene, EstadoJuego estadoJuego) {
        super();
        this.stage = stage;
        int cantidadJugadores = estadoJuego.getCantidadJugadores();

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));

        ArrayList<TextField> textoNombresJugadores = new ArrayList<>();

        //creo los contenedores de cada jugador
        for (int i = 0; i < cantidadJugadores; i++) {
            TextField textoNombreJugador = new TextField();
            Label labelErrorNombre = new Label("Gladiador" + (i+1));

            HBox contenedorJugador = new HBox(textoNombreJugador, labelErrorNombre);
            contenedorJugador.setPadding(new Insets(20));
            contenedorJugador.setSpacing(10);

            textoNombreJugador.setOnKeyPressed(new TextoNombreGladiadorEventHandler(labelErrorNombre, textoNombreJugador));

            textoNombresJugadores.add(textoNombreJugador);
            this.getChildren().add(contenedorJugador);
        }

        Label labelErrorEnviar = new Label("");
        Button botonEnviar = new Button("Iniciar Juego");
        botonEnviar.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 28px;-fx-background-radius: 10;");

        VBox contenedorBoton = new VBox(labelErrorEnviar, botonEnviar);

        //reducir parametros
        ValidadorNombresProximaEscena validadorHandler = new ValidadorNombresProximaEscena(stage, scene, textoNombresJugadores,
                labelErrorEnviar, estadoJuego);
        botonEnviar.setOnAction(validadorHandler);


        this.getChildren().add(contenedorBoton);

        //pruebasImagenes


    }


}
