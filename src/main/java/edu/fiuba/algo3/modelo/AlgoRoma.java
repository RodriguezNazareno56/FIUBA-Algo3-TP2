package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.controladores.observers.ObservableAlgoRoma;
import edu.fiuba.algo3.controladores.observers.ObservadorGladiador;
import edu.fiuba.algo3.data_acceso.MapaService;
import edu.fiuba.algo3.data_acceso.data_mappers.JsonFormatoInvalidoException;
import edu.fiuba.algo3.modelo.algoRomaEstado.EstadoJuego;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoEnCurso;
import edu.fiuba.algo3.modelo.algoRomaEstado.JuegoSinIniciar;
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.equipamientos.SinEquipamiento;
import edu.fiuba.algo3.modelo.excepciones.*;
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

    private final Dado dado;

    private int turnosJugados = 0;


    public AlgoRoma(MapaService mapaService, Dado dado, Logger logger) {
        super();
        this.logger = logger;

        this.gladiadores = new ArrayList<>();
        this.gladiadoresEnEspera = new LinkedList<>();

        this.estadoJuego = new JuegoSinIniciar(this, this.logger);

        this.dado = dado;

        try {
            this.mapa = mapaService.cargarMapa();
        } catch (JsonFormatoInvalidoException e) {
            this.logger.info("Error al procesar el JSON: ",e);
        }
    }

    public void agregarGladiador(String nombreGladiador) throws MaximoGladiadoresException,
            JuegoEnCursoException, FinDelJuegoException, NombreInvalidoException {
        Gladiador gladiador = new Gladiador(nombreGladiador, new Energia(ENERGIA_INICIAL_GLADIADOR), new SinEquipamiento(), new Senority(), this.logger);
        this.estadoJuego.agregarGladiador(gladiador);

    }

    public void agregarGladiador(Gladiador gladiador) throws MaximoGladiadoresException,
            JuegoEnCursoException, FinDelJuegoException, NombreInvalidoException {
        this.estadoJuego.agregarGladiador(gladiador);
    }

    public void agregarNuevoGladiador(Gladiador gladiador) {
        this.gladiadores.add(gladiador);    
        gladiador.subscribir(this);
        this.notificarNuevoGladiador();
        sortearOrdenDeLosJugadoresEnElJuego()
    }

    public void jugarTurno() throws Exception {
        this.estadoJuego.jugarTurno();
    }

    public void jugarTurnoSegunEstado(JuegoSinIniciar juegoSinIniciar) throws Exception {
        this.mapa.setGladiadores(gladiadores);
        avanzarGladiador();
    }
    public void jugarTurnoSegunEstado(JuegoEnCurso juegoEnCurso) throws Exception {
        avanzarGladiador();
    }

    private void avanzarGladiador() throws Exception {
        notificarNuevoTurno();
        turnosJugados++;

        Gladiador gladiador = gladiadoresEnEspera.poll();
        gladiadoresEnEspera.add(gladiador);

        logger.info("~~~~~~ Turno para el jugador: {} ~~~~~~", gladiador);
        
        int resultadoDado = this.dado.tirarDado();

        try{
            mapa.avanzarNPosicionesGladiador(gladiador, resultadoDado);
        }
        catch (MovimientoException e){
            throw new NotificarTurnoPerdidoException("Turno perdido");
        }
    }

    public void setMapa(Mapa mapa){
        this.mapa = mapa;
    }

    public int getRondasJugadas() {
        if (gladiadores.isEmpty()){
            return 0;
        }
        return turnosJugados / gladiadores.size();
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

    private void sortearOrdenDeLosJugadoresEnElJuego() {
        Random random = new Random(gladiadores.size());
        int indexGladiadorSorteado = 0;
        if (! gladiadores.isEmpty()) {
            indexGladiadorSorteado = random.nextInt(gladiadores.size());
        }

        gladiadoresEnEspera.clear();
        // Encolo todos los gladiadores
        gladiadoresEnEspera.addAll(gladiadores);

        // Desencolo y vuelvo a encolar los gladiadores previos al gladiador sorteado de modo que este quede primero
        for (int i = 0; i < indexGladiadorSorteado; i++) {
            Gladiador gladiador = gladiadoresEnEspera.poll();
            gladiadoresEnEspera.offer(gladiador);
        }
    }

    public ArrayList<String> getNombresGladiadoresSegunOrdenEnRonda(){
        ArrayList<String> nombresEnOrden = new ArrayList<>();
        for (Gladiador gladiador: gladiadoresEnEspera ) {
            nombresEnOrden.add(gladiador.getNombre());
        }
        return nombresEnOrden;
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
