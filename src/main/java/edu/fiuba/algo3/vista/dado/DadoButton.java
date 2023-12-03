package edu.fiuba.algo3.vista.dado;

import edu.fiuba.algo3.Controladores.dado.DadoHandler;
import edu.fiuba.algo3.Controladores.observers.ObservadorDado;
import edu.fiuba.algo3.modelo.AlgoRoma;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class DadoButton extends Button implements ObservadorDado {

    private final DadoHandler dadoHandler;

    public DadoButton() {
        this.setStyle("-fx-background-color:transparent ; " +
                "-fx-background-radius:0; " +
                "-fx-border-color:transparent; " +
                "-fx-border-width: 0 3 3 0;" +
                "-fx-opacity: 1;");
        URL url = this.getClass().getResource("dado_1.png");
        ImageView dadoImageView = new ImageView(url.toExternalForm());
        this.setGraphic(dadoImageView);

        dadoHandler = new DadoHandler(this);
        this.setOnAction(dadoHandler);
    }

    public void setAlgoRoma(AlgoRoma algoRoma) {
        this.dadoHandler.setAlgoRoma(algoRoma);
    }

    @Override
    public void actualizar(int valorDelDado) {
        Image imageResult = new Image("file:src/main/resources/edu/fiuba/algo3/vista/dado/dado_" + valorDelDado + ".png");
        ImageView dadoImageView = new ImageView(imageResult);
        this.setGraphic(dadoImageView);
    }
}
