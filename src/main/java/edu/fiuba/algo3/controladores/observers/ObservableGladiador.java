package edu.fiuba.algo3.controladores.observers;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;

public interface ObservableGladiador {

    void notificarTriunfoObservadores() throws FinDelJuegoException;

    void subscribir(ObservadorGladiador observadorGladiador);
}
