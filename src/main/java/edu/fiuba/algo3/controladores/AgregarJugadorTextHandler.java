package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vista.Jugador.UnirseButton;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class AgregarJugadorTextHandler implements EventHandler<KeyEvent> {

    private UnirseButton unirseButton;

    public AgregarJugadorTextHandler(UnirseButton unirseButton) {
        this.unirseButton = unirseButton;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Event.fireEvent(unirseButton, new ActionEvent());
        }
    }
}
