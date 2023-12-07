package edu.fiuba.algo3.vista.panel;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class PanelInferior extends HBox {

    public PanelInferior(){
        super();
        this.setMaxHeight(20);
        this.setMaxWidth(Double.MAX_VALUE);
        this.setPadding(new Insets(10, 0, 10, 0));
        this.setStyle("-fx-background-color:#323232");
        this.setAlignment(Pos.CENTER);
    }

    public void agregarElementos(Node node){
        this.setSpacing(50);
        this.getChildren().add(node);
    }
}
