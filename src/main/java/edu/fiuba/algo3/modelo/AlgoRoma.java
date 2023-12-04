package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.controladores.observers.Observable;
import edu.fiuba.algo3.controladores.observers.Observador;
import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.modelo.algoRomaEstado.EstadoJuego;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoEnCurso;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoSinIniciar;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoTerminado;
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
import edu.fiuba.algo3.modelo.constantes.AlgoRomaConstantes;

import static edu.fiuba.algo3.modelo.constantes.AlgoRomaConstantes.*;


public class AlgoRoma implements ObservadorGladiador, Observable {

    private EstadoJuego estadoJuego;

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

        this.estadoJuego = new JuegoSinIniciar(this);

        this.mapaService = mapaService;
        this.dado = dado;

        this.observadores = new ArrayList<>();

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

    public void agregarGladiador(String nombreGladiador) throws FinDelJuegoException {
        this.estadoJuego.agregarGladiador(nombreGladiador);

    }
    public void jugarTurno() throws Exception {
        if( gladiadoresEnEspera.isEmpty()){
            this.cantidadDeRondas++;
            this.gladiadoresEnEspera.addAll(gladiadores);
        }
        this.estadoJuego.jugarTurno();
    }

    public void agregarGladiador(String nombreGladiador, JuegoSinIniciar juegoSinIniciar){
        if( gladiadores.size() < MAX_CANTIDAD_GLADIADORES){
            Gladiador gladiador = new Gladiador(new Energia(ENERGIA_INICIAL_GLADIADOR), new SinEquipamiento(), new Senority(), this.logger);
            gladiador.setNombre(nombreGladiador);
            gladiador.subscribir(this);
            this.gladiadores.add(gladiador);
            System.out.println(gladiador.getNombre());
        }
        else{
            throw new MaximoGladiadoresException("No se pueden agregar mas gladiadores");
        }
    }

    public void agregarGladiador(String nombreGladiador, JuegoEnCurso juegoEnCurso) {
        throw new JuegoEnCursoException("No se pueden agregar gladiadores en un juego en curso");
    }

    public void agregarGladiador(String nombreGladiador, JuegoTerminado juegoTerminado) throws FinDelJuegoException {
        throw new FinDelJuegoException(" No se pueden agregar gladiadores en un juego terminado");
    }

    private void inicializarJuego() throws MinimoGladiadoresException {
        //post: no se puede inicializar un juego con menos de dos gladiadores, se lanza una excepcion
        if( gladiadores.size() < MINIMO_DE_GLADIADORES){
            //cambiar a mínimo o uno que englobe ambos casos
            throw new MinimoGladiadoresException("No se puede inicializar un juego con menos de dos gladiadores");
        }
        this.juegoEnCurso = true;

        Collections.shuffle(gladiadores);


        // TODO: no se si aca esta bien. pero al mapa hay que cargarle los gladiadores
        this.mapa.setGladiadores(gladiadores);
        this.logger.info("Juego inicilizado");

        notificarOrdenDeTurno();
        notificarFormaDeMapa();
    }


    public void jugarTurnoSegunEstado(JuegoSinIniciar juegoSinIniciar) throws Exception {
        //especificar excepcion
        this.inicializarJuego();
        avanzarGladiador();
    }

    public void jugarTurnoSegunEstado(JuegoEnCurso juegoEnCurso) throws Exception {
        avanzarGladiador();
    }

    public void jugarTurnoSegunEstado(JuegoTerminado juegoTerminado) throws FinDelJuegoException {
        if( this.cantidadDeRondas >= MAXIMA_CANTIDAD_DE_RONDAS){
            notificarMaximoDeRondasAlcanzado();
            logger.info("Se alcanzo el numero maximo de rondas");
            throw new FinDelJuegoException("Se alcanzo el numero maximo de rondas");
        }
        //comprobar si el juego termino porque algun gladiador gano
    }

    private void avanzarGladiador() throws Exception, FinDelJuegoException {
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
        this.estadoJuego.agregarTriunfo(gladiador);
        throw new FinDelJuegoException(gladiador + " ha triunfado !!");
    }

    @Override
    public void agregarObservador(Observador observador) {
        this.observadores.add(observador);
    }

    public void notificarAObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar();
        }
    }

    public void setEstadoJuego(EstadoJuego estadoJuego) {
        this.estadoJuego = estadoJuego;
    }
}
