package edu.fiuba.algo3.vista.barraMenu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BarraMenu extends MenuBar {


    public BarraMenu(){


        Menu opciones = new Menu();

        ImageView imagenOpciones = new ImageView("file:src/main/resources/edu/fiuba/algo3/vista/barraMemu/imagenOpcionesMenu.png");
        imagenOpciones.setFitHeight(25);
        imagenOpciones.setFitWidth(25);
        opciones.setGraphic(imagenOpciones);

        MenuItem itemInstrucciones = new MenuItem("Instrucciones");
        opciones.getItems().add(itemInstrucciones);

        MenuItem itemSonido = new MenuItem("Sonido");
        opciones.getItems().add(itemSonido);

        MenuItem itemPantallCompleta = new MenuItem("Pantalla Completa");
        opciones.getItems().add(itemPantallCompleta);

        MenuItem itemSalir = new MenuItem("Salir");
        opciones.getItems().add(new SeparatorMenuItem());
        opciones.getItems().add(itemSalir);


        this.getMenus().add(opciones);



    }





}
