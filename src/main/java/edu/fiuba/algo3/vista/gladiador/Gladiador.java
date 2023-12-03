package edu.fiuba.algo3.vista.gladiador;

import edu.fiuba.algo3.vista.Animacion;
import edu.fiuba.algo3.vista.ViewProperties;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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


}
