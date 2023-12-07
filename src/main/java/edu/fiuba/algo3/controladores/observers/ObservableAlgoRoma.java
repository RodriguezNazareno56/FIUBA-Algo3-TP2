package edu.fiuba.algo3.controladores.observers;

import java.util.ArrayList;
import java.util.List;

public class ObservableAlgoRoma {
    private List<ObservadorAlgoRoma> observadores;

    public ObservableAlgoRoma() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(ObservadorAlgoRoma observador) {
        this.observadores.add(observador);
    }

    public void notificarNuevoTurno() {
        for (ObservadorAlgoRoma observador : observadores) {
            observador.visualizarProximoPanelInferior();
        }
    }
}
