package edu.fiuba.algo3.vista.menuBarra;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.media.AudioClip;

public class MenuSonido extends Menu {


    public MenuSonido(String nombreMenu, AudioClip sonido){

        super(nombreMenu);

        //Items del menu Sonido

        RadioMenuItem itemActivado  = new RadioMenuItem("Activado");
        RadioMenuItem itemDesactivado = new RadioMenuItem("Desactivado");

        itemActivado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sonido.play();
                itemActivado.setDisable(true);
                itemDesactivado.setDisable(false);
            }
        });


        itemDesactivado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sonido.stop();
                itemActivado.setDisable(false);
                itemDesactivado.setDisable(true);
            }
        });

        sonido.play();
        itemActivado.setSelected(true);
        itemActivado.setDisable(true);

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().add(itemActivado);
        toggleGroup.getToggles().add(itemDesactivado);

        this.getItems().add(itemActivado);
        this.getItems().add(itemDesactivado);


    }



}
