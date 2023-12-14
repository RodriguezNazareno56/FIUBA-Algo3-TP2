package edu.fiuba.algo3.vista.menuBarra.controladoresBarra;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class PantallaCompletaEventHandler implements EventHandler {

    private Stage stage;
    public PantallaCompletaEventHandler(Stage stage){
        this.stage = stage;
    }
    @Override
    public void handle(Event event) {
        stage.setFullScreen(!stage.isFullScreen());
    }
}
