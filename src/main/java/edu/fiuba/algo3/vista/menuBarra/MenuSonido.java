package edu.fiuba.algo3.vista.menuBarra;

import edu.fiuba.algo3.vista.menuBarra.controladores.ActivarSonidoEventHandler;
import edu.fiuba.algo3.vista.menuBarra.controladores.DesactivarSonidoEventHandler;
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


        ActivarSonidoEventHandler activarSonidoEventHandler = new ActivarSonidoEventHandler(sonido, itemActivado, itemDesactivado);
        itemActivado.setOnAction(activarSonidoEventHandler);

        DesactivarSonidoEventHandler desactivarSonidoEventHandler = new DesactivarSonidoEventHandler(sonido, itemActivado, itemDesactivado);
        itemDesactivado.setOnAction(desactivarSonidoEventHandler);

        itemActivado.setSelected(true);
        itemActivado.setDisable(true);

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().add(itemActivado);
        toggleGroup.getToggles().add(itemDesactivado);

        this.getItems().add(itemActivado);
        this.getItems().add(itemDesactivado);


    }



}
