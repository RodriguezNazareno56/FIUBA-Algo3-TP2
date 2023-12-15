package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.controladores.observers.ObservadorAlgoRoma;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.util.ArrayList;

public interface AlgoRomaModelo {
    void agregarGladiador(String nombre)throws MaximoGladiadoresException,
            JuegoEnCursoException, FinDelJuegoException, NombreInvalidoException;

    void agregarGladiador(Gladiador gladiador)throws MaximoGladiadoresException,
            JuegoEnCursoException, FinDelJuegoException;

    void jugarTurno() throws Exception ;

    int getRondasJugadas();

    int getCantidadDeGladiadores();

    int getMaximaCantidadRondas();

    ArrayList<String> getNombresGladiadoresSegunOrdenEnRonda();

    ArrayList<String> getNombresGladiadoresSegunOrdenDeIngreso();

    int getMinimaCantidadGladiadores();

    int getMaximaCantidadGladiadores();

    Mapa getMapa();

    void agregarObservadorNuevoTurno(ObservadorAlgoRoma observador);

    void agregarObservadorNuevoGladiador(ObservadorAlgoRoma observador);

    void notificarNuevoTurno();

    void notificarNuevoGladiador();
}
