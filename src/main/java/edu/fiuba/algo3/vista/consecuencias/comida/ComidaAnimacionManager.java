package edu.fiuba.algo3.vista.consecuencias.comida;

import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.consecuencias.Comida;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.vista.consecuencias.ConsecuenciaAnimacion;
import edu.fiuba.algo3.vista.mapa.MapaVista;

public class ComidaAnimacionManager implements ConsecuenciaAnimacion {
    @Override
    public void agregarAnimacion(MapaVista mapaVista, IConsecuencia consecuencia, Coordenada coordenada) {
        if(consecuencia.equals(new Comida())){
            ComidaAnimacion comidaAnimacion = new ComidaAnimacion();
            comidaAnimacion.setFitWidth(20);
            comidaAnimacion.setFitHeight(20);
            mapaVista.add(comidaAnimacion, coordenada.getX(),coordenada.getY());
        }
    }
}
