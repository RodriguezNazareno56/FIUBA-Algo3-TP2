package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.FinDelJuegoException;

public interface ObservableGladiador {

    void notificarTriunfoObservadores() throws FinDelJuegoException;

    void subscribir(ObservadorGladiador observadorGladiador);
}
