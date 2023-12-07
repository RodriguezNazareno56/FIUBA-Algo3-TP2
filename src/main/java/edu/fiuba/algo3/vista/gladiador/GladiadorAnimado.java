package edu.fiuba.algo3.vista.gladiador;

import edu.fiuba.algo3.vista.ViewProperties;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayDeque;
import java.util.Queue;

public class GladiadorAnimado extends ImageView {

    private static final int ANIMACION_DURACION_EN_MILISEGUNDOS = 800;
    private final String nombre;

    public enum Color {
        DORADO,
        GRIS,
        MARRON;
    }

    private String colorString;

    public GladiadorAnimado(String nombre, Color color) {
        switch (color) {
            case GRIS:
                this.colorString = "gris";
                break;
            case MARRON:
                this.colorString = "marron";
                break;
            case DORADO:
                this.colorString = "dorado";
                break;
        }
        this.nombre = nombre;
        this.crearAnimacion();
        this.setFitHeight(ViewProperties.gladiadorViewAlto);
        this.setPreserveRatio(true);
    }

    public String getNombre() {
        return nombre;
    }

    protected Queue<Image> getAnimacionImages() {
        Queue<Image> imageQueue = new ArrayDeque<>();
        for (int i = 0; i < 18; i++) {
            String numero = String.format("%02d", i);
            String url = "file:src/main/resources/edu/fiuba/algo3/vista/gladiador/"+ colorString +
                    "/idle/GreekBasic_Idle_"+ numero +".png";
            imageQueue.add(new Image(url, 400, 600, true, true));
        }
        return imageQueue;
    }

//    private Queue<Image> getAnimacionAtaqueImages() {
//        Queue<Image> imageQueue = new ArrayDeque<>();
//        for (int i = 0; i < 8; i++) {
//            String numero = String.format("%01d", i);
//            URL url = this.getClass().getResource("attack/GreekBasic_Attack_" + numero + ".png");
//            imageQueue.add(new Image(url.toExternalForm(), 400, 600, true, true));
//        }
//        return imageQueue;
//    }

    protected void crearAnimacion() {
        ObjectProperty<Integer> indexProperty = new SimpleObjectProperty<>(0);
        Queue<Image> imageQueue = getAnimacionImages();
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
                setCycleDuration(Duration.millis(ANIMACION_DURACION_EN_MILISEGUNDOS));
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
