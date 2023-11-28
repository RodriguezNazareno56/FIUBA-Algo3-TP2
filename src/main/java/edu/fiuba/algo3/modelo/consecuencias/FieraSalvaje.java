package edu.fiuba.algo3.modelo.consecuencias;

import edu.fiuba.algo3.modelo.equipamientos.*;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class FieraSalvaje implements Consecuencia, Enemigo {
    @Override
    public void afectarGladiador(Gladiador gladiador) {
        gladiador.recibirAtaque(this);
    }

    @Override
    public Energia atacarATravesDelEquipamiento(Equipamiento equipamiento) {
        return equipamiento.disiparAtaque(this);
    }

    @Override
    public Energia atacarContraEquipado(SinEquipamiento sinEquipamiento) {
        return new Energia(20);
    }

    @Override
    public Energia atacarContraEquipado(Casco casco) {
        return new Energia(15);
    }

    @Override
    public Energia atacarContraEquipado(Armadura armadura) {
        return new Energia(10);
    }

    @Override
    public Energia atacarContraEquipado(EscudoYEspada escudoYEspada) {
        return new Energia(2);
    }

    @Override
    public Energia atacarContraEquipado(Llave llave) {
        return new Energia(0);
    }
}