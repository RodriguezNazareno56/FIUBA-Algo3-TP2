package edu.fiuba.algo3.Controladores.observers;

public interface ObservableDado {
    void notificarObservadores(int valorDelDado);

    void agregarObservador(ObservadorDado observador);
}
