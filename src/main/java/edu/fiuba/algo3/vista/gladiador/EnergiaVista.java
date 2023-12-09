package edu.fiuba.algo3.vista.gladiador;

import edu.fiuba.algo3.controladores.observers.ObservadorEnergia;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EnergiaVista extends VBox implements ObservadorEnergia {

    private Label valorEnergiaLabel;

    // TODO: Capas otra fuente quede mejor, no logro sacar la separacion vertical entre energia y el valor
    public EnergiaVista(Energia energia, int valorInicial) {
        energia.agregarObservador(this);

        //String  fontDhurjatiPath = "file:src/main/resources/edu/fiuba/algo3/vista/fonts/Dhurjati-Regular.ttf";
        // titulo
        Label tituloLabel = new Label("Energia");

        tituloLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,12));
        //tituloLabel.setFont(Font.loadFont(fontDhurjatiPath, 20));
        tituloLabel.setTextFill(Color.BLUE);

        // valor
        valorEnergiaLabel = new Label(String.valueOf(valorInicial));
        //valorEnergiaLabel.setFont(Font.loadFont(fontDhurjatiPath, 50));
        valorEnergiaLabel.setFont(Font.font("Helvetica", FontWeight.BOLD,24));
        valorEnergiaLabel.setTextFill(Color.BLUE);


        getChildren().addAll(tituloLabel, valorEnergiaLabel);

        this.setAlignment(Pos.CENTER);
    }

    @Override
    public void actualizar(int valorEnergia) {
        this.valorEnergiaLabel.setText(String.valueOf(valorEnergia));
    }
}
