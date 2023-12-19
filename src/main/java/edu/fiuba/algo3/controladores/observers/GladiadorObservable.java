package edu.fiuba.algo3.controladores.observers;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;

public interface GladiadorObservable {

    void notificarTriunfoObservadores() throws FinDelJuegoException;

    void subscribir(GladiadorObservador observadorGladiador);
}
