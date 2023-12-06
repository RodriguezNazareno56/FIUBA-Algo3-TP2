package edu.fiuba.algo3.vista.gladiador;

import edu.fiuba.algo3.controladores.observers.ObservadorEnergia;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class EnergiaVista extends VBox implements ObservadorEnergia {

    private Label valorEnergiaLabel;

    // TODO: Capas otra fuente quede mejor, no logro sacar la separacion vertical entre energia y el valor
    public EnergiaVista(Energia energia, int valorInicial) {
        energia.agregarObservador(this);

        String  fontDhurjatiPath = "file:src/main/resources/edu/fiuba/algo3/vista/fonts/Dhurjati-Regular.ttf";
        // titulo
        Label tituloLabel = new Label("Energia:");
        tituloLabel.setFont(Font.loadFont(fontDhurjatiPath, 20));
        tituloLabel.setTextFill(Color.BLUE);

        // valor
        valorEnergiaLabel = new Label(String.valueOf(valorInicial));
        valorEnergiaLabel.setFont(Font.loadFont(fontDhurjatiPath, 50));
        valorEnergiaLabel.setTextFill(Color.BLUE);

        getChildren().addAll(tituloLabel, valorEnergiaLabel);
    }

    @Override
    public void actualizar(int valorEnergia) {
        this.valorEnergiaLabel.setText(String.valueOf(valorEnergia));
    }
}
