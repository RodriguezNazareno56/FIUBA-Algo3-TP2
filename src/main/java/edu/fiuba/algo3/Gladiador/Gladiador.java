package edu.fiuba.algo3.Gladiador;

import edu.fiuba.algo3.Casillero;
import edu.fiuba.algo3.Concecuencias.FieraSalvaje;
import edu.fiuba.algo3.Equipamientos.Equipamiento;
import edu.fiuba.algo3.MovimientoExeption;
import edu.fiuba.algo3.Gladiador.Senority.Senority;

public class Gladiador {

    private Energia energia;
    private Equipamiento equipamiento;
    private Casillero casillero;
    private Senority senority;

    public Gladiador(Energia energia, Equipamiento equipamiento, Casillero casillero, Senority senority) {
        this.energia = energia;
        this.equipamiento = equipamiento;
        this.casillero = casillero;
        this.senority = senority;
    }

    public int getEnergia() {
        return energia.getValor();
    }

    public Equipamiento getEquipamiento() {
        return equipamiento;
    }

    public int getPosicion() {
        return this.casillero.getPosicion();
    }

    public void mover() throws MovimientoExeption {
        if (this.getEnergia() == 0) {
            throw new MovimientoExeption("El gladiador no se puede mover sin energia");
        }
        this.senority.aumentarEnergia(energia);
        this.senority = this.senority.aumentarExperiencia();
    }

    public void comer(Energia energia) {
        this.energia.aumentarEnergia(energia);
    }

    public void incrementarEquipamiento() {
        this.equipamiento = this.equipamiento.incrementar();
    }

    public void recibirAtaque(FieraSalvaje fieraSalvaje) {
        this.energia.disminuirEnergia(this.defenderse(fieraSalvaje));
    }

    /**
     * Utiliza el equipamiento de gladiador para disipar el ataque de acuerdo al daño que la fiera genere frente al mismo
     * @param fieraSalvaje
     * @return Energia por el valor del daño
     */
    private Energia defenderse(FieraSalvaje fieraSalvaje) {
        return this.equipamiento.disiparAtaque(fieraSalvaje);
    }
}
