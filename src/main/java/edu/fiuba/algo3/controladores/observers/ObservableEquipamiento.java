package edu.fiuba.algo3.controladores.observers;

import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;

public interface ObservableEquipamiento {
    void notificarObservadoresEquipamiento();

    void agregarObservadorEquipamiento(ObservadorEquipamiento observadorEquipamiento);
}
