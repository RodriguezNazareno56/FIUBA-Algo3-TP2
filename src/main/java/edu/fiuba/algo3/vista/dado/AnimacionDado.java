package edu.fiuba.algo3.vista.dado;

import edu.fiuba.algo3.vista.Animacion;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ArrayDeque;
import java.util.Queue;

public class AnimacionDado extends Animacion {

    public AnimacionDado() {
        super();
        super.crearAnimacion();
    }

    @Override
    // Animacion
    protected Queue<Image> getAnimacionImages() {
        Queue<Image> imageQueue = new ArrayDeque<>();
        for (int i = 1; i <= 6; i++) {
            URL url = this.getClass().getResource("dado_" + i + ".png");
            imageQueue.add(new Image(url.toExternalForm()));
        }
        return imageQueue;
    }
}
