package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Controladores.observers.ObservableDado;
import edu.fiuba.algo3.Controladores.observers.ObservadorDado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Random;

public class Dado implements ObservableDado {

    private ArrayList<ObservadorDado> observadores;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Dado() {
        this.observadores = new ArrayList<>();
    }

    public int tirarDado(){
        Random random = new Random();
        int valorDelDado = random.nextInt(6) + 1;
        logger.info("El valor del dado es " + valorDelDado); // TODO: eliminar
        notificarObservadores(valorDelDado);
        return valorDelDado;
    }

    @Override
    public void notificarObservadores(int valorDelDado) {
        for(ObservadorDado observador : observadores) {
            observador.actualizar(valorDelDado);
        }
    }

    @Override
    public void agregarObservador(ObservadorDado observador) {
        this.observadores.add(observador);
    }
}
