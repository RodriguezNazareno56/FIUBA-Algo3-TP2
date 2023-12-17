package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.AlgoRomaModelo;
import edu.fiuba.algo3.vista.components.boton.BotonProximaEscenaEventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComenzarPartidaButtonHandler extends BotonProximaEscenaEventHandler {

    private AlgoRomaModelo algoRoma;

    public ComenzarPartidaButtonHandler(Stage stage, Scene proximaEscena, AlgoRomaModelo algoRoma) {
        super(stage, proximaEscena);
        this.algoRoma = algoRoma;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // TODO: esta validacion debe realizarla el modelo
        if(algoRoma.getCantidadDeGladiadores()>=2 && algoRoma.getCantidadDeGladiadores()<=6){
            super.handle(actionEvent);
        }
    }
}
