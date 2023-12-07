package edu.fiuba.algo3.vista.equipamientos;

import edu.fiuba.algo3.controladores.observers.ObservadorEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import javafx.scene.layout.GridPane;

import java.util.ArrayDeque;
import java.util.Deque;

public class EquipamientosPanel extends GridPane implements ObservadorEquipamiento {

    private Deque<EquipamientoBox> equipamientos;

    public EquipamientosPanel() {
        this.equipamientos = new ArrayDeque<>();

        EquipamientoBox boxCasco = new EquipamientoBox(new Casco());
        this.add(boxCasco, 0, 0);
        this.equipamientos.add(boxCasco);

        EquipamientoBox boxArmadura = new EquipamientoBox(new Armadura());
        this.add(boxArmadura, 1, 0);
        this.equipamientos.add(boxArmadura);

        EquipamientoBox boxEscudoYEspada = new EquipamientoBox(new EscudoYEspada());
        this.add(boxEscudoYEspada, 2, 0);
        this.equipamientos.add(boxEscudoYEspada);

        EquipamientoBox boxLlave = new EquipamientoBox(new Llave());
        this.add(boxLlave, 3, 0);
        this.equipamientos.add(boxLlave);

        //boxCasco.visibilizarEquipamiento();
        //boxArmadura.visibilizarEquipamiento();
    }

    public EquipamientosPanel(Gladiador gladiador) {
        this();
        gladiador.agregarObservadorEquipamiento(this);
    }

    @Override
    public void notificarActualizacionEquipamiento() {
        this.mostrarNuevoEquipamiento();
    }

    private void mostrarNuevoEquipamiento() {
        equipamientos.pop().visibilizarEquipamiento();
    }


}
