package edu.fiuba.algo3.controladores.observers;

public interface DadoObservable {
    void notificarObservadores(int valorDelDado);

    void agregarObservador(DadoObservador observador);
}
