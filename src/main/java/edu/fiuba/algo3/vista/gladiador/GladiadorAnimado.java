package edu.fiuba.algo3.vista.gladiador;

import edu.fiuba.algo3.vista.Animacion;
import edu.fiuba.algo3.vista.ViewProperties;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ArrayDeque;
import java.util.Queue;

public class GladiadorAnimado extends Animacion {

    private String name;

    public GladiadorAnimado() {
        super();
        super.crearAnimacion();
        this.setFitHeight(ViewProperties.gladiadorViewAlto);
        this.setPreserveRatio(true);
    }

    @Override
    protected Queue<Image> getAnimacionImages() {
        Queue<Image> imageQueue = new ArrayDeque<>();
        for (int i = 0; i < 18; i++) {
            String numero = String.format("%02d", i);
            URL url = this.getClass().getResource("idle/GreekBasic_Idle_" + numero + ".png");
            imageQueue.add(new Image(url.toExternalForm(), 400, 600, true, true));
        }
        return imageQueue;
    }

    private Queue<Image> getAnimacionAtaqueImages() {
        Queue<Image> imageQueue = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            String numero = String.format("%01d", i);
            URL url = this.getClass().getResource("attack/GreekBasic_Attack_" + numero + ".png");
            imageQueue.add(new Image(url.toExternalForm(), 400, 600, true, true));
        }
        return imageQueue;
    }
}
