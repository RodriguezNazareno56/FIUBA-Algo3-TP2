package edu.fiuba.algo3.vista.equipamientos;

import javafx.scene.layout.GridPane;

public class EquipamientosPanel extends GridPane {

    public EquipamientosPanel() {
        EquipamientoBox boxCasco = new EquipamientoBox(new Casco());
        this.add(boxCasco, 0, 0);

        EquipamientoBox boxArmadura = new EquipamientoBox(new Armadura());
        this.add(boxArmadura, 1, 0);

        EquipamientoBox boxEscudoYEspada = new EquipamientoBox(new EscudoYEspada());
        this.add(boxEscudoYEspada, 2, 0);

        EquipamientoBox boxLlave = new EquipamientoBox(new Llave());
        this.add(boxLlave, 3, 0);

        boxCasco.visibilizarEquipamiento();
        boxArmadura.visibilizarEquipamiento();
    }
}
