package edu.fiuba.algo3.inventario;

public interface Inventario<T> {
    void agregarSiNoExiste(T t);
    T buscarPor(int indice);

    T buscarPor(T t);
}
