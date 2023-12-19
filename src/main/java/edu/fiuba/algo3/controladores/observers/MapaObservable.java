package edu.fiuba.algo3.controladores.observers;

import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import java.util.ArrayList;
import java.util.List;

public class MapaObservable {

    private List<MapaObservador> observadores;

    public MapaObservable() {
        this.observadores = new ArrayList<>();
    }

    public void notificarPosicionamientoDeGladiador(Gladiador gladiador, Coordenada coordenada) {
        for (MapaObservador observador : observadores) {
            observador.actualizar(gladiador, coordenada);
        }
    }

    public void agregarObservador(MapaObservador observador) {
        this.observadores.add(observador);
    }
}
