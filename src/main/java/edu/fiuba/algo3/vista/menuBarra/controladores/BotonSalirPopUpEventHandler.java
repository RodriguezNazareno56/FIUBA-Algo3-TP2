package edu.fiuba.algo3.vista.menuBarra.controladores;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Popup;

public class BotonSalirPopUpEventHandler implements EventHandler {

    private Popup popUp;

    public BotonSalirPopUpEventHandler(Popup popUp){
        this.popUp = popUp;
    }

    @Override
    public void handle(Event event) {
        popUp.hide();
    }
}
