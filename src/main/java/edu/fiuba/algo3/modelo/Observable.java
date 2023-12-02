package edu.fiuba.algo3.modelo;

public interface Observable {
    public void agregarObservador(Observador observador);
    public void notificarAObservadores();
}