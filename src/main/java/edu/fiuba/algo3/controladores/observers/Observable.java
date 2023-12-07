package edu.fiuba.algo3.controladores.observers;

import java.util.ArrayList;

public abstract class Observable {
    private final ArrayList<ObservadorSenority> observadores;

    protected Observable() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(ObservadorSenority observador) {
        this.observadores.add(observador);
    }

    // TODO: este metodo debe ser privado
    public void notificarAObservadores() {
        for (ObservadorSenority observador : observadores) {
            observador.actualizarPorAumentoDeSenority();
        }
    }
}
