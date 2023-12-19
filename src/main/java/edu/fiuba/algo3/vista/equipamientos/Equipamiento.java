package edu.fiuba.algo3.vista.equipamientos;

import edu.fiuba.algo3.vista.utilidades.ViewProperties;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;

public abstract class Equipamiento extends ImageView {

    public Equipamiento() {
        this.setFitWidth(ViewProperties.equipamientoViewAncho);
        this.setFitHeight(ViewProperties.equipamientoViewAlto);
        this.setPreserveRatio(true); // Evita que las unidades se deformen.
    }

    public void ensombrecer() {
        Shadow shadow = new Shadow();
        shadow.setColor(javafx.scene.paint.Color.rgb(23, 22, 22, 0.78)); // Color con transparencia
        shadow.setRadius(10.76);
        shadow.setWidth(24.04);
        this.setEffect(shadow);
    }

    public void visibilizar() {
        this.setEffect(null);
    }
}
