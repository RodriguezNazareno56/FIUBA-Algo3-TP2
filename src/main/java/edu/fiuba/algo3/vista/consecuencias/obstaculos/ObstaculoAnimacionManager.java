package edu.fiuba.algo3.vista.consecuencias.obstaculos;

import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.consecuencias.AsisteAUnBacanal;
import edu.fiuba.algo3.modelo.consecuencias.FieraSalvaje;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.modelo.consecuencias.Lesion;
import edu.fiuba.algo3.vista.consecuencias.ConsecuenciaAnimacion;
import edu.fiuba.algo3.vista.consecuencias.equipamiento.EquipamientoAnimacion;
import edu.fiuba.algo3.vista.mapa.components.MapaVista;

public class ObstaculoAnimacionManager implements ConsecuenciaAnimacion {
    @Override
    public void agregarAnimacion(MapaVista mapaVista, IConsecuencia consecuencia, Coordenada coordenada) {
        if(this.seEncotroObstaculos(consecuencia)){
            ObstaculoAnimacion obstaculoAnimacion = new ObstaculoAnimacion();
            obstaculoAnimacion.setFitWidth(20);
            obstaculoAnimacion.setFitHeight(20);
            mapaVista.add(obstaculoAnimacion, coordenada.getX(),coordenada.getY());
        }
    }

    private boolean seEncotroObstaculos(IConsecuencia consecuencia){
        return consecuencia.equals(new AsisteAUnBacanal()) || consecuencia.equals(new Lesion()) || consecuencia.equals(new FieraSalvaje());
    }
}
