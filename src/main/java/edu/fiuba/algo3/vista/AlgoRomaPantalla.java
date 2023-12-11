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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class AlgoRomaPantalla extends BorderPane implements ObservadorAlgoRoma {

    private static final Logger LOG = LoggerFactory.getLogger(AlgoRomaPantalla.class);

    private AlgoRoma algoRoma;
    private final MapaVista mapaVista;
    private PanelLateralGladiadores panelPanelLateralGladiadores;
    private final Deque<PanelInferior> panelInferiorsDeque;
    private ArrayList<GladiadorAnimado> gladiadoresAnimados;
    private HashMap<String, String> colorPorClaveNombreGladiador;

    public AlgoRomaPantalla(AlgoRoma algoRoma, DadoButton dadoButton, HashMap<String, String> colorPorClaveNombreGladiador) {
        super();
        this.algoRoma = algoRoma;
        this.colorPorClaveNombreGladiador = colorPorClaveNombreGladiador;
        panelInferiorsDeque = new ArrayDeque<>();
        gladiadoresAnimados = new ArrayList<>();

        // Columna Izquierda con perfiles de Gladiadores
        this.panelPanelLateralGladiadores = new PanelLateralGladiadores(dadoButton);


        this.setLeft(panelPanelLateralGladiadores);
        this.setMargin(panelPanelLateralGladiadores, new Insets(5, 0, 5, 5));

        //Creacion del camino

        this.mapaVista = new MapaVista(algoRoma);
        this.setCenter(mapaVista);
        this.setMargin(mapaVista, new Insets(5, 5, 5, 5));

        BorderPane.setAlignment(mapaVista, Pos.TOP_CENTER);

        File mediaFile = new File("src/main/resources/edu/fiuba/algo3/vista/media/gamemusic.mp3");
        try {
            Media media = new Media(mediaFile.toURI().toURL().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            this.getChildren().add(mediaView);
            mediaPlayer.play();
        }catch (MalformedURLException e){
            LOG.error("No se puede reproducir audio: " + e.getMessage(), e);
        }

        algoRoma.agregarObservadorNuevoTurno(this);
    }


    public void agregarPanelInferiorDeJugador(PanelInferior panelInferior) {
        this.panelInferiorsDeque.add(panelInferior);
        this.setMargin(panelInferior, new Insets(0,5,5,5));
    }

    public void agregarGladiador(GladiadorAnimado gladiadorAnimado) {
        //this.panelGladiadores.agregarGladiador();
        this.gladiadoresAnimados.add(gladiadorAnimado);
        mapaVista.agregarGladiadorAlInicio(gladiadorAnimado);
    }

    @Override
    public void update() {
        PanelInferior popPanelInferior = this.panelInferiorsDeque.pop();
        this.setBottom(popPanelInferior);
        panelInferiorsDeque.add(popPanelInferior);

        this.panelPanelLateralGladiadores.actualizarGladiadorEnEspera();
        //actualizarOrdenDeGladiadores();
    }

    public void actualizarOrdenDeGladiadores() {
        //this.panelGladiadores.visualizarNuevoGladiador();
        //esta funcion se llama en el pase de escena, temporal coupling?
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