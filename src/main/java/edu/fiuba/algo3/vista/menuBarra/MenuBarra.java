package edu.fiuba.algo3.vista.menuBarra;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

public class MenuBarra extends MenuBar {


    public MenuBarra(AudioClip sonido){


        Menu opciones = new Menu();

        ImageView imagenOpciones = new ImageView("file:src/main/resources/edu/fiuba/algo3/vista/barraMemu/imagenOpcionesMenu.png");
        imagenOpciones.setFitHeight(15);
        imagenOpciones.setFitWidth(15);
        opciones.setGraphic(imagenOpciones);

        MenuItem itemInstrucciones = new MenuItem("Instrucciones");
        opciones.getItems().add(itemInstrucciones);

        MenuSonido itemSonido = new MenuSonido("Sonido", sonido);
        opciones.getItems().add(itemSonido);


        MenuItem itemPantallCompleta = new MenuItem("Pantalla Completa");
        opciones.getItems().add(itemPantallCompleta);

        MenuItem itemSalir = new MenuItem("Salir");
        opciones.getItems().add(new SeparatorMenuItem());
        opciones.getItems().add(itemSalir);


        this.getMenus().add(opciones);



    }





}
