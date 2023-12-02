package edu.fiuba.algo3.vista.equipamientos;

import javafx.scene.image.Image;

import java.net.URL;

public class Casco extends Equipamiento {

    public Casco() {
        super();
        URL url = this.getClass().getResource("Casco.png");
        Image cascoImage = new Image(url.toExternalForm());
        this.setImage(cascoImage);
    }
}
