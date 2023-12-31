package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controladores.observers.AlgoRomaObservador;
import edu.fiuba.algo3.modelo.AlgoRomaModelo;
import edu.fiuba.algo3.vista.menuBarra.MenuBarra;
import edu.fiuba.algo3.vista.dado.DadoButton;
import edu.fiuba.algo3.vista.gladiador.GladiadorAnimado;
import edu.fiuba.algo3.vista.mapa.MapaVista;
import edu.fiuba.algo3.vista.paneles_de_visualizacion.PanelInferior;
import edu.fiuba.algo3.vista.paneles_de_visualizacion.PanelLateralGladiadores;
import edu.fiuba.algo3.vista.paneles_de_visualizacion.PanelPrincipal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class AlgoRomaPantalla extends BorderPane implements AlgoRomaObservador {

    private static final Logger LOG = LoggerFactory.getLogger(AlgoRomaPantalla.class);

    private AlgoRomaModelo algoRoma;
    private final MapaVista mapaVista;
    private PanelLateralGladiadores panelPanelLateralGladiadores;
    private final Deque<PanelInferior> panelInferiorsDeque;
    private ArrayList<GladiadorAnimado> gladiadoresAnimados;
    private HashMap<String, String> colorPorClaveNombreGladiador;

    public AlgoRomaPantalla(Stage stage, AlgoRomaModelo algoRoma, DadoButton dadoButton, HashMap<String, String> colorPorClaveNombreGladiador, AudioClip sonidoFondo) {
        super();
        this.algoRoma = algoRoma;
        this.colorPorClaveNombreGladiador = colorPorClaveNombreGladiador;
        panelInferiorsDeque = new ArrayDeque<>();
        gladiadoresAnimados = new ArrayList<>();


        MenuBarra menuBarra = new MenuBarra(stage , sonidoFondo);
        this.setTop(menuBarra);

        this.panelPanelLateralGladiadores = new PanelLateralGladiadores(dadoButton);


        this.setLeft(panelPanelLateralGladiadores);
        this.setMargin(panelPanelLateralGladiadores, new Insets(5, 0, 5, 5));

        this.mapaVista = new MapaVista(algoRoma);
        PanelPrincipal panelPrincipal = new PanelPrincipal(algoRoma.getMapa(), mapaVista);
        this.setCenter(panelPrincipal);
        this.setMargin(panelPrincipal, new Insets(5, 5, 5, 5));

        BorderPane.setAlignment(mapaVista, Pos.TOP_CENTER);
        algoRoma.agregarObservadorNuevoTurno(this);
    }


    public void agregarPanelInferiorDeJugador(PanelInferior panelInferior) {
        this.panelInferiorsDeque.add(panelInferior);
        this.setMargin(panelInferior, new Insets(0,5,5,5));
    }

    public void agregarGladiador(GladiadorAnimado gladiadorAnimado) {
        this.gladiadoresAnimados.add(gladiadorAnimado);
        mapaVista.agregarGladiadorAlInicio(gladiadorAnimado);
    }

    @Override
    public void update() {
        PanelInferior popPanelInferior = this.panelInferiorsDeque.pop();
        this.setBottom(popPanelInferior);
        panelInferiorsDeque.add(popPanelInferior);

        this.panelPanelLateralGladiadores.actualizarGladiadorEnEspera();
    }

    public void actualizarOrdenDeGladiadores() {
        this.panelPanelLateralGladiadores.actualizarGladiadores(algoRoma.getNombresGladiadoresSegunOrdenEnRonda(),
                colorPorClaveNombreGladiador);
        this.actualizarOrdenYColorPanelInferior();
        this.actualizarColoresGladiadoresAnimados();
    }

    private void actualizarColoresGladiadoresAnimados(){

        for(GladiadorAnimado gladiadorAnimado : gladiadoresAnimados){
            String nombreGladiador = gladiadorAnimado.getNombre();
            String colorGladiador = colorPorClaveNombreGladiador.get(nombreGladiador);
            gladiadorAnimado.iniciarAnimacion(colorGladiador);
        }
    }

    private void actualizarOrdenYColorPanelInferior(){
        ArrayList<String> nombresGladiadores = algoRoma.getNombresGladiadoresSegunOrdenEnRonda();
        ArrayList<String> ordenNombresEnPanelInferior = algoRoma.getNombresGladiadoresSegunOrdenDeIngreso();
        ArrayList<PanelInferior> panelInferiors = new ArrayList<>(panelInferiorsDeque);

        for(int i = 0; i < nombresGladiadores.size(); i++){
            String nombreGladiador = nombresGladiadores.get(i);
            int indiceGladiadorEnPanelInferior = ordenNombresEnPanelInferior.indexOf(nombreGladiador);
            PanelInferior panelInferior = panelInferiors.get(indiceGladiadorEnPanelInferior);
            panelInferior.setColorGladiador(colorPorClaveNombreGladiador.get(nombreGladiador));
            panelInferiorsDeque.remove(panelInferior);
            panelInferiorsDeque.add(panelInferior);
        }
    }
}