package edu.fiuba.algo3.vista.pantalla_elegir_gladiador.componentes;

import edu.fiuba.algo3.controladores.ComenzarPartidaButtonHandler;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.AlgoRomaModelo;
import edu.fiuba.algo3.vista.AlgoRomaPantalla;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JugarPartidaButtonEventHandler extends ComenzarPartidaButtonHandler {

    private AlgoRomaPantalla algoRomaPantalla;
    public JugarPartidaButtonEventHandler(Stage stage, Scene proximaEscena, AlgoRomaModelo algoRoma, AlgoRomaPantalla algoRomaPantalla) {
        super(stage, proximaEscena, algoRoma);
        this.algoRomaPantalla = algoRomaPantalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        super.handle(actionEvent);
        algoRomaPantalla.actualizarOrdenDeGladiadores();
    }
}
