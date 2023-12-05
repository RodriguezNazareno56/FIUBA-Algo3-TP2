package edu.fiuba.algo3.vista.consecuencias.equipamiento;

import edu.fiuba.algo3.vista.Animacion;
import edu.fiuba.algo3.vista.ViewProperties;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ArrayDeque;
import java.util.Queue;

public class EquipamientoAnimacion extends Animacion {

    public EquipamientoAnimacion(){
        super();
        super.crearAnimacion();
        this.setFitHeight(50);
        this.setPreserveRatio(true);
    }

        @Override
        protected Queue<Image> getAnimacionImages() {
            Queue<Image> imageQueue = new ArrayDeque<>();
            imageQueue.add(new Image("File:src/main/resources/edu/fiuba/algo3/vista/equipamientos/EquipamientoPremio.png", 400, 600, true, true));
            return imageQueue;
        }
}

