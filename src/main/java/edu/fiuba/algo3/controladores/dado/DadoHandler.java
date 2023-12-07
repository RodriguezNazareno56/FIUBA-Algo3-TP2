package edu.fiuba.algo3.controladores.dado;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.vista.components.animacion.Animacion;
import edu.fiuba.algo3.vista.dado.AnimacionDado;
import edu.fiuba.algo3.vista.dado.DadoButton;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class DadoHandler implements EventHandler<ActionEvent> {

    private DadoButton dado;
    private Animacion animacion;
    private AlgoRoma algoRoma; // TODO: creo que deberia llegar por el constructor

    // TODO: eliminar
    public DadoHandler(DadoButton dado) {
        super();
        this.dado = dado;
        this.animacion = new AnimacionDado();
    }

    public DadoHandler(DadoButton dado, AlgoRoma algoRoma) {
        super();
        this.dado = dado;
        this.animacion = new AnimacionDado();
        this.algoRoma = algoRoma;
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
                    try {
                        algoRoma.jugarTurno();
                    } catch (Exception ignored) {
                        // TODO: no se si lo correcto es siempre ignorar. Por ejemplo al finalizar el juego deberia
                        //  impedir seguir tirando el dado. Para esto es necesario que jugarTurno devuelva las exepciones
                        //  especificas y no un simple Exception. De igual modo el fin de la partida puede se tratado de
                        //  otro modo.
                    }
                    dado.setDisable(false); // Reactiva el botón después de la animación
                })
        );
        timeline.play();
    }
}