package edu.fiuba.algo3.vista.consecuencias;

import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.vista.mapa.components.MapaVista;

public interface ConsecuenciaAnimacion {

    void agregarAnimacion(MapaVista mapaVista, IConsecuencia consecuencia, Coordenada coordenada);
}
