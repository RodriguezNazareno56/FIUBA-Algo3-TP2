package edu.fiuba.algo3.vista.Jugador.components;

import edu.fiuba.algo3.controladores.UnirseButtonHandler;
import javafx.scene.control.Button;

public class UnirseButton extends Button {

    public UnirseButton(UnirseButtonHandler unirseButtonHandler) {
        this.setText("UNIRSE");
        this.setStyle("-fx-background-color: #006600;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 28px;" +
                "-fx-background-radius: 10;");
        this.setOnAction(unirseButtonHandler);
    }
}
