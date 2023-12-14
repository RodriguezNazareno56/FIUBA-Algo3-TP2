package edu.fiuba.algo3.vista.menuBarra.controladoresBarra;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.media.AudioClip;

public class ActivarSonidoEventHandler implements EventHandler {

    private RadioMenuItem itemActivado;
    private RadioMenuItem itemDesactivado;

    private AudioClip sonido;

    public ActivarSonidoEventHandler(AudioClip sonido , RadioMenuItem itemActivado, RadioMenuItem itemDesactivado){
        this.sonido = sonido;
        this.itemActivado = itemActivado;
        this.itemDesactivado = itemDesactivado;
    }

    @Override
    public void handle(Event event) {

        this.sonido.play();
        this.itemActivado.setDisable(true);
        this.itemDesactivado.setDisable(false);

    }
}
