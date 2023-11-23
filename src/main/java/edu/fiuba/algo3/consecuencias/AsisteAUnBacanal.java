package edu.fiuba.algo3.consecuencias;

import edu.fiuba.algo3.gladiador.Energia;
import edu.fiuba.algo3.gladiador.Gladiador;

public class AsisteAUnBacanal implements Consecuencia{
    int cantiadadDeTragos;
    final int CANTIDAD_DE_PUNTOS = 4;

    public AsisteAUnBacanal(int cantiadadDeTragos){
        this.cantiadadDeTragos = cantiadadDeTragos;
    }

    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.tomarCopasDeVino(new Energia(this.cantidadDeEnergiaPorCopasDeVino()));
    }

    private int cantidadDeEnergiaPorCopasDeVino(){
        return CANTIDAD_DE_PUNTOS * this.cantiadadDeTragos;
    }
}
