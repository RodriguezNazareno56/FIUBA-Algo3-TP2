package edu.fiuba.algo3.vista.consecuencias.obstaculos;

import edu.fiuba.algo3.vista.components.animacion.Animacion;
import javafx.scene.image.Image;

import java.util.ArrayDeque;
import java.util.Queue;

public class ObstaculoAnimacion extends Animacion {

    public ObstaculoAnimacion(){
        super();
        super.crearAnimacion();
        this.setFitHeight(50);
        this.setPreserveRatio(true);
    }

    @Override
    protected Queue<Image> getAnimacionImages() {
        Queue<Image> imageQueue = new ArrayDeque<>();
        imageQueue.add(new Image("File:src/main/resources/edu/fiuba/algo3/vista/obstaculo/Obstaculo2.png", 400, 600, true, true));
        return imageQueue;
    }
}
