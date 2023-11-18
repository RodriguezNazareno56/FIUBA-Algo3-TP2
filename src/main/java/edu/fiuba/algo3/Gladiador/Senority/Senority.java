package edu.fiuba.algo3.Gladiador.Senority;

import edu.fiuba.algo3.Gladiador.Energia;

public abstract class Senority {
    int experiencia;
    public abstract Senority aumentarExperiencia();
    public abstract void aumentarEnergia(Energia energia);
}
