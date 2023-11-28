package edu.fiuba.algo3.vista.components.boton;

import edu.fiuba.algo3.vista.EstadoJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ValidadorNombresProximaEscena implements EventHandler<ActionEvent> {

    private ArrayList<TextField> nombresJugadores;

    private Label labelError;

    private Scene scene;
    private Stage stage;
    private EstadoJuego estadoJuego;

    private final int MAXIMO_CANTIDAD_DE_DIGITOS = 10;

    public ValidadorNombresProximaEscena(Stage stage, Scene scene, ArrayList<TextField> nombresJugadores,
                                         Label labelError, EstadoJuego estadoJuego){
        this.stage = stage;
        this.scene = scene;
        this.estadoJuego = estadoJuego;

        this.nombresJugadores = nombresJugadores;
        this.labelError = labelError;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String[] nombres = new String[nombresJugadores.size()];
        int i = 0;
        for (TextField nombreJugador : nombresJugadores) {
            if ( !esNombreValido(nombreJugador.getText())) {
                this.labelError.setText(getMensajeDeError(nombreJugador.getText()));
                this.labelError.setTextFill(javafx.scene.paint.Color.RED);
                nombreJugador.requestFocus();
                return;
            }
            nombres[i] = nombreJugador.getText();
            i++;

        }
        this.estadoJuego.setNombresJugadores(nombres);
        stage.setScene(this.scene);
    }

    private boolean esNombreValido(String nombre) {
        // devolvere true si solo tiene letras y tiene menos de 10 digitos
        return tieneMenosDeXDigitos(nombre) && contieneLetras(nombre) && !estaEnBlanco(nombre);
    }

    private String getMensajeDeError(String nombre) {
        if (estaEnBlanco(nombre)) {
            return "No ingresaste un nombre";
        }
        if (!contieneLetras(nombre)) {
            return "El nombre solo puede tener letras";
        }
        if (!tieneMenosDeXDigitos(nombre)) {
            return "El nombre no puede tener mas de 10 digitos";
        }
        return "Error en nombre";
    }
    private boolean estaEnBlanco(String nombre) {
        return nombre.trim().equals("");
    }
    private boolean contieneLetras(String nombre) {
        // devolvere true si solo tiene letras y tiene menos de 10 digitos
        return nombre.matches("[a-zA-Z]+");
    }

    private boolean tieneMenosDeXDigitos(String nombre) {
        return nombre.length() < MAXIMO_CANTIDAD_DE_DIGITOS;
    }

}
