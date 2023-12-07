package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.FinDelJuegoException;

public interface ObservadorGladiador {

    void notificarTriunfo(Gladiador gladiador) throws FinDelJuegoException;

}
