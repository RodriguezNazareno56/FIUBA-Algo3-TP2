package edu.fiuba.algo3.vista.menuBarra.controladoresBarra;

import edu.fiuba.algo3.vista.InstruccionesVista;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.concurrent.ConcurrentNavigableMap;

public class mostrarInstruccionesEventHandler implements EventHandler {

    private Stage stage;

    public mostrarInstruccionesEventHandler(Stage stage){

        this.stage = stage;

    }
    @Override
    public void handle(Event event) {

        Popup ventanaInstrucciones = new Popup();


        Button botonSalir = new Button("X");
        botonSalir.setStyle("-fx-background-color: #804000; -fx-text-fill: white; -fx-font-size: 14px;-fx-background-radius: 5;");
        botonSalir.setOnAction(new BotonSalirPopUpEventHandler(ventanaInstrucciones));

        BorderPane contenedorVentanaInstrucciones = new BorderPane();

        contenedorVentanaInstrucciones.setCenter(new InstruccionesVista());
        contenedorVentanaInstrucciones.setBottom(botonSalir);
        BorderPane.setAlignment(botonSalir, Pos.CENTER);

        ventanaInstrucciones.getContent().add(contenedorVentanaInstrucciones);
        ventanaInstrucciones.show(stage);

    }
}
