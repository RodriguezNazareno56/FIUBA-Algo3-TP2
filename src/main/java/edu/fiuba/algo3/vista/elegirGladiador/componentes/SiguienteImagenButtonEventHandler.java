package edu.fiuba.algo3.vista.elegirGladiador.componentes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class SiguienteImagenButtonEventHandler implements EventHandler<ActionEvent> {

    private ArrayList<Image> imagenes;

    private boolean right;

    private ImageView imagenPerfilGladiador;

    public SiguienteImagenButtonEventHandler(ArrayList<Image> imagenes, boolean right, ImageView imagenPerfilGladiador) {
        super();
        this.imagenes = imagenes;
        this.right = right;
        this.imagenPerfilGladiador = imagenPerfilGladiador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        int index = imagenes.indexOf(imagenPerfilGladiador.getImage());
        if (right) {
            index++;
            if (index == imagenes.size()) {
                imagenPerfilGladiador.setImage(imagenes.get(0));
            }
            else{
                imagenPerfilGladiador.setImage(imagenes.get(index));
            }
        } else {
            index--;
            if (index == -1) {
                imagenPerfilGladiador.setImage(imagenes.get(imagenes.size() - 1));
            }
            else{
                imagenPerfilGladiador.setImage(imagenes.get(index));
            }
        }
    }
}
