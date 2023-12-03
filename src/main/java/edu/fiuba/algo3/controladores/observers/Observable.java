package edu.fiuba.algo3.controladores.observers;

public interface Observable {
    void agregarObservador(Observador observador);
    void notificarAObservadores();
}
