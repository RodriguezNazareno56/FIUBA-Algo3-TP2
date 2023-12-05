package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class UnirseButtonHandler implements EventHandler<ActionEvent> {

    private TextField textField;
    private AlgoRoma algoRoma;

    public UnirseButtonHandler(TextField textField, AlgoRoma algoRoma) {
        this.textField = textField;
        this.algoRoma = algoRoma;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombre = textField.getText().trim();
        try {
            algoRoma.agregarGladiador(nombre);
        } catch (NombreInvalidoException | JuegoEnCursoException | MaximoGladiadoresException | FinDelJuegoException e) {
            this.alert(e.getMessage());
        }
        textField.clear();
        textField.requestFocus();
    }

    private void alert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
