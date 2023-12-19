package edu.fiuba.algo3.vista.menuBarra.controladores;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.media.AudioClip;

public class DesactivarSonidoEventHandler implements EventHandler {

    private RadioMenuItem itemActivado;
    private RadioMenuItem itemDesactivado;
    private AudioClip sonido;

    public DesactivarSonidoEventHandler(AudioClip sonido , RadioMenuItem itemActivado, RadioMenuItem itemDesactivado){
        this.sonido = sonido;
        this.itemActivado = itemActivado;
        this.itemDesactivado = itemDesactivado;
    }

    @Override
    public void handle(Event event) {
        this.sonido.stop();
        this.itemActivado.setDisable(false);
        this.itemDesactivado.setDisable(true);

    }
}
