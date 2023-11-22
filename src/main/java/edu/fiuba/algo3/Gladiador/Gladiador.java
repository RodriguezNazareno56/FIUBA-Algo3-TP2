package edu.fiuba.algo3.Gladiador;

import edu.fiuba.algo3.Concecuencias.Consecuencia;
import edu.fiuba.algo3.Concecuencias.Enemigo;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.MovimientoException;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import edu.fiuba.algo3.MovimientoPausadoExeption;
import edu.fiuba.algo3.casilleros.ICasillero;

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

    public Equipamiento obtenerEquipamiento() {
        return equipamiento;
    }

    public int getPosicion() {
        return this.casillero.getPosicion();
    }

    public void retroceder() throws MovimientoException {
        try {
            this.casillero = casillero.anterior();
        } catch (Exception e) {
            throw new MovimientoException("Gladiador: Movimiento invalido");
        }
    }

    public void avanzar() throws MovimientoException, MovimientoPausadoExeption {
        if (this.getEnergia() <= 0) {
            throw new MovimientoException("El gladiador no se puede mover sin energia");
        }
        if(!this.estaHabilitadoParaMover) throw new MovimientoPausadoExeption("El gladiador esta pausado para mover en este turno");

        this.senority.aumentarEnergia(energia);
        this.senority = this.senority.aumentarExperiencia();
    }

    // TODO: Eliminar el otro
    public void avanzar(int cantidadDePosiciones) throws MovimientoException, MovimientoPausadoExeption, TriunfoException {
        if (this.getEnergia() <= 0) {
            throw new MovimientoException("El gladiador no se puede mover sin energia");
        }
        if(!this.estaHabilitadoParaMover) throw new MovimientoPausadoExeption("El gladiador esta pausado para mover en este turno");

        this.senority.aumentarEnergia(energia);
        this.senority = this.senority.aumentarExperiencia();

        this.casillero = casillero.proximoEnNPosiciones(cantidadDePosiciones);
        this.casillero.afectarGladiadorConConsecuencia(this);
    }

    public void retroceder(int cantidadDePosiciones) {
        this.casillero = casillero.anteriorEnNPosiciones(cantidadDePosiciones);
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

    public void recibirConsecuencia(Consecuencia consecuencia) throws Exception {
        consecuencia.afectarGladiador(this);
    }

    public void recibirAtaque(Enemigo enemigo) {
        this.energia.disminuirEnergia(this.defenderse(enemigo));
    }
    public void enojar() {
        this.pausarMovimiento();
    }


    /**
     * El gladiador utiliza su equipamiento para disipar el ataque de acuerdo al daño que la fiera genere ante al mismo.
     * @param enemigo
     * @return Energia por el valor del daño
     */
    private Energia defenderse(Enemigo enemigo) {
        return enemigo.atacarATravesDelEquipamiento(this.equipamiento);
    }

    public void pausarMovimiento(){
        this.estaHabilitadoParaMover = false;
    }

    public void triunfar() throws TriunfoException {
        // El ultimo equipamiento (llave) al incrementarse se retorna asi mismo.
        if (equipamiento == equipamiento.incrementar()) {
            throw new TriunfoException("Campeon");
        } else {
            this.retroceder(casillero.getPosicion()/2);
        }
    }
}
