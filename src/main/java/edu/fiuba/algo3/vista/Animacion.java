package edu.fiuba.algo3.vista;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Queue;

public class Animacion extends ImageView {

    public static final int DURACION_EN_MILISEGUNDOS = 800;
    private Queue<Image> imageQueue;

    public Animacion(Queue<Image> imageQueue) {
        this.imageQueue = imageQueue;
        this.crearAnimacion2();
    }

    protected void crearAnimacion2() {
        ObjectProperty<Integer> indexProperty = new SimpleObjectProperty<>(0);
        this.setImage(imageQueue.remove());

        indexProperty.addListener(observable -> {
            indexProperty.get();
            cambiarImage(this, imageQueue);
        });

        crearSpriteAnimation(indexProperty).play();
    }

    private void cambiarImage(ImageView sprite, Queue<Image> imageQueue) {
        imageQueue.add(sprite.getImage());
        sprite.setImage(imageQueue.remove());
    }

    private Animation crearSpriteAnimation(ObjectProperty<Integer> indexProperty) {
        Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(DURACION_EN_MILISEGUNDOS));
                setInterpolator(Interpolator.LINEAR);
            }

            protected void interpolate(double frac) {
                int value = ((int) (frac * 10));
                indexProperty.set(value);
            }
        };
        animation.setCycleCount(Animation.INDEFINITE);
        return animation;
    }
}
