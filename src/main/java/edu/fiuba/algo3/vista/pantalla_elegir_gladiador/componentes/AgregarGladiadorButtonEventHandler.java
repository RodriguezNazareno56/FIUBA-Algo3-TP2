package edu.fiuba.algo3.vista.pantalla_elegir_gladiador.componentes;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.excepciones.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.excepciones.MaximoGladiadoresException;
import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AgregarGladiadorButtonEventHandler implements EventHandler<ActionEvent> {

    private TextField textField;

    private AlgoRoma algoRoma;

    public AgregarGladiadorButtonEventHandler(TextField textField, AlgoRoma algoRoma) {
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