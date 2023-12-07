package edu.fiuba.algo3.vista.pantalla_elegir_gladiador.componentes;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

public class TextoAccionaBotonEventHandler implements EventHandler<KeyEvent> {
    private Button botonEnviar;

    public TextoAccionaBotonEventHandler(Button botonEnviar) {
        super();
        this.botonEnviar = botonEnviar;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode().toString().equals("ENTER")) {
            botonEnviar.fire();
        }
    }
}
