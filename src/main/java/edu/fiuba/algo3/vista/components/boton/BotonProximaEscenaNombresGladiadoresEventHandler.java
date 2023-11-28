package edu.fiuba.algo3.vista.components.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonProximaEscenaNombresGladiadoresEventHandler implements EventHandler<ActionEvent> {

    private ArrayList<TextField> nombresJugadores;

    private Label errorEnNombres;

    private Scene scene;
    private Stage stage;

    public BotonProximaEscenaNombresGladiadoresEventHandler(Stage stage, Scene scene, ArrayList<TextField> nombresJugadores, Label errorEnNombres) {
        this.nombresJugadores = nombresJugadores;
        this.errorEnNombres = errorEnNombres;
        this.scene = scene;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        for (TextField nombreJugador : nombresJugadores) {
            if (nombreJugador.getText().trim().equals("")) {
                this.errorEnNombres.setText("No ingresaste nada");
                this.errorEnNombres.setTextFill(javafx.scene.paint.Color.RED);
                nombreJugador.requestFocus();
                return;
            }
            if (!esNombreValido(nombreJugador.getText())) {
                this.errorEnNombres.setText("El nombre no es valido");
                this.errorEnNombres.setTextFill(javafx.scene.paint.Color.RED);
                nombreJugador.requestFocus();
                return;
            }

            if (!tieneMenosDe10Digitos(nombreJugador.getText())) {
                this.errorEnNombres.setText("El nombre no puede tener mas de 10 digitos");
                this.errorEnNombres.setTextFill(javafx.scene.paint.Color.RED);
                nombreJugador.requestFocus();
                return;
            }


        }
        this.errorEnNombres.setTextFill(javafx.scene.paint.Color.GREEN);
        this.errorEnNombres.setText("Iniciando...");

        stage.setScene(this.scene);
    }

    private boolean esNombreValido(String nombre) {
        // devolvere true si solo tiene letras y tiene menos de 10 digitos
        return nombre.matches("[a-zA-Z]+");
    }

    private boolean tieneMenosDe10Digitos(String nombre) {
        return nombre.length() < 10;
    }


}
