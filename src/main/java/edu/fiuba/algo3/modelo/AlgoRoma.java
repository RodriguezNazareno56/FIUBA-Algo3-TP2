package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.*;
import edu.fiuba.algo3.modelo.gladiador.exepciones.MovimientoException;
import edu.fiuba.algo3.modelo.gladiador.exepciones.MovimientoPausadoExeption;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class AlgoRoma implements ObservadorGladiador, Observable{

    private final Logger logger;

    private int cantidadDeRondas = 0;

    private final ArrayList<Gladiador> gladiadores;

    private final Stack<Gladiador> gladiadoresEnEspera;

    private Mapa mapa;

    private final int MAX_CANTIDAD_GLADIADORES = 6;

    private boolean juegoEnCurso;

    private final MapaService mapaService;

    private final Dado dado;

    private final ArrayList<Observador> observadores;

    // TODO: el mapaService debe ser inyectado aca tambien?
    public AlgoRoma(MapaService mapaService, Dado dado, Logger logger) {
        this.logger = logger;

        this.gladiadores = new ArrayList<>();
        this.gladiadoresEnEspera = new Stack<>();
        this.juegoEnCurso = false;

        this.mapaService = mapaService;
        this.dado = dado;

        this.observadores = new ArrayList<Observador>();

        //fabricar mapa con json
        try {
            cargarMapa();
        } catch (JsonFormatoInvalidoException e) {
            // TODO: hasta donde se propagan la exepciones o en que lugar las capturamos para visulizar un mensaje?
        }
    }

    private void cargarMapa() throws JsonFormatoInvalidoException {
        this.mapa = mapaService.cargarMapa();
    }

    public void agregarGladiador(String nombreGladiador){
        if(juegoEnCurso){
            throw new JuegoEnCursoException("No se pueden agregar gladiadores en un juego en curso");
        }

        if( gladiadores.size() < MAX_CANTIDAD_GLADIADORES){
            Gladiador gladiador = new Gladiador(new Energia(20), new SinEquipamiento(), new Senority(), this.logger);
            gladiador.setNombre(nombreGladiador);
            gladiador.subscribir(this);
            this.gladiadores.add(gladiador);
            System.out.println(gladiador.getNombre());


        }
        else{
            throw new MaximoGladiadoresException("No se pueden agregar mas gladiadores");
        }

    }

    public void inicializarJuego(){
        //post: no se puede inicializar un juego con menos de dos gladiadores, se lanza una excepcion
        this.juegoEnCurso = true;

        Collections.shuffle(gladiadores);
        gladiadoresEnEspera.addAll(gladiadores);
        notificarOrdenDeTurno();
        notificarFormaDeMapa();

        // TODO: no se si aca esta bien. pero al mapa hay que cargarle los gladiadores
        this.mapa.setGladiadores(gladiadores);
        this.logger.info("Juego inicilizado");
    }

    public void jugarTurno() throws Exception {
        //pre: el juego debe estar inicializado
        //post: si el juego no esta inicializado se lanza una excepcion JuegoNoIniciadoException
        //post: se juega un turno del juego
        //post: si se alcanzo el maximo de rondas se lanza una excepcion
        if( !juegoEnCurso ){
            throw new JuegoNoIniciadoException("El juego no esta inicializado");
        }
        if( gladiadoresEnEspera.isEmpty()){
            //la primera ronda se inicio en inicializarJuego
            if( this.cantidadDeRondas < 29 ){
                this.cantidadDeRondas++;
                this.gladiadoresEnEspera.addAll(gladiadores);
            }
            else{
                notificarMaximoDeRondasAlcanzado();
                logger.info("Se alcanzo el numero maximo de rondas");
                throw new FinDelJuegoException( "Se alcanzo el numero maximo de rondas");
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
        return this.dado.tirarDado();
    }

    public void setMapa(Mapa mapa){
        this.mapa = mapa;
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
    private void notificarTurnoPerdido(Gladiador gladiador) throws Exception {
        // notificar a la vista que el gladiador perdio el turno
        // TODO: a finalidad de testear arrojo exepcion
        throw new Exception();
    }

    private void notificarFormaDeMapa(){
        // notificar a la vista la forma del mapa
    }

    public ArrayList<Gladiador> getGladiadores() {
        return gladiadores;
    }

    public Mapa getMapa(){
        return this.mapa;
    }

    public int cantidadDeGladiadores(){
        return this.gladiadores.size();
    }


    @Override
    public void notificarTriunfo(Gladiador gladiador) throws FinDelJuegoException {
        this.logger.info(gladiador + " ha triunfado!!!");
        this.juegoEnCurso = false;
        throw new FinDelJuegoException(gladiador + " ha triunfado !!");
    }



    @Override
    public void agregarObservador(Observador observador){

        this.observadores.add(observador);

    }
    public void notificarAObservadores(){

        observadores.stream().forEach(observador -> {
            observador.actualizar();
        });

    }





}
