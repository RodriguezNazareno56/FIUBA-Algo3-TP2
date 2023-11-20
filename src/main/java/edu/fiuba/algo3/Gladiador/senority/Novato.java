package edu.fiuba.algo3.Gladiador.senority;

import edu.fiuba.algo3.Gladiador.Energia;

public class Novato extends Senority {

    public Novato() {
        this.experiencia = 0;
    }

    @Override
    public Senority aumentarExperiencia() {
        experiencia += 1;
        if (experiencia == 8) {
            return new SemiSenior();
        }
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia){
        energia.aumentarEnergia(new Energia(0));
    }
}
