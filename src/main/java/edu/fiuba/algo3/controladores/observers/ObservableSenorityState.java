package edu.fiuba.algo3.controladores.observers;

import edu.fiuba.algo3.modelo.gladiador.senority.states.SenorityState;

import java.util.ArrayList;

// TODO: puede extender de Observable
public abstract class ObservableSenorityState {
    private final ArrayList<ObservadorSenority> observadores;

    protected ObservableSenorityState() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(ObservadorSenority observador) {
        this.observadores.add(observador);
    }

    protected void notificarCambioDeSenority() {
        for (ObservadorSenority observador : observadores) {
            observador.actualizarPorAumentoDeSenority();
        }
    }

    protected void transferirObservadoresA(SenorityState senorityState) {
        for (ObservadorSenority observador : observadores) {
            senorityState.agregarObservador(observador);
        }
    }
}
