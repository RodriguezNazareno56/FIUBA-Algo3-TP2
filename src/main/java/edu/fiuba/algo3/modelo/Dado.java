package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dado {

    public int tirarDado(){
        Random random = new Random();

        return random.nextInt(6) + 1;
    }
}
