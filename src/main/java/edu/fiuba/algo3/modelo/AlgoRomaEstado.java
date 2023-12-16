package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.algoRomaEstado.EstadoJuego;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoEnCurso;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoSinIniciar;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoTerminado;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public interface AlgoRomaEstado {

    void jugarTurnoSegunEstado(JuegoSinIniciar juegoSinIniciar) throws Exception;
    void jugarTurnoSegunEstado(JuegoEnCurso juegoEnCurso) throws Exception;
    void jugarTurnoSegunEstado(JuegoTerminado juegoTerminado) throws FinDelJuegoException ;

    void setEstadoJuego(EstadoJuego estadoJuego);

    void agregarNuevoGladiador(Gladiador gladiador);

    int getCantidadDeGladiadores();
    int getMaximaCantidadRondas();
    int getMaximaCantidadGladiadores();
    int getMinimaCantidadGladiadores();
    int getRondasJugadas();


}
