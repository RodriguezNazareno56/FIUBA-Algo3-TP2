package edu.fiuba.algo3.vista.gladiador;

import edu.fiuba.algo3.controladores.observers.ObservadorEnergia;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EnergiaVista extends StackPane implements ObservadorEnergia {

    private Label valorEnergiaLabel;

    public EnergiaVista(Energia energia, int valorInicial) {

        energia.agregarObservador(this);

        ImageView imagenFondoEnergia = new ImageView("file:src/main/resources/edu/fiuba/algo3/vista/energia/EnergiaBoxBackGround.png");
        imagenFondoEnergia.setFitHeight(110);
        imagenFondoEnergia.setFitWidth(110);
        this.getChildren().add(imagenFondoEnergia);

        // valor
        valorEnergiaLabel = new Label(String.valueOf(valorInicial));
        valorEnergiaLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 28));
        valorEnergiaLabel.setTextFill(Color.SADDLEBROWN);

        this.getChildren().add(valorEnergiaLabel);

        this.setAlignment(Pos.CENTER);
    }

    @Override
    public void actualizar(int valorEnergia) {
        this.valorEnergiaLabel.setText(String.valueOf(valorEnergia));

        if(valorEnergia > 0) {
            this.valorEnergiaLabel.setTextFill(Color.SADDLEBROWN);
        }else{
            this.valorEnergiaLabel.setTextFill(Color.RED);
        }

    }
}
