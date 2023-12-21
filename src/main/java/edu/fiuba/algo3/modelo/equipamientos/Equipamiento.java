package edu.fiuba.algo3.modelo.equipamientos;

import edu.fiuba.algo3.modelo.consecuencias.Enemigo;
import edu.fiuba.algo3.modelo.gladiador.Energia;

public abstract class Equipamiento {
    public abstract Equipamiento incrementar();
    public abstract Energia disiparAtaque(Enemigo enemigo);
}
