package edu.fiuba.algo3.vista.equipamientos;

import javafx.scene.image.Image;

import java.net.URL;

public class Llave extends Equipamiento {

    public Llave() {
        super();
        URL url = this.getClass().getResource("Llave.png");
        Image llaveImage = new Image(url.toExternalForm());
        this.setImage(llaveImage);
    }
}
