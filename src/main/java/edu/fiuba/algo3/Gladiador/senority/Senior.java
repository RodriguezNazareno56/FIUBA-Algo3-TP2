package edu.fiuba.algo3.Gladiador.senority;

import edu.fiuba.algo3.Gladiador.Energia;

public class Senior extends Senority {

    public Senior(){ this.experiencia = 12; }

    @Override
    public Senority aumentarExperiencia(){
        experiencia += 1;
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia){
        energia.aumentarEnergia(new Energia(10));
    }


}
