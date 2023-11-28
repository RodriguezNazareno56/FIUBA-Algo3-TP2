package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.consecuencias.Consecuencia;
import edu.fiuba.algo3.modelo.consecuencias.Enemigo;
import edu.fiuba.algo3.modelo.equipamientos.Equipamiento;
import edu.fiuba.algo3.modelo.MovimientoException;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.modelo.MovimientoPausadoExeption;

public class Gladiador {

    private Energia energia;
    private Equipamiento equipamiento;
    private Senority senority;

    private boolean estaHabilitadoParaMover;

    public Gladiador(Energia energia, Equipamiento equipamiento, Senority senority) {
        this.energia = energia;
        this.equipamiento = equipamiento;
        this.senority = senority;
        this.estaHabilitadoParaMover = true;
    }

    public Energia getEnergia() {
        // Retorna una copia de la energia que posee
        return new Energia(this.energia.getValor());
    }

    // TODO: se puede eliminar mirar issue #87
    public Equipamiento obtenerEquipamiento() {
        return equipamiento;
    }


    public void avanzar() throws MovimientoException, MovimientoPausadoExeption {
        if (this.energia.isAgotada()) {
            throw new MovimientoException("El gladiador no se puede mover sin energia");
        }
        if(!this.estaHabilitadoParaMover) {
            this.estaHabilitadoParaMover = true;
            throw new MovimientoPausadoExeption("El gladiador esta pausado para mover en este turno");
        }

        this.senority.aumentarEnergia(energia);
        this.senority.aumentarExperiencia();
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

    public void triunfar() throws TriunfoException {
        if (equipamiento != equipamiento.incrementar()) {
            throw new TriunfoException("El jugador no posee el equipamiento requerido");
        }
    }
}
