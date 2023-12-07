package edu.fiuba.algo3.modelo.gladiador.senority.states;

import edu.fiuba.algo3.controladores.observers.ObservableSenorityState;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;

public abstract class SenorityState extends ObservableSenorityState {

    protected int experiencia;
    protected Senority senority;

    public SenorityState(Senority senority, int experiencia) {
        this.senority = senority;
        this.experiencia = experiencia;
    }

    public abstract SenorityState aumentarExperiencia();

    public abstract void aumentarEnergia(Energia energia);
}
