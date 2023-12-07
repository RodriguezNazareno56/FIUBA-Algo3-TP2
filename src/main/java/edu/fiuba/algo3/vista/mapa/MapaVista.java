package edu.fiuba.algo3.vista.mapa;

import edu.fiuba.algo3.controladores.observers.ObservadorMapa;
import edu.fiuba.algo3.modelo.AlgoRoma;
import edu.fiuba.algo3.modelo.celda.Coordenada;
import edu.fiuba.algo3.modelo.celda.ICelda;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.vista.celda.CeldaVista;
import edu.fiuba.algo3.vista.consecuencias.ConsecuenciaManager;
import edu.fiuba.algo3.vista.gladiador.GladiadorAnimado;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.HashMap;

public class MapaVista extends GridPane implements ObservadorMapa {

    private final HashMap<String, GladiadorAnimado> gladiadorAnimadoEnElMapa;
    private final AlgoRoma algoRoma;

    public MapaVista(AlgoRoma algoRoma){
        this.gladiadorAnimadoEnElMapa = new HashMap<>();
        this.algoRoma = algoRoma;

        Image imagen = new Image("File:src/main/resources/edu/fiuba/algo3/vista/mapa/components/TexturaCesped-100-100.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        this.setAlignment(Pos.CENTER);
        this.setGridLinesVisible(true);
        this.setHgap(5); //Separacion horizontal entre celdas
        this.setVgap(5); //Separacion vertical entre celdas

        // Dibujar camino en Mapa
        ConsecuenciaManager consecuenciaManager = new ConsecuenciaManager();

        algoRoma.getMapa()
                .getCamino()
                .getCeldas()
                .forEach(celda -> {
                    this.add(new CeldaVista(50, 50 ), celda.getCoordenada().getX(), celda.getCoordenada().getY());
                    consecuenciaManager.agregarAnimaciones(celda.getConsecuencias(),this,celda.getCoordenada());
                });

        algoRoma.getMapa().agregarObservador(this);
    }

    @Override
    public void actualizar(Gladiador gladiador, Coordenada coordenada) {
        GladiadorAnimado gladiadorAnimado = gladiadorAnimadoEnElMapa.get(gladiador.getNombre());
        this.getChildren().remove(gladiadorAnimado);
        this.add(gladiadorAnimado, coordenada.getX(), coordenada.getY() );
        gladiadorAnimadoEnElMapa.put(gladiador.getNombre(), gladiadorAnimado);       
    }

    public void agregarGladiadorAlInicio(GladiadorAnimado gladiadorAnimado) {
        ICelda celdaSalida = this.algoRoma.getMapa().getCamino().getCeldaSalida();
        Coordenada coordenadaSalida = celdaSalida.getCoordenada();
        gladiadorAnimado.setFitWidth(50);
        gladiadorAnimado.setFitHeight(50);
        this.add(gladiadorAnimado, coordenadaSalida.getX(), coordenadaSalida.getY());
        gladiadorAnimadoEnElMapa.put(gladiadorAnimado.getNombre(), gladiadorAnimado);
    }
}