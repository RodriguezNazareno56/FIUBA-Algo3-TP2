package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.algoRomaEstado.EstadoJuego;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoEnCurso;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoSinIniciar;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoTerminado;

public interface AlgoRomaEstado {

    void jugarTurnoSegunEstado(JuegoSinIniciar juegoSinIniciar) throws Exception;
    void jugarTurnoSegunEstado(JuegoEnCurso juegoEnCurso) throws Exception;
    void jugarTurnoSegunEstado(JuegoTerminado juegoTerminado) throws FinDelJuegoException ;

    void setEstadoJuego(EstadoJuego estadoJuego);

    int getCantidadDeGladiadores();
    int getMaximaCantidadRondas();
    int getMaximaCantidadGladiadores();
    int getMinimaCantidadGladiadores();
    int getRondasJugadas();


}
