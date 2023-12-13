package edu.fiuba.algo3.vista.barraMenu;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BarraMenu extends MenuBar {


    public BarraMenu(){


        Menu opciones = new Menu();

        ImageView imagenOpciones = new ImageView("file:src/main/resources/edu/fiuba/algo3/vista/barraMemu/imagenOpcionesMenu.png");
        imagenOpciones.setFitHeight(15);
        imagenOpciones.setFitWidth(15);
        opciones.setGraphic(imagenOpciones);

        MenuItem itemInstrucciones = new MenuItem("Instrucciones");
        opciones.getItems().add(itemInstrucciones);


        // Item Sonido - SubMenu
        Menu itemSonido = new Menu("Sonido");
        opciones.getItems().add(itemSonido);

        RadioMenuItem itemActivado = new RadioMenuItem("Activado");
        RadioMenuItem itemDesactivado = new RadioMenuItem("Desactivado");
        itemActivado.setSelected(true);

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().add(itemActivado);
        toggleGroup.getToggles().add(itemDesactivado);

        itemSonido.getItems().add(itemActivado);
        itemSonido.getItems().add(itemDesactivado);



        MenuItem itemPantallCompleta = new MenuItem("Pantalla Completa");
        opciones.getItems().add(itemPantallCompleta);

        MenuItem itemSalir = new MenuItem("Salir");
        opciones.getItems().add(new SeparatorMenuItem());
        opciones.getItems().add(itemSalir);


        this.getMenus().add(opciones);



    }





}
