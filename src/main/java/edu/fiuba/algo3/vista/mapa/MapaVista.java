package edu.fiuba.algo3.vista.mapa;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.vista.mapa.componentes.CaminoVista;
import edu.fiuba.algo3.vista.mapa.componentes.Gladiadores;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapaVista extends BorderPane{

    private AlgoRoma algoRoma;

    public MapaVista(AlgoRoma algoRoma) {

        super();

        this.algoRoma = algoRoma;


        // Columna Izquierda con perfiles de Gladiadores
        Gladiadores panelGladiadores = new Gladiadores(this.algoRoma);
        algoRoma.agregarObservador(panelGladiadores);
        this.setLeft(panelGladiadores);
        this.setMargin(panelGladiadores, new Insets(10, 10, 10, 10));


        //Creacion del camino

        CaminoVista caminoVista = new CaminoVista(algoRoma);
        this.setCenter(caminoVista);
        this.setMargin(caminoVista, new Insets(10, 10, 10, 10));


        //Panel Inferior - A modo de prueba
        HBox panelInferior = new HBox();

        for (int i = 0; i < 19; i++) {
            panelInferior.getChildren().add(new Rectangle(60, 60, Color.DARKGRAY));
        }

        panelInferior.setSpacing(8);
        panelInferior.setPadding(new Insets(8));
        panelInferior.setStyle("-fx-background-color:#323232");
        this.setBottom(panelInferior);
        this.setMargin(panelInferior, new Insets(10, 10, 10, 10));


        BorderPane.setAlignment(caminoVista, Pos.TOP_CENTER);


    }




}