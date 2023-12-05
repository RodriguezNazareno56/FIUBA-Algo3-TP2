package edu.fiuba.algo3.vista.mapa;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.vista.dado.DadoButton;
import edu.fiuba.algo3.vista.equipamientos.EquipamientosPanel;
import edu.fiuba.algo3.vista.gladiador.GladiadorAnimado;
import edu.fiuba.algo3.vista.mapa.components.Gladiadores;
import edu.fiuba.algo3.vista.mapa.components.MapaVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class AlgoRomaPantalla extends BorderPane {

    private AlgoRoma algoRoma;

    public AlgoRomaPantalla(AlgoRoma algoRoma, DadoButton dadoButton) {

        super();

        this.algoRoma = algoRoma;

        // Columna Izquierda con perfiles de Gladiadores
        Gladiadores panelGladiadores = new Gladiadores(this.algoRoma);
        algoRoma.agregarObservador(panelGladiadores);
        this.setLeft(panelGladiadores);
        this.setMargin(panelGladiadores, new Insets(10, 10, 10, 10));


        //Creacion del camino

        MapaVista mapaVista = new MapaVista(algoRoma);
        this.setCenter(mapaVista);
        this.setMargin(mapaVista, new Insets(10, 10, 10, 10));


        //Panel de Estado/Equipamiento de Gladiador

       HBox panelInferior = new HBox();

       panelInferior.setMaxHeight(20);
       panelInferior.setMaxWidth(Double.MAX_VALUE);
       //panelInferior.setSpacing(10);
        //ARRIBA  -     - ABAJO    -
         panelInferior.setPadding(new Insets(10, 0, 10, 0));
       panelInferior.setStyle("-fx-background-color:#323232");
       panelInferior.setAlignment(Pos.CENTER);

       EquipamientosPanel panelEquipamiento = new EquipamientosPanel();
       panelEquipamiento.setVgap(0);
       panelEquipamiento.setHgap(0);

       panelInferior.getChildren().add(panelEquipamiento);
       panelInferior.getChildren().add(dadoButton);




        this.setBottom(panelInferior);
        this.setMargin(panelInferior, new Insets(10, 10, 10, 10));

        BorderPane.setAlignment(panelInferior, Pos.CENTER);
        BorderPane.setAlignment(mapaVista, Pos.TOP_CENTER);
    }
}