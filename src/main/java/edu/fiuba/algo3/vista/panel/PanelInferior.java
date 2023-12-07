package edu.fiuba.algo3.vista.panel;

import edu.fiuba.algo3.vista.equipamientos.EquipamientosPanel;
import edu.fiuba.algo3.vista.gladiador.EnergiaVista;
import edu.fiuba.algo3.vista.gladiador.Gladiador;
import edu.fiuba.algo3.vista.gladiador.senority.SenorityVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PanelInferior extends HBox {

    public PanelInferior(Gladiador gladiador, EnergiaVista energia, SenorityVista senority, EquipamientosPanel equipamientosPanel){
        super();
        this.setMaxHeight(20);
        this.setMaxWidth(Double.MAX_VALUE);
        this.setPadding(new Insets(10, 0, 10, 0));
        this.setStyle("-fx-background-color:#323232");
        this.setAlignment(Pos.CENTER);

        this.agregarElementos(gladiador);
        this.agregarElementos(energia);
        this.agregarElementos(senority);
        this.agregarElementos(equipamientosPanel);
    }

    public void agregarElementos(Node node){
        this.setSpacing(50);
        this.getChildren().add(node);
    }
}
