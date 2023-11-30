package edu.fiuba.algo3.modelo.gladiador;

import java.util.Objects;

public class Energia {
    private int valor;

    public Energia(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void aumentarEnergia(Energia energia){
        valor += energia.getValor();
    }

    public void disminuirEnergia(Energia energia){
        valor -= energia.getValor();
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
        return "" + valor;
    }
}
