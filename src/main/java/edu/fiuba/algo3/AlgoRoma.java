package edu.fiuba.algo3;

public class AlgoRoma {

    private int cantidadDeRondas = 0;

    public void jugarRonda() throws FinDelJuego{

        if( cantidadDeRondas == 30 ){

            throw new FinDelJuego( "Fin del Juego: Se alcanzo el numero maximo de rondas");
        }

        cantidadDeRondas++;

    }

}
