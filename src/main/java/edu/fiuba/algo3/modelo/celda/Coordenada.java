package edu.fiuba.algo3.modelo.celda;

public class Coordenada {
    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordenada (" +
                "x=" + x +
                ", y=" + y +
                ')';
    }
}
