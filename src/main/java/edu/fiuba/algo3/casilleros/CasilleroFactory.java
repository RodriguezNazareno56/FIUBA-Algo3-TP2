package edu.fiuba.algo3.casilleros;

public class Tablero {

    public Casillero inicializarTablero(int cantidad) {
        // TODO: fiero fiero. Al final del dia es como armar una lista doblemente enlazada de cansilleros,
        //  cada uno conoce su proximo y su anterior

        Casillero casillero = new Casillero(0); // Casillero Inicial
        // Creo secuencialmente cada casillero pasandole su casilleroAnterior por parametro
        for (int i = 1; i < cantidad; i++) {
            casillero = new Casillero(i, casillero);
        }

        // casillero es ahora el casillero Final
        // A cada casillero le pido su anterior y a este (anterior) le seteo casillero como proximo
        for (int i = (cantidad-1); i > 0; i--) {
            Casillero casilleroAnterior = casillero.anterior();
            casilleroAnterior.setProximo(casillero);
            casillero = casilleroAnterior;
        }

        // casillero es ahora el Inicial
        return casillero;
    }
}
