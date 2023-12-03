package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Random;

public class Dado implements Observable  {

    private int ultimoValorArrojado;
    private ArrayList<Observador> observadores;

    public Dado(){
        this.ultimoValorArrojado = 1;
        this.observadores = new ArrayList<Observador>();
    }

    public int tirarDado(){
        Random random = new Random();
        this.ultimoValorArrojado = random.nextInt(6) + 1;
        notificarAObservadores();
        return ultimoValorArrojado;
    }

    public int getUltimoValorArrojado() {
        return ultimoValorArrojado;
    }

    @Override
    public void agregarObservador(Observador observador) {
        this.observadores.add(observador);
    }

    @Override
    public void notificarAObservadores() {
        observadores.stream().forEach(Observador::actualizar);
    }
}
