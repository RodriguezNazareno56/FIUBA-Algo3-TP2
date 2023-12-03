package edu.fiuba.algo3.vista.equipamientos;

import javafx.scene.image.Image;

import java.net.URL;

public class EscudoYEspada extends Equipamiento {

    public EscudoYEspada() {
        super();
        URL url = this.getClass().getResource("EscudoYEspada.png");
        Image escudoYEspadaImage = new Image(url.toExternalForm());
        this.setImage(escudoYEspadaImage);
    }
}
