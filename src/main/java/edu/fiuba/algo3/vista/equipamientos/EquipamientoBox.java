package edu.fiuba.algo3.vista.equipamientos;

import edu.fiuba.algo3.vista.utilidades.ViewProperties;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;

public class EquipamientoBox extends StackPane {

    private Equipamiento equipamientoImageView;

    public EquipamientoBox(Equipamiento equipamientoImageView) {
        this.equipamientoImageView = equipamientoImageView;

        // Preferiria usar padding pero se me desordena
        //        this.setPadding(new Insets(20));
        this.setPrefSize(ViewProperties.equipamientoViewAncho + 50, ViewProperties.equipamientoViewAlto + 50);

        // Background
        URL url = this.getClass().getResource("EquipamientoBoxBackground.png");
        Image image = new Image(url.toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT, // Puedes cambiar esto según tus necesidades
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        false, false, true, false
                )
        );
        Background background = new Background(backgroundImage);
        this.setBackground(background);

        // Añado imagen del equipo centrada y ensombrecido (aun no lo posee)
        equipamientoImageView.ensombrecer();
        this.setAlignment(equipamientoImageView, Pos.CENTER);
        this.getChildren().add(equipamientoImageView);
    }

    public void visibilizarEquipamiento() {
        this.equipamientoImageView.visibilizar();
    }
}
