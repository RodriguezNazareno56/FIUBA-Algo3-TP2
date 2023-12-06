package edu.fiuba.algo3.vista.elegirGladiador.componentes;

import edu.fiuba.algo3.modelo.AlgoRoma;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarSiguienteEscenaEventHandler implements EventHandler<ActionEvent> {
    private AlgoRoma algoRoma;

    private Stage stage;

    private Scene escenaSiguiente;


    public BotonJugarSiguienteEscenaEventHandler(Stage stage, Scene siguienteEscena, AlgoRoma algoRoma) {
        super();
        this.algoRoma = algoRoma;
        this.stage = stage;
        this.escenaSiguiente = siguienteEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        algoRoma.notificarAObservadores();
        stage.setScene(this.escenaSiguiente);
        stage.setWidth(1350);
        stage.setHeight(700);

    }
}
