package edu.fiuba.algo3.controladores.observers;

import java.util.ArrayList;
import java.util.List;

public class AlgoRomaObservable {
    private List<AlgoRomaObservador> observadoresNuevoGladiador;
    private List<AlgoRomaObservador> observadoresNuevoTurno;

    public AlgoRomaObservable() {
        this.observadoresNuevoGladiador = new ArrayList<>();
        this.observadoresNuevoTurno = new ArrayList<>();
    }

    public void agregarObservadorNuevoTurno(AlgoRomaObservador observador) {
        this.observadoresNuevoTurno.add(observador);
    }
    public void agregarObservadorNuevoGladiador(AlgoRomaObservador observador) {
        this.observadoresNuevoGladiador.add(observador);
    }

    public void notificarNuevoTurno() {
        for (AlgoRomaObservador observador : observadoresNuevoTurno) {
            observador.update();
        }
    }
    public void notificarNuevoGladiador() {
        for (AlgoRomaObservador observador : observadoresNuevoGladiador) {
            observador.update();
        }
    }

}
