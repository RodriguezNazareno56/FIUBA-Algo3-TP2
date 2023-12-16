package edu.fiuba.algo3.controladores.observers;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public interface ObservadorGladiador {

    void notificarTriunfo(Gladiador gladiador) throws FinDelJuegoException;

}
