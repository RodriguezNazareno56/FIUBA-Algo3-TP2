package edu.fiuba.algo3.controladores.observers;

import java.util.ArrayList;

public abstract class Observable {
    private final ArrayList<SenorityObservador> observadores;

    protected Observable() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(SenorityObservador observador) {
        this.observadores.add(observador);
    }

    public void notificarAObservadores() {
        for (SenorityObservador observador : observadores) {
            observador.actualizarPorAumentoDeSenority();
        }
    }
}
