package edu.fiuba.algo3.controladores.observers;

import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import java.util.ArrayList;
import java.util.List;

public class ObservableMapa {

    private List<ObservadorMapa> observadores;

    public ObservableMapa() {
        this.observadores = new ArrayList<>();
    }

    public void notificarPosicionamientoDeGladiador(Gladiador gladiador, Coordenada coordenada) {
        for (ObservadorMapa observador : observadores) {
            observador.actualizar(gladiador, coordenada);
        }
    }

    public void agregarObservador(ObservadorMapa observador) {
        this.observadores.add(observador);
    }
}
