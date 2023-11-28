package edu.fiuba.algo3.vista;

import java.util.ArrayList;

public class EstadoJuego {

    private String[] nombres;


    public EstadoJuego(){
        this.nombres = null;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.nombres = new String[cantidadJugadores];
    }

    public int getCantidadJugadores(){
        return this.nombres.length;
    }

    public void setNombresJugadores(String[] nombre){
        this.nombres = nombre;
    }
}
