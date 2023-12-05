package edu.fiuba.algo3.vista.Jugador.components;

import edu.fiuba.algo3.controladores.ComenzarPartidaButtonHandler;
import javafx.scene.control.Button;

public class ComenzarPartidaButton extends Button {

    public ComenzarPartidaButton(ComenzarPartidaButtonHandler comenzarPartidaButtonHandler) {
        this.setText("COMENZAR PARTIDA");
        this.setStyle("-fx-background-color: #006600; -fx-text-fill: white; -fx-font-size: 28px;-fx-background-radius: 10;");
        this.setOnAction(comenzarPartidaButtonHandler);
    }
}
