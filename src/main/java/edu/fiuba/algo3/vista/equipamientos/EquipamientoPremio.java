package edu.fiuba.algo3.vista.equipamientos;

import javafx.scene.image.Image;

import java.net.URL;

public class EquipamientoPremio extends Equipamiento{

    public EquipamientoPremio() {
        super();
        URL url = this.getClass().getResource("EquipamientoPremio.png");
        Image equipamientoPremioImage = new Image(url.toExternalForm());
        this.setFitWidth(30);
        this.setFitHeight(30);
        this.setImage(equipamientoPremioImage);
    }
}
