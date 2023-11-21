package edu.fiuba.algo3.casilleros;

public class CasilleroFactory {

    public ICasillero construirCasilleros(int cantidad) {
        // TODO: medio feo. Al final del dia es como armar una lista doblemente enlazada de casilleros,
        //  cada uno conoce su proximo y su anterio
        ICasillero casilleroInicial = new CasilleroInicial(0); // Casillero Inicial
        ICasillero casilleroFinal = this.enlazarCasillerosConSusAnteriores(casilleroInicial, cantidad);

        casilleroInicial = this.enlazarCasillerosConSusProximos(casilleroFinal, cantidad);
        return casilleroInicial;
    }

    private ICasillero enlazarCasillerosConSusAnteriores(ICasillero casillero, int cantidad) {
        // Creo secuencialmente cada casillero pasandole su casilleroAnterior por parametro
        for (int i = 1; i < (cantidad-1); i++) {
            casillero = new Casillero(i, casillero);
        }
        casillero = new CasilleroFinal(cantidad-1, casillero);
        return casillero;
    }

    private ICasillero enlazarCasillerosConSusProximos(ICasillero casillero, int cantidad) {

        try {
            ICasillero casilleroAnterior;
            // A cada casillero le pido su anterior y a este (anterior) le seteo casillero como proximo
            for (int i = (cantidad-1); i > 0; i--) {
                casilleroAnterior = casillero.anterior();
                casilleroAnterior.setProximo(casillero);
                casillero = casilleroAnterior;
            }
        } catch (Exception ignored) {} // El primer casillero no tiene anterior.

        return casillero;
    }
}
