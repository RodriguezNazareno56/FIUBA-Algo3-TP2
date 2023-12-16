package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.excepciones.JuegoEnCursoException;
import edu.fiuba.algo3.modelo.excepciones.MaximoGladiadoresException;
import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class UnirseButtonHandler implements EventHandler<ActionEvent> {

    private final TextField textField;
    private final GladiadorFactory gladiadorFactory;

    public UnirseButtonHandler(TextField textField, GladiadorFactory gladiadorFactory) {
        this.textField = textField;
        this.gladiadorFactory = gladiadorFactory;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombre = textField.getText().trim();
        try {
            gladiadorFactory.crearGladiador(nombre);
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
