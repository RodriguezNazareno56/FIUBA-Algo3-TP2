package edu.fiuba.algo3.modelo.gladiador.senority.states;

import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;

public class SeniorState extends SenorityState {

    public SeniorState(Senority senority) {
        super(senority, 12);
    }

    @Override
    public SenorityState aumentarExperiencia(){
        experiencia += 1;
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia){
        energia.aumentarEnergia(new Energia(10));
    }

    @Override
    public String toString() {
        return "Senior";
    }
}
