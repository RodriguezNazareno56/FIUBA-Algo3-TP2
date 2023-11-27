package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.camino.Camino;

public class Mapa {
    private int ancho;
    private int largo;
    private Camino camino;

    public Mapa(int ancho, int largo) {
        this.ancho = ancho;
        this.largo = largo;
    }

    public void setCamino(Camino camino) {
        this.camino = camino;
    }

    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }
}
