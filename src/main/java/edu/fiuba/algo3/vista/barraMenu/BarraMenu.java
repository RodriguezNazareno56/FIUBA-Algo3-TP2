package edu.fiuba.algo3.vista.barraMenu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class BarraMenu extends MenuBar {


    public BarraMenu(){


        Menu opciones = new Menu("Opciones");

        MenuItem itemInstrucciones = new MenuItem("Instrucciones");
        opciones.getItems().add(itemInstrucciones);

        MenuItem itemSonido = new MenuItem("Sonido");
        opciones.getItems().add(itemSonido);

        MenuItem itemPantallCompleta = new MenuItem("Pantalla Completa");
        opciones.getItems().add(itemPantallCompleta);

        MenuItem itemSalir = new MenuItem("Salir");
        opciones.getItems().add(itemSalir);


        this.getMenus().add(opciones);



    }





}
