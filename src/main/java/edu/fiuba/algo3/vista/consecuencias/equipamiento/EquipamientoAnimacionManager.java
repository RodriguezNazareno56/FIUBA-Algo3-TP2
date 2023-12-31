package edu.fiuba.algo3.vista.consecuencias.equipamiento;

import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.consecuencias.EquipamientoIncrementado;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.vista.consecuencias.ConsecuenciaAnimacion;
import edu.fiuba.algo3.vista.mapa.MapaVista;

public class EquipamientoAnimacionManager implements ConsecuenciaAnimacion {
    @Override
    public void agregarAnimacion(MapaVista mapaVista, IConsecuencia consecuencia, Coordenada coordenada) {
        if(consecuencia.equals(new EquipamientoIncrementado())){
            EquipamientoAnimacion equipamientoAnimacion = new EquipamientoAnimacion();
            equipamientoAnimacion.setFitWidth(50);
            equipamientoAnimacion.setFitHeight(50);
            mapaVista.add(equipamientoAnimacion, coordenada.getX(),coordenada.getY());
        }
    }

}
