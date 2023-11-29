package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class AlgoRoma {

    private int cantidadDeRondas = 0;

    private ArrayList<Gladiador> gladiadores;

    private Stack<Gladiador> gladiadoresEnEspera;

    private Mapa mapa;

    private final int MAX_CANTIDAD_GLADIADORES = 6;

    private boolean juegoEnCurso;

    public AlgoRoma(){
        this.gladiadores = new ArrayList<>();
        this.gladiadoresEnEspera = new Stack<>();
        this.juegoEnCurso = false;

        //fabricar mapa con json
    }

    public void agregarGladiador(String nombreGladiador){
        if( gladiadores.size() <= MAX_CANTIDAD_GLADIADORES && !juegoEnCurso){
            Gladiador gladiador = new Gladiador(new Energia(20), new SinEquipamiento(), new Senority());
            gladiador.setNombre(nombreGladiador);
            this.gladiadores.add(gladiador);
        }
        else{
            //throw new Exception("No se pueden agregar mas gladiadores");
        }

    }

    public void inicializarJuego(){
        this.juegoEnCurso = true;

        Collections.shuffle(gladiadores);
        gladiadoresEnEspera.addAll(gladiadores);
        notificarOrdenDeTurno();
        notificarFormaDeMapa();
    }

    public void jugarTurno() throws FinDelJuegoException {
        if( !juegoEnCurso ){
            //throw new Exception("El juego no esta inicializado");
        }
        if( gladiadoresEnEspera.isEmpty()){
            if( this.cantidadDeRondas < 30 ){
                this.cantidadDeRondas++;
                this.gladiadoresEnEspera.addAll(gladiadores);
            }
            else{
                notificarMaximoDeRondasAlcanzado();
                throw new FinDelJuegoException( "Fin del Juego: Se alcanzo el numero maximo de rondas");
            }
        }
        Gladiador gladiador = gladiadoresEnEspera.pop();
        int resultadoDado = tirarDado();

        try{
            mapa.avanzarNPosicionesGladiador(gladiador, resultadoDado);
            notificarResultadoDado(gladiador, resultadoDado);
        }
        catch (MovimientoException | MovimientoPausadoExeption e){
            notificarTurnoPerdido(gladiador);
        }

    }
    private int tirarDado(){
        Random random = new Random();

        return random.nextInt(6) + 1;
    }

    public void jugarRonda() throws FinDelJuegoException {

        if( cantidadDeRondas == 30 ){

            throw new FinDelJuegoException( "Fin del Juego: Se alcanzo el numero maximo de rondas");
        }

        cantidadDeRondas++;

    }

    public int getCantidadRondas() {
        return cantidadDeRondas;
    }



    private void notificarResultadoDado(Gladiador gladiador, int resultadoDado){
        // notificar a la vista el resultado del dado
    }
    private void notificarMaximoDeRondasAlcanzado(){
        // notificar a la vista que se alcanzo el maximo de rondas
    }

    private void notificarOrdenDeTurno(){
        // notificar a la vista el orden de los gladiadores
    }
    private void notificarTurnoPerdido(Gladiador gladiador){
        // notificar a la vista que el gladiador perdio el turno
    }

    private void notificarFormaDeMapa(){
        // notificar a la vista la forma del mapa
    }
}
