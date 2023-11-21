package edu.fiuba.algo3.Gladiador;

import edu.fiuba.algo3.casilleros.Casillero;
import edu.fiuba.algo3.Concecuencias.Consecuencia;
import edu.fiuba.algo3.Concecuencias.Enemigo;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.MovimientoExeption;
import edu.fiuba.algo3.Gladiador.senority.Senority;
import edu.fiuba.algo3.casilleros.ICasillero;

public class Gladiador {

    private Energia energia;
    private Equipamiento equipamiento;
    private ICasillero casillero;
    private Senority senority;

    public Gladiador(Energia energia, Equipamiento equipamiento, Casillero casillero, Senority senority) {
        this.energia = energia;
        this.equipamiento = equipamiento;
        this.casillero = casillero;
        this.senority = senority;
    }

    // TODO: Eliminar el otro
    public Gladiador(Energia energia, Equipamiento equipamiento, ICasillero casillero, Senority senority) {
        this.energia = energia;
        this.equipamiento = equipamiento;
        this.casillero = casillero;
        this.senority = senority;
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
        try {
            this.casillero = casillero.anterior();
        } catch (Exception e) {
            throw new MovimientoExeption("Gladiador: Movimiento invalido");
        }
    }

    public void avanzar() throws MovimientoExeption {
        if (this.getEnergia() == 0) {
            throw new MovimientoExeption("El gladiador no se puede mover sin energia");
        }

        this.senority.aumentarEnergia(energia);
        this.senority = this.senority.aumentarExperiencia();
    }

    // TODO: Eliminar el otro
    public void avanzar(int cantidadDePosiciones) throws MovimientoExeption {
        if (this.getEnergia() == 0) {
            throw new MovimientoExeption("El gladiador no se puede mover sin energia");
        }

        this.senority.aumentarEnergia(energia);
        this.senority = this.senority.aumentarExperiencia();
        this.casillero = casillero.proximoEnNPosiciones(5);
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

    /**
     * El gladiador utiliza su equipamiento para disipar el ataque de acuerdo al daño que la fiera genere ante al mismo.
     * @param enemigo
     * @return Energia por el valor del daño
     */
    private Energia defenderse(Enemigo enemigo) {
        return enemigo.atacarATravesDelEquipamiento(this.equipamiento);
    }
}
