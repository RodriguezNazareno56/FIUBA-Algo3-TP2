package edu.fiuba.algo3.controladores.observers;

public interface ObservableDado {
    void notificarObservadores(int valorDelDado);

    void agregarObservador(ObservadorDado observador);
}
