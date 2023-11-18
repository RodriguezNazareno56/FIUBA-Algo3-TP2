package edu.fiuba.algo3.Gladiador.Senority;

import edu.fiuba.algo3.Gladiador.Energia;

public class SemiSenior extends Senority {

    public SemiSenior() {
        this.experiencia = 8;
    }

    @Override
    public Senority aumentarExperiencia() {
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia){
        energia.aumentarEnergia(new Energia(5));
    }
}
