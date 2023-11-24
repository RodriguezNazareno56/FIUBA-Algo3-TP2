package edu.fiuba.algo3.modelo.gladiador.senority.states;

import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;

public class SemiSeniorState extends SenorityState {

    public SemiSeniorState(Senority senority) {
        super(senority, 8);
    }

    @Override
    public SenorityState aumentarExperiencia() {
        experiencia += 1;
        if (experiencia == 12) {
            return new SeniorState(this.senority);
        }
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia){
        energia.aumentarEnergia(new Energia(5));
    }
}
