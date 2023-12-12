package edu.fiuba.algo3.vista.paneles_de_visualizacion;

import edu.fiuba.algo3.vista.equipamientos.EquipamientosPanel;
import edu.fiuba.algo3.vista.gladiador.EnergiaVista;
import edu.fiuba.algo3.vista.gladiador.GladiadorVista;
import edu.fiuba.algo3.vista.gladiador.senority.SenorityVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class PanelInferior extends HBox {
    private GladiadorVista gladiadorVista;

    public PanelInferior(GladiadorVista gladiador, EnergiaVista energia, SenorityVista senority, EquipamientosPanel equipamientosPanel){
        super();
        this.setMaxHeight(Double.MAX_VALUE);
        this.setMaxWidth(Double.MAX_VALUE);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setStyle("-fx-background-color:#323232");
        this.setAlignment(Pos.CENTER);

        this.agregarElementos(gladiador);
        this.agregarElementos(energia);
        this.agregarElementos(senority);
        this.agregarElementos(equipamientosPanel);

        this.gladiadorVista = gladiador;
    }

    public void agregarElementos(Node node){
        this.setSpacing(10);
        this.getChildren().add(node);
    }

    public void setColorGladiador(String color){
        this.gladiadorVista.cambiarColor(color);
    }
}
