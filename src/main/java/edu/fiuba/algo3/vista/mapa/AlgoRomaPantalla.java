package edu.fiuba.algo3.vista.mapa;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.vista.dado.DadoButton;
import edu.fiuba.algo3.vista.mapa.components.Gladiadores;
import edu.fiuba.algo3.vista.mapa.components.MapaVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.HashMap;

public class AlgoRomaPantalla extends BorderPane {

    private AlgoRoma algoRoma;

    public AlgoRomaPantalla(AlgoRoma algoRoma, DadoButton dadoButton, HashMap<String, String> dirImagenesPorNombreGladiador) {

        super();

        this.algoRoma = algoRoma;

        // Columna Izquierda con perfiles de Gladiadores
        Gladiadores panelGladiadores = new Gladiadores(this.algoRoma, dirImagenesPorNombreGladiador);
        algoRoma.agregarObservador(panelGladiadores);
        this.setLeft(panelGladiadores);
        this.setMargin(panelGladiadores, new Insets(10, 10, 10, 10));


        //Creacion del camino

        MapaVista mapaVista = new MapaVista(algoRoma);
        this.setCenter(mapaVista);
        this.setMargin(mapaVista, new Insets(10, 10, 10, 10));


        //Panel Inferior - A modo de prueba
        HBox panelControl = new HBox();
        panelControl.getChildren().add(dadoButton);
        panelControl.setMaxHeight(20);
        panelControl.setMaxWidth(20);

        panelControl.setSpacing(8);
        panelControl.setPadding(new Insets(8));
        panelControl.setStyle("-fx-background-color:#323232");

        this.setBottom(panelControl);
        this.setMargin(panelControl, new Insets(10, 10, 10, 10));


        BorderPane.setAlignment(mapaVista, Pos.TOP_CENTER);
    }
}