package edu.fiuba.algo3.controladores.observers;

import edu.fiuba.algo3.modelo.gladiador.senority.states.SenorityState;

import java.util.ArrayList;

// TODO: puede extender de Observable
public abstract class SenorityStateObservable {
    private final ArrayList<SenorityObservador> observadores;

    protected SenorityStateObservable() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(SenorityObservador observador) {
        this.observadores.add(observador);
    }

    protected void notificarCambioDeSenority() {
        for (SenorityObservador observador : observadores) {
            observador.actualizarPorAumentoDeSenority();
        }
    }

    protected void transferirObservadoresA(SenorityState senorityState) {
        for (SenorityObservador observador : observadores) {
            senorityState.agregarObservador(observador);
        }
    }
}
