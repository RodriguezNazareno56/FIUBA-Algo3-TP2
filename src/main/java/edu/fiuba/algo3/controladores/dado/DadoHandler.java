package edu.fiuba.algo3.controladores.dado;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.AlgoRomaModelo;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.vista.ViewProperties;
import edu.fiuba.algo3.vista.VistaGanador;
import edu.fiuba.algo3.vista.components.animacion.Animacion;
import edu.fiuba.algo3.vista.dado.AnimacionDado;
import edu.fiuba.algo3.vista.dado.DadoButton;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DadoHandler implements EventHandler<ActionEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(DadoHandler.class);

    private DadoButton dado;
    private Animacion animacion;

    private Stage stage;


    private AlgoRomaModelo algoRoma; // TODO: creo que deberia llegar por el constructor

    public DadoHandler(DadoButton dado, AlgoRomaModelo algoRoma, Stage stage) {
        super();
        this.dado = dado;
        this.animacion = new AnimacionDado();
        this.algoRoma = algoRoma;
        this.stage = stage;
    }

    public void setAlgoRoma(AlgoRomaModelo algoRoma) {
        this.algoRoma = algoRoma;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        dado.setDisable(true);
        this.dado.setGraphic(animacion);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    // Aquí va la lógica después de la animación
                    try {
                        algoRoma.jugarTurno();

                    }catch (FinDelJuegoException finDelJuegoException){
                      this.cargarVistaGanador(finDelJuegoException.getMessage());
                    } catch (Exception ignored) {
                        //LOG.info("FIn del juego", ignored);
                        //this.mostrarAlertWarning();
                        // TODO: no se si lo correcto es siempre ignorar. Por ejemplo al finalizar el juego deberia
                        //  impedir seguir tirando el dado. Para esto es necesario que jugarTurno devuelva las exepciones
                        //  especificas y no un simple Exception. De igual modo el fin de la partida puede se tratado de
                        //  otro modo.
                    }
                    dado.setDisable(false);
                })
        );
        timeline.play();
    }

    private void cargarVistaGanador(String mensaje){
        Scene sceneGanador = new Scene(new VistaGanador(mensaje));
        this.stage.setScene(sceneGanador);
        stage.setWidth(ViewProperties.stageMaximoAlto);
        stage.setHeight(ViewProperties.stageMaximoAncho);
        stage.centerOnScreen();
        LOG.info("Ganadoooor!");
    }
}