package edu.fiuba.algo3.vista.paneles_de_visualizacion;

import edu.fiuba.algo3.controladores.observers.ObservadorMapa;
import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.consecuencias.IConsecuencia;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.vista.mapa.MapaVista;
import edu.fiuba.algo3.vista.paneles_de_visualizacion.componentes.PantallaInfo;
import edu.fiuba.algo3.vista.paneles_de_visualizacion.componentes.PantallaInfoFactory;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.util.List;

public class PanelPrincipal extends StackPane implements ObservadorMapa {
    private final Mapa mapa;
    private final MapaVista mapaVista;
    public PanelPrincipal(Mapa mapa, MapaVista mapaVista) {
        mapa.agregarObservador(this);
        this.mapa = mapa;
        this.mapaVista = mapaVista;
        this.getChildren().add(mapaVista);

        // elimina pantallas con un click
        this.setOnMouseClicked(event -> {
            eliminarUltimoObjetoDelStack();
        });
    }

    @Override
    public void actualizar(Gladiador gladiador, Coordenada coordenada) {
        limpiarPantalla();
        ICelda celda = mapa.getPosicionDeGladiador(gladiador);
        List<IConsecuencia> consecuencias = celda.getConsecuencias();
        for (IConsecuencia consecuencia : consecuencias) {
            this.agregarPantallaInformacionConDelay(consecuencia, gladiador);
        }
    }

    public void agregarPantallaInformacionConDelay(IConsecuencia consecuencia, Gladiador gladiador) {
        Duration duration = Duration.seconds(0.5);
        KeyFrame keyFrame = new KeyFrame(duration, event -> {
            agregarPantallaInformacion(consecuencia, gladiador);
        });

        Timeline timeline = new Timeline(keyFrame);
        timeline.play();
    }

    public void agregarPantallaInformacion(IConsecuencia consecuencia, Gladiador gladiador) {
        PantallaInfoFactory pantallaInfoFactory = new PantallaInfoFactory();
        PantallaInfo pantallaInfo;
        try {
            pantallaInfo = pantallaInfoFactory.getPantallaInfo(consecuencia, gladiador);
            this.getChildren().add((VBox)pantallaInfo);
            limpiarPantallaEnTiempo(pantallaInfo);
        }
        catch (NullPointerException ignore) {}
    }

    private void eliminarUltimoObjetoDelStack() {
        var children = this.getChildren();

        // Verificar si hay más de un objeto presente antes de eliminar el último objeto
        if (this.getChildren().size() > 1) {
            children.remove(children.size() - 1);
        }
    }

    private void limpiarPantalla() {
        this.getChildren().clear();
        this.getChildren().add(mapaVista);
    }

    private void limpiarPantallaEnTiempo(PantallaInfo pantallaInfo) {
        Duration duration = Duration.seconds(6);
        KeyFrame keyFrame = new KeyFrame(duration, event -> {
            this.getChildren().remove((VBox) pantallaInfo);
        });

        Timeline timeline = new Timeline(keyFrame);
        timeline.play();
    }
}
