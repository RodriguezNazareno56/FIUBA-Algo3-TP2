package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.controladores.observers.EnergiaObservable;

import java.util.Objects;

public class Energia extends EnergiaObservable {
    private int valor;

    public Energia(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void aumentarEnergia(Energia energia){
        int nuevoValor = this.valor + energia.getValor();
        this.cambiarValor(nuevoValor);
    }

    public void disminuirEnergia(Energia energia){
        int nuevoValor = this.valor - energia.getValor();
        this.cambiarValor(nuevoValor);
    }

    private void cambiarValor(int nuevoValor) {
        valor = nuevoValor;
        notificar(valor);
    }

    public boolean isAgotada() {
        return valor <= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Energia energia = (Energia) o;
        return valor == energia.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return "" + valor + " puntos";
    }
}
