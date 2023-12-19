package edu.fiuba.algo3.controladores.observers;

import edu.fiuba.algo3.modelo.excepciones.FinDelJuegoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public interface GladiadorObservador {

    void notificarTriunfo(Gladiador gladiador) throws FinDelJuegoException;

}
