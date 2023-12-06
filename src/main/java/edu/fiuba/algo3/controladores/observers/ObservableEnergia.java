package edu.fiuba.algo3.controladores.observers;

import java.util.ArrayList;
import java.util.List;

public class ObservableEnergia {

    private List<ObservadorEnergia> observadores;

    public ObservableEnergia() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(ObservadorEnergia observador) {
        this.observadores.add(observador);
    }

    public void notificar(int energiaValor) {
        for (ObservadorEnergia observador : observadores) {
            observador.actualizar(energiaValor);
        }
    }
}
