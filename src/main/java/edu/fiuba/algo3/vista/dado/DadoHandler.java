package edu.fiuba.algo3.vista.dado;

import edu.fiuba.algo3.vista.Animacion;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class DadoHandler implements EventHandler<ActionEvent> {

    private DadoButton dado;
    private Animacion animacion;

    public DadoHandler(DadoButton dado) {
        super();
        this.dado = dado;
        this.animacion = new Animacion(this.getAnimacionImages());
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        dado.setDisable(true); // Desactiva el botón mientras se ejecuta la animación
        this.dado.setGraphic(animacion);
        // Configura la animación
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    // Aquí va la lógica después de la animación
                    // TODO: algoRoma.jugarTurno()
                    obtenerValorDelDado(); // TODO: se podria consultar
                    dado.setDisable(false); // Reactiva el botón después de la animación
                })
        );
        timeline.play();
    }

    private void obtenerValorDelDado() {
        Random random = new Random();
        int valorDelDado = random.nextInt(6);
        URL url = this.getClass().getResource("dado_" + valorDelDado + ".png");
        ImageView dadoImageView = new ImageView(url.toExternalForm());
        this.dado.setGraphic(dadoImageView);
    }

    // Animacion
    protected Queue<Image> getAnimacionImages() {
        Queue<Image> imageQueue = new ArrayDeque<>();
        for (int i = 0; i < 6; i++) {
            URL url = this.getClass().getResource("dado_" + i + ".png");
            imageQueue.add(new Image(url.toExternalForm()));
        }
        return imageQueue;
    }
}