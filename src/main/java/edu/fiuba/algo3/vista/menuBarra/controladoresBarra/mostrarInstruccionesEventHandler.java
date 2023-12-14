package edu.fiuba.algo3.vista.menuBarra.controladoresBarra;

import edu.fiuba.algo3.vista.InstruccionesVista;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class mostrarInstruccionesEventHandler implements EventHandler {

    private Stage stage;

    public mostrarInstruccionesEventHandler(Stage stage){

        this.stage = stage;

    }
    @Override
    public void handle(Event event) {
        Popup ventanaInstrucciones = new Popup();
        ventanaInstrucciones.getContent().add(new InstruccionesVista());
        ventanaInstrucciones.show(stage);
    }
}
