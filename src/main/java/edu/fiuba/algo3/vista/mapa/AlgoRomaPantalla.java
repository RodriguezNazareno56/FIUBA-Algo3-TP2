package edu.fiuba.algo3.vista.mapa;

import edu.fiuba.algo3.controladores.observers.ObservadorAlgoRoma;
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
import javafx.scene.layout.BorderPane;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class AlgoRomaPantalla extends BorderPane implements ObservadorAlgoRoma {

    private final Deque<PanelInferior> panelInferiorsList;
    private final MapaVista mapaVista;

    private final Gladiadores panelGladiadores;

    public AlgoRomaPantalla(AlgoRoma algoRoma, DadoButton dadoButton, HashMap<String, String> dirImagenesPorNombreGladiador) {
        super();
        panelInferiorsList = new ArrayDeque<>();

        // Columna Izquierda con perfiles de Gladiadores
        Gladiadores panelGladiadores = new Gladiadores(algoRoma, dirImagenesPorNombreGladiador);
        this.panelGladiadores = panelGladiadores;
        algoRoma.agregarObservador(panelGladiadores);
        this.setLeft(panelGladiadores);
        this.setMargin(panelGladiadores, new Insets(10, 10, 10, 10));

        panelGladiadores.getChildren().add(dadoButton);


        //Creacion del camino

        this.mapaVista = new MapaVista(algoRoma);
        this.setCenter(mapaVista);
        this.setMargin(mapaVista, new Insets(10, 10, 10, 10));


        //Panel de Estado/Equipamiento de Gladiador

        PanelInferior panelInferior = new PanelInferior(new Gladiador(100),
                new EnergiaVista(new Energia(20),20),
                new SenorityVista(new Senority()),
                new EquipamientosPanel());

        this.setBottom(panelInferior);
        this.setMargin(panelInferior, new Insets(10, 10, 10, 10));

        BorderPane.setAlignment(panelInferior, Pos.CENTER);
        BorderPane.setAlignment(mapaVista, Pos.TOP_CENTER);

        algoRoma.agregarObservador(this);
    }

    public void agregarPanelInferiorDeJugador(PanelInferior panelInferior) {
        this.panelInferiorsList.add(panelInferior);
    }

    public void agregarGladiador(GladiadorAnimado gladiadorAnimado) {
        mapaVista.agregarGladiadorAlInicio(gladiadorAnimado);
    }

    @Override
    public void visualizarProximoPanelInferior() {
        PanelInferior popPanelInferior = this.panelInferiorsList.pop();
        this.setBottom(popPanelInferior);
        panelInferiorsList.add(popPanelInferior);
    }

    public void actualizarPanelGladiadores() {
        //this.panelGladiadores.visualizarNuevoGladiador();
        this.panelGladiadores.mostrarGladiadoresEnOrden();
    }

    public void visualizarNuevoGladiador() {

        //this.panelGladiadores.visualizarProximoPanelInferior();

    }
}