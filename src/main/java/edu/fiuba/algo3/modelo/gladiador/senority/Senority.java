package edu.fiuba.algo3.modelo.gladiador.senority;

import edu.fiuba.algo3.controladores.observers.ObservadorSenority;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.senority.states.NovatoState;
import edu.fiuba.algo3.modelo.gladiador.senority.states.SenorityState;

public class Senority {

    private SenorityState estado;

    public Senority() {
        this.estado = new NovatoState(this);
    }

    public void aumentarExperiencia() {
        this.estado = this.estado.aumentarExperiencia();
    }

    public void aumentarEnergia(Energia energia) {
        this.estado.aumentarEnergia(energia);
    }

    @Override
    public String toString() {
        return estado.toString();
    }

    // TODO: a analizar si esto no debe ser parte de un interface observable
    public void agregarObservador(ObservadorSenority observadorSenority) {
        this.estado.agregarObservador(observadorSenority);
    }
}
