package edu.fiuba.algo3.controladores.observers;

import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public interface MapaObservador {
    void actualizar(Gladiador gladiador, Coordenada coordenada);
}
