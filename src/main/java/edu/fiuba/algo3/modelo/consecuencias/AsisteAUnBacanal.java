package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.constantes.Constantes;
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class AsisteAUnBacanal extends Consecuencia {

    private Dado dado;
    final int CANTIDAD_DE_PUNTOS = Constantes.CANTIDAD_DE_PUNTOS_PERDIDOS_POR_COPA_DE_VINO_EN_BACANAL;

    public AsisteAUnBacanal(Dado dado){
        this.dado = dado;
    }

    public AsisteAUnBacanal(){}

    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.tomarCopasDeVino(new Energia(this.cantidadDeEnergiaPorCopasDeVino()));
    }

    private int cantidadDeEnergiaPorCopasDeVino(){
        int cantidadDeTragos = this.dado.tirarDado();
        return CANTIDAD_DE_PUNTOS * cantidadDeTragos;
    }

    @Override
    public String toString() {
        return "Asiste a un Bacanal";
    }
}
