package edu.fiuba.algo3.modelo.gladiador.senority.states;

import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;

public class NovatoState extends SenorityState {

    public NovatoState(Senority senority) {
        super(senority, 0);
    }

    @Override
    public SenorityState aumentarExperiencia() {
        experiencia += 1;
        if (experiencia == 8) {
            notificarCambioDeSenority();
            SemiSeniorState semiSeniorState = new SemiSeniorState(this.senority);
            transferirObservadoresA(semiSeniorState);
            return semiSeniorState;
        }
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia){
        energia.aumentarEnergia(new Energia(0));
    }

    @Override
    public String toString() {
        return "Novato";
    }
}
