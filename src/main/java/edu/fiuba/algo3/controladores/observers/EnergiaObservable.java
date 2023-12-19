package edu.fiuba.algo3.controladores.observers;

import java.util.ArrayList;
import java.util.List;

public class EnergiaObservable {

    private List<EnergiaObservador> observadores;

    public EnergiaObservable() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(EnergiaObservador observador) {
        this.observadores.add(observador);
    }

    public void notificar(int energiaValor) {
        for (EnergiaObservador observador : observadores) {
            observador.actualizar(energiaValor);
        }
    }
}
