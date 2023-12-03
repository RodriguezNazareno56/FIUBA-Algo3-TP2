package edu.fiuba.algo3.controladores.dado;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.vista.Animacion;
import edu.fiuba.algo3.vista.dado.AnimacionDado;
import edu.fiuba.algo3.vista.dado.DadoButton;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class DadoHandler implements EventHandler<ActionEvent> {

    private DadoButton dado;
    private Animacion animacion;
    private AlgoRoma algoRoma; // TODO: creo que deberia llegar por el constructor

    public DadoHandler(DadoButton dado) {
        super();
        this.dado = dado;
        this.animacion = new AnimacionDado();
    }

    public void setAlgoRoma(AlgoRoma algoRoma) {
        this.algoRoma = algoRoma;
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
                    if (algoRoma != null) {
                        try {
                            algoRoma.jugarTurno();
                        } catch (Exception ignored) {}
                    } else {
                        obtenerValorDelDado(); // TODO: eliminar
                    }
                    dado.setDisable(false); // Reactiva el botón después de la animación
                })
        );
        timeline.play();
    }

    private void obtenerValorDelDado() {
        Image imageResult = new Image("file:src/main/resources/edu/fiuba/algo3/vista/dado/dado_1.png");
        ImageView dadoImageView = new ImageView(imageResult);
        this.dado.setGraphic(dadoImageView);
    }
}