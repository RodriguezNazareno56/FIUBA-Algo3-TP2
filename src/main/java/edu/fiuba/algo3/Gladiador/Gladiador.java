package edu.fiuba.algo3.Gladiador;

import edu.fiuba.algo3.Casillero;
import edu.fiuba.algo3.Concecuencias.Consecuencia;
import edu.fiuba.algo3.Concecuencias.Enemigo;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.MovimientoExeption;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import edu.fiuba.algo3.MovimientoPausadoExeption;

public class Gladiador {

    private Energia energia;
    private Equipamiento equipamiento;
    private Casillero casillero;
    private Senority senority;

    private boolean estaHabilitadoParaMover;

    public Gladiador(Energia energia, Equipamiento equipamiento, Casillero casillero, Senority senority) {
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

    public void retroceder() throws MovimientoExeption{

        if(  casillero.anterior() == null ){
            throw new MovimientoExeption("Gladiador: Movimiento invalido");
        }

        casillero = casillero.anterior();

    }

    public void avanzar() throws MovimientoExeption, MovimientoPausadoExeption {
        if (this.getEnergia() == 0) {
            throw new MovimientoExeption("El gladiador no se puede mover sin energia");
        }
        if(!this.estaHabilitadoParaMover) throw new MovimientoPausadoExeption("El gladiador esta pausado para mover en este turno");

        this.senority.aumentarEnergia(energia);
        this.senority = this.senority.aumentarExperiencia();
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

    public void recibirConsecuencia(Consecuencia consecuencia){
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


}
