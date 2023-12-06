package edu.fiuba.algo3.controladores.observers;

import java.util.ArrayList;

public abstract class Observable {
    private final ArrayList<Observador> observadores;

    protected Observable() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(Observador observador) {
        this.observadores.add(observador);
    }

    // TODO: este metodo debe ser privado
    public void notificarAObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar();
        }
    }
}
