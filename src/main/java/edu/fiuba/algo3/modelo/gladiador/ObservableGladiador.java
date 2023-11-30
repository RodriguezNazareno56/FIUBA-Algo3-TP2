package edu.fiuba.algo3.modelo.gladiador;

public interface ObservableGladiador {

    void notificarTriunfoObservadores();

    void subscribir(ObservadorGladiador observadorGladiador);
}
