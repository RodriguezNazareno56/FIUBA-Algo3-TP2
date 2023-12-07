package edu.fiuba.algo3.vista.mapa;

import edu.fiuba.algo3.controladores.observers.ObservadorAlgoRoma;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.vista.dado.DadoButton;
import edu.fiuba.algo3.vista.gladiador.GladiadorAnimado;
import edu.fiuba.algo3.vista.mapa.components.Gladiadores;
import edu.fiuba.algo3.vista.mapa.components.MapaVista;
import edu.fiuba.algo3.vista.panel.PanelInferior;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

import java.util.ArrayDeque;
import java.util.Deque;

public class AlgoRomaPantalla extends BorderPane implements ObservadorAlgoRoma {

    private final Deque<PanelInferior> panelInferiorsDeque;
    private final MapaVista mapaVista;
    private Gladiadores panelGladiadores;

    public AlgoRomaPantalla(AlgoRoma algoRoma, DadoButton dadoButton) {
        super();
        panelInferiorsDeque = new ArrayDeque<>();

        // Columna Izquierda con perfiles de Gladiadores
        this.panelGladiadores = new Gladiadores(algoRoma);
        this.setLeft(panelGladiadores);
        this.setMargin(panelGladiadores, new Insets(10, 10, 10, 10));

        panelGladiadores.getChildren().add(dadoButton);


        //Creacion del camino

        this.mapaVista = new MapaVista(algoRoma);
        this.setCenter(mapaVista);
        this.setMargin(mapaVista, new Insets(10, 10, 10, 10));

        BorderPane.setAlignment(mapaVista, Pos.TOP_CENTER);

        algoRoma.agregarObservador(this);
    }

    public void agregarPanelInferiorDeJugador(PanelInferior panelInferior) {
        this.panelInferiorsDeque.add(panelInferior);
    }

    public void agregarGladiador(GladiadorAnimado gladiadorAnimado) {
        this.panelGladiadores.agregarGladiador();
        mapaVista.agregarGladiadorAlInicio(gladiadorAnimado);
    }

    @Override
    public void visualizarProximoPanelInferior() {
        PanelInferior popPanelInferior = this.panelInferiorsDeque.pop();
        this.setBottom(popPanelInferior);
        panelInferiorsDeque.add(popPanelInferior);
    }
}