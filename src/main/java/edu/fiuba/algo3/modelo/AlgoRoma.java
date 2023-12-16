package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.controladores.observers.ObservableAlgoRoma;
import edu.fiuba.algo3.controladores.observers.ObservadorGladiador;
import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.modelo.algoRomaEstado.EstadoJuego;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoEnCurso;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoSinIniciar;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoTerminado;
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.*;
import edu.fiuba.algo3.modelo.gladiador.exepciones.MovimientoException;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.slf4j.Logger;

import java.util.*;

import static edu.fiuba.algo3.modelo.constantes.AlgoRomaConstantes.*;
import static edu.fiuba.algo3.modelo.constantes.GladiadorConstantes.ENERGIA_INICIAL_GLADIADOR;


public class AlgoRoma extends ObservableAlgoRoma implements AlgoRomaModelo, AlgoRomaEstado, ObservadorGladiador {

    private EstadoJuego estadoJuego;

    private final Logger logger;

    private final ArrayList<Gladiador> gladiadores;

    private final Queue<Gladiador> gladiadoresEnEspera;

    private Mapa mapa;

    private final MapaService mapaService;

    private final Dado dado;

    private int rondaActual = 0;


    public AlgoRoma(MapaService mapaService, Dado dado, Logger logger) {
        super();
        this.logger = logger;

        this.gladiadores = new ArrayList<>();
        this.gladiadoresEnEspera = new LinkedList<>();

        this.estadoJuego = new JuegoSinIniciar(this, this.logger);

        this.mapaService = mapaService;
        this.dado = dado;

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

    // TODO: posible a eliminar
    public void agregarGladiador(String nombreGladiador) throws MaximoGladiadoresException,
            JuegoEnCursoException, FinDelJuegoException, NombreInvalidoException {
        Gladiador gladiador = new Gladiador(nombreGladiador, new Energia(ENERGIA_INICIAL_GLADIADOR), new SinEquipamiento(), new Senority(), this.logger);
        this.estadoJuego.agregarGladiador(gladiador);
        gladiador.subscribir(this);
        this.notificarNuevoGladiador();
    }

    public void agregarGladiador(Gladiador gladiador) throws MaximoGladiadoresException,
            JuegoEnCursoException, FinDelJuegoException {
        this.estadoJuego.agregarGladiador(gladiador);
        gladiador.subscribir(this);
        this.notificarNuevoGladiador();
    }

    public void agregarNuevoGladiador(Gladiador gladiador) {
        this.gladiadores.add(gladiador);
    }
    public void jugarTurno() throws Exception {
        if( gladiadoresEnEspera.isEmpty()){
            this.rondaActual++;
            this.gladiadoresEnEspera.addAll(this.getGladiadoresSegunOrdenEnRonda());
        }
        this.estadoJuego.jugarTurno();
    }

    private void inicializarJuego() {
        this.mapa.setGladiadores(gladiadores);
    }

    public void jugarTurnoSegunEstado(JuegoSinIniciar juegoSinIniciar) throws Exception {
        this.inicializarJuego();
        avanzarGladiador();
    }

    public void jugarTurnoSegunEstado(JuegoEnCurso juegoEnCurso) throws Exception {
        avanzarGladiador();
    }

    public void jugarTurnoSegunEstado(JuegoTerminado juegoTerminado) throws FinDelJuegoException {
        if( this.rondaActual >= MAXIMA_CANTIDAD_DE_RONDAS){
            logger.info("Se alcanzo el numero maximo de rondas");
            throw new FinDelJuegoException("Se alcanzo el numero maximo de rondas");
        }
        //comprobar si el juego termino porque algun gladiador gano
    }

    private void avanzarGladiador() throws Exception {
        notificarNuevoTurno();

        Gladiador gladiador = gladiadoresEnEspera.poll();

        logger.info("~~~~~~ Turno para el jugador: " + gladiador + "~~~~~~");
        
        int resultadoDado = this.dado.tirarDado();

        try{
            mapa.avanzarNPosicionesGladiador(gladiador, resultadoDado);
        }
        catch (MovimientoException e){
            notificarTurnoPerdido(gladiador);
        }
    }

    public void setMapa(Mapa mapa){
        this.mapa = mapa;
    }

    public int getRondasJugadas() {
        //una ronda se jugo si no hay mas gladiadores en espera
        if( gladiadoresEnEspera.isEmpty() ){
            return rondaActual;
        }
        return rondaActual-1;
    }

    private void notificarTurnoPerdido(Gladiador gladiador) throws Exception {
        // notificar a la vista que el gladiador perdio el turno
        // TODO: a finalidad de testear arrojo exepcion
        throw new Exception();
    }
    public Mapa getMapa(){
        return this.mapa;
    }

    public int getCantidadDeGladiadores(){
        return this.gladiadores.size();
    }

    @Override
    public void notificarTriunfo(Gladiador gladiador) throws FinDelJuegoException {
        this.logger.info(gladiador + " ha triunfado!!!");
        throw new FinDelJuegoException(gladiador + " ha triunfado !!");
    }

    public void setEstadoJuego(EstadoJuego estadoJuego) {
        this.estadoJuego = estadoJuego;
    }

    public int getMaximaCantidadRondas() {
        return MAXIMA_CANTIDAD_DE_RONDAS;
    }

    public ArrayList<String> getNombresGladiadoresSegunOrdenEnRonda(){
        //si no hay gladiadores agregados devuelve una lista vacia

        ArrayList<String> nombresEnOrden = new ArrayList<>();

        Random random = new Random(gladiadores.size());
        int indicePrimerGladiador;
        try {
            indicePrimerGladiador = random.nextInt(gladiadores.size());
        }
        catch (IllegalArgumentException e){
            indicePrimerGladiador = 0;
        }

        for(int i = indicePrimerGladiador; i<gladiadores.size() ; i++){
            nombresEnOrden.add(gladiadores.get(i).getNombre());
        }
        for( int i=0 ; i<indicePrimerGladiador ; i++){
            nombresEnOrden.add(gladiadores.get(i).getNombre());
        }

        return nombresEnOrden;
    }

    private ArrayList<Gladiador> getGladiadoresSegunOrdenEnRonda(){
        ArrayList<String> nombres = getNombresGladiadoresSegunOrdenEnRonda();

        ArrayList<Gladiador> gladiadoresOrdenados = new ArrayList<>();

        for(String nombre : nombres){
            gladiadoresOrdenados.add(gladiadores.stream()
                    .filter(gladiador -> gladiador.getNombre().equals(nombre) )
                    .findFirst()
                    .orElse(null));
        }
        return gladiadoresOrdenados;
    }

    public ArrayList<String> getNombresGladiadoresSegunOrdenDeIngreso(){
        ArrayList<String> nombres = new ArrayList<>();
        for (Gladiador gladiador : gladiadores) {
            nombres.add(gladiador.getNombre());
        }
        return nombres;
    }

    public int getMinimaCantidadGladiadores() {
        return MINIMA_CANTIDAD_DE_GLADIADORES;
    }

    public int getMaximaCantidadGladiadores() {
        return MAXIMA_CANTIDAD_DE_GLADIADORES;
    }
}
