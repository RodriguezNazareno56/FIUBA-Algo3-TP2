package edu.fiuba.algo3.vista.equipamientos;

import javafx.scene.image.Image;

import java.net.URL;

public class Armadura extends Equipamiento {

    public Armadura() {
        super();
        URL url = this.getClass().getResource("Armadura.png");
        Image armaduraImage = new Image(url.toExternalForm());
        this.setImage(armaduraImage);
    }
}
