package edu.fiuba.algo3.modelo.gladiador.senority;

import edu.fiuba.algo3.modelo.gladiador.Energia;

public abstract class Senority {
    int experiencia;
    public abstract Senority aumentarExperiencia();
    public abstract void aumentarEnergia(Energia energia);
}
