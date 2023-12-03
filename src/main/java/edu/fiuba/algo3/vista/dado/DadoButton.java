package edu.fiuba.algo3.vista.dado;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;

public class DadoButton extends Button {

    public DadoButton() {
        this.setStyle("-fx-background-color:transparent ; " +
                "-fx-background-radius:0; " +
                "-fx-border-color:transparent; " +
                "-fx-border-width: 0 3 3 0;" +
                "-fx-opacity: 1;");
        URL url = this.getClass().getResource("dado_0.png");
        ImageView dadoImageView = new ImageView(url.toExternalForm());
        this.setGraphic(dadoImageView);

        DadoHandler dadoHandler = new DadoHandler(this);
        this.setOnAction(dadoHandler);
    }
}
