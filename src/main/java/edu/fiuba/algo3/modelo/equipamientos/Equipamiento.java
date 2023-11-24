package edu.fiuba.algo3.modelo.equipamientos;

public abstract class Equipamiento implements Afectable {
    public abstract Equipamiento incrementar();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
