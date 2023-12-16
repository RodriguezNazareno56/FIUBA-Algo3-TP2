package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.algoRomaEstado.EstadoJuego;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoEnCurso;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoSinIniciar;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoTerminado;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import java.util.ArrayList;

public interface AlgoRomaEstado {

    void agregarNuevoGladiador(Gladiador gladiador);

    void jugarTurnoSegunEstado(JuegoSinIniciar juegoSinIniciar) throws Exception;
    void jugarTurnoSegunEstado(JuegoEnCurso juegoEnCurso) throws Exception;

    void setEstadoJuego(EstadoJuego estadoJuego);


    int getCantidadDeGladiadores();
    int getMaximaCantidadRondas();
    int getMaximaCantidadGladiadores();
    int getMinimaCantidadGladiadores();
    int getRondasJugadas();
    ArrayList<String> getNombresGladiadoresSegunOrdenEnRonda();


}
