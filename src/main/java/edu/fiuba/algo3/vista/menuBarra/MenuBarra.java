package edu.fiuba.algo3.vista.menuBarra;

import edu.fiuba.algo3.vista.menuBarra.controladoresBarra.CerrarAppEventHandler;
import edu.fiuba.algo3.vista.menuBarra.controladoresBarra.PantallaCompletaEventHandler;
import javafx.beans.binding.When;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class MenuBarra extends MenuBar {


    public MenuBarra(Stage stage, AudioClip sonido){


        Menu opciones = new Menu();

        //Icono del Menu
        ImageView imagenOpciones = new ImageView("file:src/main/resources/edu/fiuba/algo3/vista/barraMemu/imagenOpcionesMenu.png");
        imagenOpciones.setFitHeight(15);
        imagenOpciones.setFitWidth(15);
        opciones.setGraphic(imagenOpciones);


        // Items del Menu
        MenuItem itemInstrucciones = new MenuItem("Instrucciones");
        opciones.getItems().add(itemInstrucciones);

        MenuSonido itemSonido = new MenuSonido("Sonido", sonido);
        opciones.getItems().add(itemSonido);

        MenuItem itemPantallCompleta = new MenuItem("Pantalla Completa");
        opciones.getItems().add(itemPantallCompleta);


        itemPantallCompleta.textProperty().bind(
                new When(stage.fullScreenProperty())
                        .then("Desactivar Pantalla Completa")
                        .otherwise("Activar Pantalla Completa"));

         itemPantallCompleta.setOnAction(new PantallaCompletaEventHandler(stage));


        MenuItem itemSalir = new MenuItem("Salir");
        itemSalir.setOnAction( new CerrarAppEventHandler());


        opciones.getItems().add(new SeparatorMenuItem());
        opciones.getItems().add(itemSalir);
        this.getMenus().add(opciones);



    }





}
