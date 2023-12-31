package edu.fiuba.algo3.vista.components.boton;

import edu.fiuba.algo3.vista.utilidades.ViewProperties;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonProximaEscenaEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene proximaEscena;

    public BotonProximaEscenaEventHandler(Stage stage, Scene proximaEscena){
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(this.proximaEscena);
        stage.setWidth(ViewProperties.stageMaximoAlto);
        stage.setHeight(ViewProperties.stageMaximoAncho);
        stage.centerOnScreen();
    }
}
