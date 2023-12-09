package edu.fiuba.algo3.controladores.observers;

import java.util.ArrayList;
import java.util.List;

public class ObservableAlgoRoma {
    private List<ObservadorAlgoRoma> observadoresNuevoGladiador;
    private List<ObservadorAlgoRoma> observadoresNuevoTurno;

    public ObservableAlgoRoma() {
        this.observadoresNuevoGladiador = new ArrayList<>();
        this.observadoresNuevoTurno = new ArrayList<>();
    }

    public void agregarObservadorNuevoTurno(ObservadorAlgoRoma observador) {
        this.observadoresNuevoTurno.add(observador);
    }
    public void agregarObservadorNuevoGladiador(ObservadorAlgoRoma observador) {
        this.observadoresNuevoGladiador.add(observador);
    }

    public void notificarNuevoTurno() {
        for (ObservadorAlgoRoma observador : observadoresNuevoTurno) {
            observador.update();
        }
    }


    public void notificarNuevoGladiador() {
        for (ObservadorAlgoRoma observador : observadoresNuevoGladiador) {
            observador.update();
        }
    }

}
