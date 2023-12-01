package edu.fiuba.algo3.modelo.celda;

import java.util.Objects;

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Dos coordenadas son iguales cuando tienen mismo x e y
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada that = (Coordenada) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
