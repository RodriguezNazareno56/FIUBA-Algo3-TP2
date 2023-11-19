package edu.fiuba.algo3.Inventario;

import edu.fiuba.algo3.Equipamientos.Equipamiento;

public interface Inventario<T> {
    void agregarSiNoExiste(T t);
    T buscarPor(int indice);

    T buscarPor(T t);
}
