package edu.fiuba.algo3.controladores.observers;

public interface EquipamientoObservable {
    void notificarObservadoresEquipamiento();

    void agregarObservadorEquipamiento(EquipamientoObservador observadorEquipamiento);
}
