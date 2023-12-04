package edu.fiuba.algo3.vista.mapa.components;

import edu.fiuba.algo3.controladores.observers.Observable;
import edu.fiuba.algo3.controladores.observers.Observador;
import edu.fiuba.algo3.controladores.observers.ObservadorMapa;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.vista.gladiador.GladiadorAnimado;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.HashMap;

public class MapaVista extends GridPane implements ObservadorMapa {

    private HashMap<Gladiador, Coordenada> posicionDeGladiadores;

    public MapaVista(AlgoRoma algoRoma){


        Image imagen = new Image("File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/TexturaCesped-100-100.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        this.setAlignment(Pos.CENTER);
        this.setGridLinesVisible(true);
        this.setHgap(5); //Separacion horizontal entre celdas
        this.setVgap(5); //Separacion vertical entre celdas

        // Dibujar camino en Mapa

        algoRoma.getMapa()
                .getCamino()
                .getCeldas()
                .forEach(celda -> this.add(new CeldaVista(50, 50 ), celda.getCoordenada().getX(), celda.getCoordenada().getY()));

        algoRoma.getMapa().agregarObservador(this);
    }

    @Override
    public void actualizar(Gladiador gladiador, Coordenada coordenada) {
//        if (posicionDeGladiadores.containsKey(gladiador)) {
//            this.getChildren().remove(coordenada.)
//        }
        GladiadorAnimado gladiadorAnimado = new GladiadorAnimado();
        gladiadorAnimado.setFitWidth(50);
        gladiadorAnimado.setFitHeight(50);
        System.out.println("Actualizacion");
        this.add(gladiadorAnimado, coordenada.getX(), coordenada.getY() );

//        posicionDeGladiadores.put(gladiador, coordenada);
    }
}