package edu.fiuba.algo3.vista.mapa;

import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.gladiador.Energia;
import edu.fiuba.algo3.modelo.gladiador.senority.Senority;
import edu.fiuba.algo3.vista.dado.DadoButton;
import edu.fiuba.algo3.vista.equipamientos.EquipamientosPanel;
import edu.fiuba.algo3.vista.gladiador.EnergiaVista;
import edu.fiuba.algo3.vista.gladiador.Gladiador;
import edu.fiuba.algo3.vista.gladiador.GladiadorAnimado;
import edu.fiuba.algo3.vista.gladiador.senority.SenorityVista;
import edu.fiuba.algo3.vista.mapa.components.Gladiadores;
import edu.fiuba.algo3.vista.mapa.components.MapaVista;
import edu.fiuba.algo3.vista.panel.PanelInferior;
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
        PanelInferior panelInferior = new PanelInferior();

        EquipamientosPanel panelEquipamiento = new EquipamientosPanel();
        panelEquipamiento.setVgap(0);
        panelEquipamiento.setHgap(0);

        panelInferior.agregarElementos(dadoButton);
        panelInferior.agregarElementos(new Gladiador(100));
        panelInferior.agregarElementos(new EnergiaVista(new Energia(20),20));
        panelInferior.agregarElementos(new SenorityVista(new Senority()));
        panelInferior.agregarElementos(panelEquipamiento);

        this.setBottom(panelInferior);
        this.setMargin(panelInferior, new Insets(10, 10, 10, 10));

        BorderPane.setAlignment(panelInferior, Pos.CENTER);
        BorderPane.setAlignment(mapaVista, Pos.TOP_CENTER);
    }
}