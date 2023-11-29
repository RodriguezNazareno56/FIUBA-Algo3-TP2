package edu.fiuba.algo3.data_acceso.DTOs;

public class MapaDto {
    private int ancho;
    private int largo;

    public MapaDto() {
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
