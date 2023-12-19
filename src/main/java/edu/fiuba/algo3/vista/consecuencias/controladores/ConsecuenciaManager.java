package edu.fiuba.algo3.vista.consecuencias.controladores;

import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.vista.consecuencias.ConsecuenciaAnimacion;
import edu.fiuba.algo3.vista.consecuencias.comida.ComidaAnimacionManager;
import edu.fiuba.algo3.vista.consecuencias.equipamiento.EquipamientoAnimacionManager;
import edu.fiuba.algo3.vista.consecuencias.obstaculos.ObstaculoAnimacionManager;
import edu.fiuba.algo3.vista.mapa.MapaVista;

import java.util.ArrayList;
import java.util.List;

public class ConsecuenciaManager {
    private List<ConsecuenciaAnimacion> consecuenciaAnimaciones;

    public ConsecuenciaManager(){
        this.consecuenciaAnimaciones = new ArrayList<>();
        this.cargarAnimaciones();
    }

    public void agregarAnimaciones(List<IConsecuencia> consecuencias, MapaVista mapaVista, Coordenada coordenada){
        consecuencias.forEach(consecuencia -> this.consecuenciaAnimaciones.
                    forEach(consecuenciaAnimacion -> consecuenciaAnimacion.agregarAnimacion(mapaVista,consecuencia,coordenada))
        );
    }

    private void cargarAnimaciones(){
        this.consecuenciaAnimaciones.add(new EquipamientoAnimacionManager());
        this.consecuenciaAnimaciones.add(new ObstaculoAnimacionManager());
        this.consecuenciaAnimaciones.add(new ComidaAnimacionManager());

    }
}
