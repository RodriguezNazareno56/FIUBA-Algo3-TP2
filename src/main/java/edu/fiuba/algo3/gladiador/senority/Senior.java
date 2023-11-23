package edu.fiuba.algo3.gladiador.senority;

import edu.fiuba.algo3.gladiador.Energia;

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
