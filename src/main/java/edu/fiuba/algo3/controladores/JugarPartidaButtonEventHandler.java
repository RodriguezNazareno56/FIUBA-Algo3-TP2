package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vista.AlgoRomaPantalla;
import edu.fiuba.algo3.vista.components.boton.BotonProximaEscenaEventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JugarPartidaButtonEventHandler extends BotonProximaEscenaEventHandler {

    private AlgoRomaPantalla algoRomaPantalla;
    public JugarPartidaButtonEventHandler(Stage stage, Scene proximaEscena, AlgoRomaPantalla algoRomaPantalla) {
        super(stage, proximaEscena);
        this.algoRomaPantalla = algoRomaPantalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        algoRomaPantalla.actualizarOrdenDeGladiadores();
    }
}
