package edu.fiuba.algo3.vista.elegirGladiador.componentes;

import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class BotonAgregarGladiadorEventHandler implements EventHandler<ActionEvent> {
    private TextField textFieldNombreGladiador;

    private AlgoRoma algoRoma;
    public BotonAgregarGladiadorEventHandler(AlgoRoma algoRoma, TextField textFieldNombreGladiador) {
        super();
        this.algoRoma = algoRoma;
        this.textFieldNombreGladiador = textFieldNombreGladiador;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            algoRoma.agregarGladiador(textFieldNombreGladiador.getText());
            textFieldNombreGladiador.setText("");
            textFieldNombreGladiador.requestFocus();
        } catch (FinDelJuegoException e) {
            throw new RuntimeException(e);
        } catch (MaximoGladiadoresException e) {
            throw new RuntimeException(e);
        } catch (NombreInvalidoException e) {
            throw new RuntimeException(e);
        } catch (JuegoEnCursoException e) {
            throw new RuntimeException(e);
        }
    }
}
