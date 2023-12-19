package edu.fiuba.algo3.controladores.dado;

import edu.fiuba.algo3.modelo.AlgoRomaModelo;
import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.vista.utilidades.ViewProperties;
import edu.fiuba.algo3.vista.GanadorVista;
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


    private AlgoRomaModelo algoRoma;

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
                    } catch (Exception ignored) {}
                    dado.setDisable(false);
                })
        );
        timeline.play();
    }

    private void cargarVistaGanador(String mensaje){
        Scene sceneGanador = new Scene(new GanadorVista(mensaje));
        this.stage.setScene(sceneGanador);
        stage.setWidth(ViewProperties.stageMaximoAlto);
        stage.setHeight(ViewProperties.stageMaximoAncho);
        stage.centerOnScreen();
        LOG.info("Ganadoooor!");
    }
}