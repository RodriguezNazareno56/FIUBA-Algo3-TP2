package edu.fiuba.algo3.vista.consecuencias.comida;

import edu.fiuba.algo3.vista.Animacion;
import javafx.scene.image.Image;

import java.util.ArrayDeque;
import java.util.Queue;

public class ComidaAnimacion extends Animacion {
    public ComidaAnimacion(){
        super();
        super.crearAnimacion();
        this.setFitHeight(50);
        this.setPreserveRatio(true);
    }

    @Override
    protected Queue<Image> getAnimacionImages() {
        Queue<Image> imageQueue = new ArrayDeque<>();
        imageQueue.add(new Image("File:src/main/resources/edu/fiuba/algo3/vista/comida/ComidaPremio.png", 400, 600, true, true));
        return imageQueue;
    }
}
