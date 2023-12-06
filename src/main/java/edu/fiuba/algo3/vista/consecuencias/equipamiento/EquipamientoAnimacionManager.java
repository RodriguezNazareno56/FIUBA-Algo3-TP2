package edu.fiuba.algo3.vista.consecuencias.equipamiento;

import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.consecuencias.EquipamientoIncrementado;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.vista.consecuencias.ConsecuenciaAnimacion;
import edu.fiuba.algo3.vista.mapa.components.MapaVista;

public class EquipamientoAnimacionManager implements ConsecuenciaAnimacion {
    @Override
    public void agregarAnimacion(MapaVista mapaVista, IConsecuencia consecuencia, Coordenada coordenada) {
        if(consecuencia.equals(new EquipamientoIncrementado())){
            EquipamientoAnimacion equipamientoAnimacion = new EquipamientoAnimacion();
            equipamientoAnimacion.setFitWidth(20);
            equipamientoAnimacion.setFitHeight(20);
            mapaVista.add(equipamientoAnimacion, coordenada.getX(),coordenada.getY());
        }
    }

}
