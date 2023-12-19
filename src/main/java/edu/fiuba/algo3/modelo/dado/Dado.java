package edu.fiuba.algo3.modelo.dado;

import edu.fiuba.algo3.controladores.observers.DadoObservable;
import edu.fiuba.algo3.controladores.observers.DadoObservador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Random;

public class Dado implements DadoObservable {

    private ArrayList<DadoObservador> observadores;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Dado() {
        this.observadores = new ArrayList<>();
    }

    public int tirarDado(){
        Random random = new Random();
        int valorDelDado = random.nextInt(6) + 1;
        logger.info("El valor del dado es " + valorDelDado);
        notificarObservadores(valorDelDado);
        return valorDelDado;
    }

    @Override
    public void notificarObservadores(int valorDelDado) {
        for(DadoObservador observador : observadores) {
            observador.actualizar(valorDelDado);
        }
    }

    @Override
    public void agregarObservador(DadoObservador observador) {
        this.observadores.add(observador);
    }
}
