package edu.fiuba.algo3.modelo.consecuencias;

public abstract class Consecuencia implements IConsecuencia {

    // Dos consecuencias son iguales cuando son del mismo tipo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consecuencia that = (Consecuencia) o;
        return getClass().equals(that.getClass());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
