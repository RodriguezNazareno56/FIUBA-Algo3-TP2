package edu.fiuba.algo3.modelo.json_parsing;

public class Mapa {
    private int ancho;
    private int largo;

    public Mapa() {
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    @Override
    public String toString() {
        return "Mapa{" +
                "ancho=" + ancho +
                ", largo=" + largo +
                '}';
    }
}
