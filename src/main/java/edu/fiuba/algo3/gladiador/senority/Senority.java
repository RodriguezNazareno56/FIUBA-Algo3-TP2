package edu.fiuba.algo3.gladiador.senority;

import edu.fiuba.algo3.gladiador.Energia;

public abstract class Senority {
    int experiencia;
    public abstract Senority aumentarExperiencia();
    public abstract void aumentarEnergia(Energia energia);
}
