package edu.fiuba.algo3.vista.gladiador;

import edu.fiuba.algo3.vista.Animacion;
import edu.fiuba.algo3.vista.ViewProperties;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;

public class Gladiador extends ImageView {

    public Gladiador() {
//        this.setFitWidth(ViewProperties.gladiadorViewAncho);
        this.setFitHeight(ViewProperties.gladiadorViewAlto);
        this.setPreserveRatio(true);

        URL url = this.getClass().getResource("GreekBasic.png");
        Image armaduraImage = new Image(url.toExternalForm());
        this.setImage(armaduraImage);
    }

    public Gladiador(int alto) {
        this.setFitHeight(alto);
        this.setPreserveRatio(true);

        URL url = this.getClass().getResource("GreekBasic.png");
        Image armaduraImage = new Image(url.toExternalForm());
        this.setImage(armaduraImage);
        Label etiquetaJuego = new Label();
        etiquetaJuego.setFont(Font.font("Helvetica", FontWeight.BOLD,16));

        etiquetaJuego.setText("Nombre jugador");
        etiquetaJuego.setTextFill(Color.web("#FFFFFF"));
    }


}
