package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;
import edu.fiuba.algo3.modelo.consecuencias.Enemigo;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.MovimientoPausadoExeption;
import edu.fiuba.algo3.modelo.casilleros.ICasillero;

public class Gladiador {

    private Energia energia;
    private Equipamiento equipamiento;
    private ICasillero casillero;
    private Senority senority;

    private boolean estaHabilitadoParaMover;

    public Gladiador(Energia energia, Equipamiento equipamiento, ICasillero casillero, Senority senority) {
        this.energia = energia;
        this.equipamiento = equipamiento;
        this.casillero = casillero;
        this.senority = senority;
        this.estaHabilitadoParaMover = true;
    }

    public int getEnergia() {
        return energia.getValor();
    }

    // TODO: se puede eliminar mirar issue #87
    public Equipamiento obtenerEquipamiento() {
        return equipamiento;
    }

    public int getPosicion() {
        return this.casillero.getPosicion();
    }

    public void avanzar(int cantidadDePosiciones) throws MovimientoException, MovimientoPausadoExeption, TriunfoException {
        if (this.getEnergia() <= 0) {
            throw new MovimientoException("El gladiador no se puede mover sin energia");
        }
        if(!this.estaHabilitadoParaMover) throw new MovimientoPausadoExeption("El gladiador esta pausado para mover en este turno");

        this.senority.aumentarEnergia(energia);
//        this.senority = this.senority.aumentarExperiencia();
        this.senority.aumentarExperiencia();

        this.casillero = casillero.proximoEnNPosiciones(cantidadDePosiciones);
        this.casillero.afectarGladiadorConConsecuencia(this);
    }

    public void retroceder(int cantidadDePosiciones) throws MovimientoException {
        // Si al retroceder permanece en el mismo casillero significa que esta en el Inicio y no puede retroceder.
        if (casillero == casillero.anteriorEnNPosiciones(cantidadDePosiciones)) {
            throw new MovimientoException("Gladiador: Movimiento invalido");
        }
        this.casillero = casillero.anteriorEnNPosiciones(cantidadDePosiciones);
    }

    public void recibirConsecuencia(Consecuencia consecuencia) throws Exception {
        consecuencia.afectarGladiador(this);
    }


    public void comer(Energia energia) {
        this.energia.aumentarEnergia(energia);
    }

    public void tomarCopasDeVino(Energia energia){
        this.energia.disminuirEnergia(energia);
    }

    public void incrementarEquipamiento() {
        this.equipamiento = this.equipamiento.incrementar();
    }

    public void recibirAtaque(Enemigo enemigo) {
        this.energia.disminuirEnergia(this.defenderse(enemigo));
    }

    private Energia defenderse(Enemigo enemigo) {
        return enemigo.atacarATravesDelEquipamiento(this.equipamiento);
    }

    public void enojar() {
        this.pausarMovimiento();
    }

    public void pausarMovimiento(){
        this.estaHabilitadoParaMover = false;
    }

    public void triunfar() throws TriunfoException, MovimientoException {
        // El ultimo equipamiento (llave) al incrementarse se retorna asi mismo.
        if (equipamiento == equipamiento.incrementar()) {
            throw new TriunfoException("Campeon");
        } else {
            this.retroceder(casillero.getPosicion()/2);
        }
    }
}
