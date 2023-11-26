package edu.fiuba.algo3.modelo.json_parsing;

public class Juego {
    private Mapa mapa;
    private Camino camino;

    public Juego() {
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public Camino getCamino() {
        return camino;
    }

    public void setCamino(Camino camino) {
        this.camino = camino;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "mapa=" + mapa +
                ", camino=" + camino +
                '}';
    }
}
