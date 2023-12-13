package edu.fiuba.algo3.vista.menuBarra.controladoresBarra;

import javafx.event.Event;
import javafx.event.EventHandler;

public class CerrarAppEventHandler implements EventHandler {
    @Override
    public void handle(Event event) {
        System.exit(0);
    }
}
