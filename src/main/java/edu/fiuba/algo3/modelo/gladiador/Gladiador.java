package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.controladores.observers.ObservableEquipamiento;
import edu.fiuba.algo3.controladores.observers.ObservableGladiador;
import edu.fiuba.algo3.controladores.observers.ObservadorEquipamiento;
import edu.fiuba.algo3.controladores.observers.ObservadorGladiador;
import edu.fiuba.algo3.modelo.FinDelJuegoException;
import edu.fiuba.algo3.modelo.NombreInvalidoException;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.modelo.consecuencias.Enemigo;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.gladiador.exepciones.MovimientoException;
import edu.fiuba.algo3.modelo.gladiador.exepciones.MovimientoPausadoExeption;
import edu.fiuba.algo3.modelo.gladiador.exepciones.TriunfoNoPosibleException;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import org.slf4j.Logger;

import java.util.ArrayList;

public class Gladiador implements ObservableGladiador, ObservableEquipamiento {
    private Logger logger;

    private String nombre;
    private Energia energia;
    private Equipamiento equipamiento;
    private Senority senority;
    private ArrayList<ObservadorGladiador> observadores;
    private ArrayList<ObservadorEquipamiento> observadoresEquipamiento;

    private boolean estaHabilitadoParaMover;

    public Gladiador(String nombre, Energia energia, Equipamiento equipamiento, Senority senority, Logger logger) throws NombreInvalidoException {
        if (nombre.length() < 4) {
            throw new NombreInvalidoException("El nombre debe poseer al menos 4 caracteres");
        }
        this.nombre = nombre;
        this.energia = energia;
        this.equipamiento = equipamiento;
        this.senority = senority;
        this.logger = logger;
        this.estaHabilitadoParaMover = true;
        this.observadores = new ArrayList<ObservadorGladiador>();
        this.observadoresEquipamiento = new ArrayList<>();
    }

    public Energia getEnergia() {
        // Retorna una copia de la energia que posee
        return new Energia(this.energia.getValor());
    }

    public void avanzar() throws MovimientoException, MovimientoPausadoExeption {
        if (this.energia.isAgotada()) {
            logger.info(this + " se encuentra sin energia para moverse, para el siguiente turno se repondran 5 puntos");
            this.energia.aumentarEnergia(new Energia(5));
            throw new MovimientoException("El gladiador no se puede mover sin energia");
        }
        if(!this.estaHabilitadoParaMover) {
            logger.info(this + " se encuentra se encuentra lesionado, podra moverse en el proximo turno");
            this.estaHabilitadoParaMover = true;
            throw new MovimientoPausadoExeption("El gladiador esta pausado para mover en este turno");
        }

        this.senority.aumentarEnergia(energia);
        this.senority.aumentarExperiencia();
    }

    public void recibirConsecuencia(IConsecuencia consecuencia) throws Exception {
        consecuencia.afectarGladiador(this);
    }

    public void comer(Energia energia) {
        this.energia.aumentarEnergia(energia);
        logger.info(this + " come incrementando su energia en " + energia + " quedando en " + this.energia);
    }

    public void tomarCopasDeVino(Energia energia){
        this.energia.disminuirEnergia(energia);
        logger.info(this + " se emborracha perdiendo energia en " + energia + " quedando en " + this.energia);
    }

    public void incrementarEquipamiento() {
        this.equipamiento = this.equipamiento.incrementar();
        logger.info(this + " incrementa equipamiento a: " + this.equipamiento.toString());
        this.notificarObservadoresEquipamiento();
    }

    public void recibirAtaque(Enemigo enemigo) {
        Energia danioTrasDefenderse = this.defenderse(enemigo);
        this.energia.disminuirEnergia(danioTrasDefenderse);
        logger.info(this + " recibe el ataque de " + enemigo + " disminuye su energia en " + danioTrasDefenderse + " quedando con " + energia);
    }

    private Energia defenderse(Enemigo enemigo) {
        return enemigo.atacarATravesDelEquipamiento(this.equipamiento);
    }

    public void enojar() {
        this.pausarMovimiento();
        logger.info(this + " sufre una lesion. No podra moverse en el siguiente turno");
    }

    public void pausarMovimiento(){
        this.estaHabilitadoParaMover = false;
    }

    public void triunfar() throws TriunfoNoPosibleException, FinDelJuegoException {
        if (equipamiento != equipamiento.incrementar()) {
            throw new TriunfoNoPosibleException("El jugador no posee el equipamiento requerido");
        }
        this.notificarTriunfoObservadores();
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return "Gladiador " + senority + " " + nombre;
    }

    @Override
    public void notificarTriunfoObservadores() throws FinDelJuegoException {
        for (ObservadorGladiador observador : this.observadores) {
            observador.notificarTriunfo(this);
        }
    }

    @Override
    public void subscribir(ObservadorGladiador observadorGladiador) {
        this.observadores.add(observadorGladiador);
    }


    @Override
    public void notificarObservadoresEquipamiento() {
        for(ObservadorEquipamiento observador : observadoresEquipamiento) {
            observador.notificarActualizacionEquipamiento();
        }
    }

    @Override
    public void agregarObservadorEquipamiento(ObservadorEquipamiento observadorEquipamiento) {
        this.observadoresEquipamiento.add(observadorEquipamiento);
    }
}
