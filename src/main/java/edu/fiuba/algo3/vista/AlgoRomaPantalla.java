package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controladores.observers.ObservadorAlgoRoma;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.vista.dado.DadoButton;
import edu.fiuba.algo3.vista.gladiador.GladiadorAnimado;
import edu.fiuba.algo3.vista.mapa.MapaVista;
import edu.fiuba.algo3.vista.paneles_de_visualizacion.PanelInferior;
import edu.fiuba.algo3.vista.paneles_de_visualizacion.PanelLateralGladiadores;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class AlgoRomaPantalla extends BorderPane implements ObservadorAlgoRoma {

    private final Deque<PanelInferior> panelInferiorsDeque;
    private final MapaVista mapaVista;

    private PanelLateralGladiadores panelPanelLateralGladiadores;

    public AlgoRomaPantalla(AlgoRoma algoRoma, DadoButton dadoButton, HashMap<String, String> dirImagenesPorNombreGladiador) {
        super();
        panelInferiorsDeque = new ArrayDeque<>();

        // Columna Izquierda con perfiles de Gladiadores
        this.panelPanelLateralGladiadores = new PanelLateralGladiadores(algoRoma, dirImagenesPorNombreGladiador);
        algoRoma.agregarObservador(panelPanelLateralGladiadores);

        this.setLeft(panelPanelLateralGladiadores);
        this.setMargin(panelPanelLateralGladiadores, new Insets(10, 10, 10, 10));

        panelPanelLateralGladiadores.getChildren().add(dadoButton);


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
        //this.panelGladiadores.agregarGladiador();
        mapaVista.agregarGladiadorAlInicio(gladiadorAnimado);
    }

    @Override
    public void visualizarProximoPanelInferior() {
        PanelInferior popPanelInferior = this.panelInferiorsDeque.pop();
        this.setBottom(popPanelInferior);
        panelInferiorsDeque.add(popPanelInferior);
    }

    public void actualizarPanelGladiadores() {
        //this.panelGladiadores.visualizarNuevoGladiador();
        this.panelPanelLateralGladiadores.mostrarGladiadoresEnOrden();
    }

    public void visualizarNuevoGladiador() {

        //this.panelGladiadores.visualizarProximoPanelInferior();

    }
}